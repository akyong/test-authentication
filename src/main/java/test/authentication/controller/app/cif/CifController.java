/**
 * Copyright (c) 2019. PT. Distributor Indonesia Unggul. All rights reserverd.
 *
 * This source code is an unpublished work and the use of  a copyright  notice
 * does not imply otherwise. This source  code  contains  confidential,  trade
 * secret material of PT. Distributor Indonesia Unggul.
 * Any attempt or participation in deciphering, decoding, reverse  engineering
 * or in any way altering the source code is strictly  prohibited, unless  the
 * prior  written consent of Distributor Indonesia Unggul. is obtained.
 *
 * Unless  required  by  applicable  law  or  agreed  to  in writing, software
 * distributed under the License is distributed on an "AS IS"  BASIS,  WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or  implied.  See  the
 * License for the specific  language  governing  permissions  and limitations
 * under the License.
 *
 * Author : Bobby
 */

package test.authentication.controller.app.cif;

import com.fasterxml.jackson.core.JsonParseException;
import io.micronaut.http.*;
import io.micronaut.http.annotation.*;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.hateos.JsonError;
import io.micronaut.http.hateos.Link;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.utils.SecurityService;
import io.micronaut.validation.Validated;
import test.authentication.SortingAndOrderArguments;
import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.app.cif.CifUser;
import test.authentication.domain.configuration.ApplicationConfiguration;
import test.authentication.domain.configuration.helper.Common;
import test.authentication.domain.security.User;
import test.authentication.domain.security.UserDetails;
import test.authentication.services.app.cif.CifService;
import test.authentication.services.app.cif.CifUserService;
import test.authentication.services.app.cif.UserDetailsService;
import test.authentication.services.security.BCryptPasswordEncoderService;
import test.authentication.services.security.UserService;
import test.authentication.validation.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import java.net.URI;
import java.security.Principal;
import java.util.*;
import java.util.logging.Logger;

@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/cif")
public class CifController {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static CifService cifService;
    private static CifUserService cifUserService;
    private static UserService userService;
    private static UserDetailsService userDetailsService;
    private static BCryptPasswordEncoderService bCryptPasswordEncoderService;
    private static ApplicationConfiguration applicationConfiguration;
    private static SecurityService securityService;


    public CifController(UserDetailsService userDetailsService, CifService cifService, CifUserService cifUserService, UserService userService, BCryptPasswordEncoderService bCryptPasswordEncoderService, ApplicationConfiguration applicationConfiguration,SecurityService securityService){
        this.cifService = cifService;
        this.cifUserService = cifUserService;
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoderService = bCryptPasswordEncoderService;
        this.applicationConfiguration = applicationConfiguration;
        this.securityService = securityService;
    }

    /**
     * TODO : cif root page to get list of cif /cif/
     * this function can only access whom has the role ROLE_ADMIN
     * */
    @Secured(Common.ROLE_ADMIN)
    @Get("/")
    public ArrayList root() {
//        boolean isCorpAdmin = securityService.hasRole(Common.ROLE_CORP_ADMIN);
        SortingAndOrderArguments args = new SortingAndOrderArguments();
        args.setOrder("desc");
        args.setSort("dateCreated");
        args.setMax(applicationConfiguration.getMax());
        return cifService.findAll(args);

    }

    /**
     * TODO : filter list of cif /cif/index
     * this function can only access whom has the role ROLE_ADMIN
     * */
    @Secured(Common.ROLE_ADMIN)
    @Get(value = "/index{?args*}")
    public ArrayList index(@Valid SortingAndOrderArguments args) {
        return cifService.findAll(args);
    }

    /**
     * TODO : Create Cif, User, UserDetails and CifUser /cif/create
     * siapa yang bisa membuat ini?????????????????????
     */
    @Secured({Common.ROLE_ADMIN, Common.ROLE_CORP_ADMIN})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Post("/create")
    public HttpResponse<ArrayList> save(@Body @Valid CifSaveValidation cmdCifSave, @Body @Valid UserValidation cmdUserSave, @Body @Valid UserDetailsValidation cmdUserDetailsSave, @Body @Valid CifUserValidation cmdCifUserValidation, Principal principal) {
        /*
        * Before this, please add jQuery AJAX for check
        * from Front End to check about
        * @username, @email and @cifId already used or not
        * */

        Cif cifInstance = cifService.save(
                cmdCifSave.getCifId(),
                cmdCifSave.getCorpName(),
                cmdCifSave.getType(),
                cmdCifSave.getAddress1(),
                cmdCifSave.getAddress2(),
                new Date(), //joinDate sementara dibuat tanggal buat
                "N",
                new Date(),
                null,
                null,
                "1"
        );

        String password = bCryptPasswordEncoderService.encode(applicationConfiguration.getDefaultPassword());
        User userInstance = createUser(cmdUserSave.getEmail(), cmdUserSave.getUsername(), password, true, false, false, null);
        UserDetails userDetailsInstance = createUserDetails(
                cmdUserDetailsSave.getFirstName(),
                cmdUserDetailsSave.getLastName(),
                userInstance,
                cifInstance,
                cmdUserDetailsSave.getUserAlias(),
                cmdUserSave.getEmail(),
                cmdUserDetailsSave.getMobilePhoneNo(),
                "active",
                principal.getName(),//createdby
                new Date(),
                null,
                null,
                "in",
                null,
                null,
                null,
                null
        );

        CifUser cifUserInstance = createCifUser(
                cifInstance,
                cmdCifUserValidation.getFirstName(),
                cmdCifUserValidation.getLastName(),
                userDetailsInstance ,
                "N",
                principal.getName(),
                new Date(),
                null,
                null,
                "Y",
                "N",
                "Y"
        );

        ArrayList response = new ArrayList();
        HashMap map = new HashMap();
        map.put("Cif",cifInstance);
        map.put("User Details", userDetailsInstance);
        map.put("Cif User",cifUserInstance);
        response.add(map);

        return HttpResponse
                .created(response)
                .headers(headers -> headers.location(location(cifInstance.getId())));
    }

