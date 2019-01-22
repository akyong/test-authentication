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


package test.authentication.services;

import io.micronaut.security.authentication.*;
import io.micronaut.security.authentication.providers.PasswordEncoder;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.authentication.domain.security.User;
import test.authentication.services.security.LoginHistoryService;
import test.authentication.services.security.UserRoleService;
import test.authentication.services.security.UserService;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationProviderUserPassword.class);
    private static UserService userService;
    private static UserRoleService userRoleService;
    private static LoginHistoryService loginHistoryService;
    protected final PasswordEncoder passwordEncoder;

    public AuthenticationProviderUserPassword(UserService userService, UserRoleService userRoleService, LoginHistoryService loginHistoryService, PasswordEncoder passwordEncoder){
        this.userService = userService;
        this.userRoleService = userRoleService;
        this.loginHistoryService = loginHistoryService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @params AuthenticationRequest as UsernamePaswordCredentials
     * @return T as Flowable
     * */
    @Override
    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
        String email = authenticationRequest.getIdentity().toString();
        String password = authenticationRequest.getSecret().toString();
        User user = userService.findByEmail(email);//username yang diinput
        if(user != null){
            LOG.info("BOOLEAN = "+passwordEncoder.matches(password,user.getPassword()));
            if(passwordEncoder.matches(password,user.getPassword())){
                ArrayList roles = userRoleService.findAllByUser(user);
                UserDetails userDetails = new UserDetails((String) authenticationRequest.getIdentity(), roles);
                loginHistoryService.save(user.getId().toString(),"-", new Date(), null);
                return Flowable.just(userDetails);
            }
        }
        return Flowable.just(new AuthenticationFailed());
    }


//    @Override
//    public Publisher<AuthenticationResponse> authenticate(AuthenticationRequest authenticationRequest) {
//        String email = authenticationRequest.getIdentity().toString();
//        String password = authenticationRequest.getSecret().toString();
//        if ( authenticationRequest.getIdentity().equals("bobby@tokodistributor.com") &&
//                authenticationRequest.getSecret().equals("password") ) {
//            return Flowable.just(new UserDetails((String) authenticationRequest.getIdentity(), new ArrayList<>()));
//        }
//        return Flowable.just(new AuthenticationFailed());
//    }
}