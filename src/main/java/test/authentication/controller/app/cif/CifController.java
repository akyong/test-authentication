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

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.validation.Validated;
import test.authentication.SortingAndOrderArguments;
import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.configuration.ApplicationConfiguration;
import test.authentication.domain.configuration.helper.Common;
import test.authentication.services.app.cif.CifService;
import test.authentication.validation.CifSaveValidation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.List;

@Validated
@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller("/cif")
public class CifController {

    private static CifService cifService;

    @PersistenceContext
    private EntityManager entityManager;

    public CifController(EntityManager entityManager, CifService cifService){
        this.entityManager = entityManager;
        this.cifService = cifService;
    }

    @Secured({Common.ROLE_ADMIN, Common.ROLE_CORP_ADMIN})
    @Get(value = "/index{?args*}")
    public List<Cif> index(@Valid SortingAndOrderArguments args) {
        return cifService.findAll(args);
    }

    @Secured({Common.ROLE_ADMIN, Common.ROLE_CORP_ADMIN})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Post("/create")
    public HttpResponse<Cif> save(@Body CifSaveValidation cmd) {
       Cif cif = cifService.save(
               cmd.getCifId(),
               cmd.getCorpName(),
               cmd.getAddress1(),
               cmd.getAddress2(),
               new Date(), //joinDate sementara dibuat tanggal buat
               "N",
               new Date(),
               null,
               null,
               "1"
            );

        return HttpResponse
                .created(cif)
                .headers(headers -> headers.location(location(cif.getId())));
    }

    protected URI location(Long id) {
        return URI.create("/cif/" + id);
    }

    protected URI location(Cif cif) {
        return location(cif.getId());
    }

}