    /**
     * TODO : update Cif information /cif/update
     * */
    @Secured({Common.ROLE_ADMIN,Common.ROLE_CORP_ADMIN})
    @Put(value = "/update")
    public HttpResponse update(@Body @Valid CifUpdateValidation cmdCifUpdate){
        cifService.update(
                cmdCifUpdate.getId(),
                cmdCifUpdate.getCorpName(),
                cmdCifUpdate.getType(),
                cmdCifUpdate.getAddress1(),
                cmdCifUpdate.getAddress2()
        );

        return HttpResponse.noContent()
                .header(HttpHeaders.LOCATION, location(cmdCifUpdate.getId()).getPath());
    }

    /**
     * TODO : show or display the cif information /cif/show/{id}
     * just the BackOffice and Corporate Admin can see corporate information
     * */
    @Get(value = "/show/{id}")
    public Cif show(Long id){
        return cifService.findById(id);
    }

    /**
     * TODO : find CifId already exist or not when trying to create Cif '/create' /cif/findAllByCifId
     * This method must be just return
     * */
    @Secured({Common.ROLE_ADMIN,Common.ROLE_ADMIN})
    @Get(value = "/findAllByCifId")
    public HttpResponse<List> findAllByCifId(HttpRequest<?> request){
        Cif cif = cifService.findAllByCifId(request.getParameters().get("cifId"));
        ArrayList response = new ArrayList();
        HashMap map = new HashMap();

        if(cif == null){
            map.put("status", 404);
            map.put("message","Corporate Id boleh dipakai!");
            response.add(map);
            return HttpResponse
                    .notFound(response);

        }
        else {
            map.put("status", 200);
            map.put("message","Corporate Id sudah dipakai!");
            response.add(map);
            return HttpResponse
                    .ok(response);
        }
    }

    @Error
    public HttpResponse<JsonError> jsonError(HttpRequest request, JsonParseException jsonParseException) {
        JsonError error = new JsonError("Invalid JSON: " + jsonParseException.getMessage())
                .link(Link.SELF, Link.of(request.getUri()));

        return HttpResponse.<JsonError>status(HttpStatus.BAD_REQUEST, "Fix Your JSON")
                .body(error);
    }

    protected URI location(Long id) {
        return URI.create("/cif/show/" + id);
    }

    protected URI location(Cif cif) {
        return location(cif.getId());
    }

    /**
     * TODO : Function to create User
     * */
    public User createUser(String email, String username, String password, boolean enabled, boolean accountExpired, boolean accountLocked, Date passwordExpired){
        User user = new User();

        logger.info("----------------------------------- PASSWORD = "+password);
        User findUserByEmail = userService.findByEmail(email);
        if(findUserByEmail == null){
            logger.info("\n----------------------------------- USER");
            user = userService.save(email, username, password, enabled, accountExpired, accountLocked);
        }
        logger.info("\n----------------------------------- USER "+user);

        return user;
    }

    /**
     * TODO : Function to create UserDetails
     * */
    public UserDetails createUserDetails(String firstName,
                                         String lastName,
                                         User userInstance,
                                         Cif cifInstance,
                                         String userAlias,
                                         @Email String email,
                                         String mobilePhone,
                                         String status,
                                         String createdBy,
                                         Date dateCreated,
                                         String updatedBy,
                                         Date lastUpdated,
                                         String language,
                                         String ipAddress,
                                         String jwtId,
                                         Date loginTime,
                                         Date logoutTime){
        UserDetails userDetails = userDetailsService.save(
                firstName,
                lastName,
                userInstance,
                cifInstance,
                userAlias,
                email,
                mobilePhone,
                status,
                createdBy,
                dateCreated,
                updatedBy,
                lastUpdated,
                language,
                ipAddress,
                jwtId,
                loginTime,
                logoutTime
        );

        return userDetails;
    }

    /**
     * TODO : Function to create CifUSer
     * */
    public CifUser createCifUser(Cif cif, String firstName, String lastName, UserDetails userDetails, String deleteFlag, String createdBy, Date dateCreated, String updateBy, Date lastUpdated, String bo, String finance, String sysAdmin){
        CifUser cifUser = cifUserService.save(
                cif,
                firstName,
                lastName,
                userDetails ,
                deleteFlag,
                createdBy,
                dateCreated,
                updateBy,
                lastUpdated,
                bo,
                finance,
                sysAdmin
        );
        return cifUser;
    }
}
