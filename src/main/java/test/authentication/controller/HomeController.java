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
package test.authentication.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import com.nimbusds.jose.util.Base64;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.token.jwt.signature.secret.SecretSignatureConfiguration;
import test.authentication.domain.configuration.helper.Common;
import test.authentication.repository.EmailRepository;
import test.authentication.services.HomeService;
import java.security.Principal;
import java.util.HashMap;

@Secured(SecurityRule.IS_ANONYMOUS)
@Controller("/")
public class HomeController {
    private static HomeService homeService;
    private final EmailRepository emailRepository;

    public HomeController(HomeService homeService,EmailRepository emailRepository){
        this.homeService = homeService;
        this.emailRepository = emailRepository;
    }

    @Get("/")
    String index(Principal principal){
        Base64 encode = Base64.encode("Name:Bobby|Nick Name:Akyong|E-mail:bobby@tokodistributor.com|Mobile Phone Number:+6281293308020|Facebook:/kyongx|Twitter:@ryokyong|lat:-6.1325333|long:106.7681801,17z");
        String abcd = "Qm9iYnlAdG9rb2Rpc3RyaWJ1dG9yLmNvbXwrNjI4MTI5MzMwODAyMA==";
        byte[] stringbyte = java.util.Base64.getDecoder().decode(abcd);
        String decoder = "";
//        URL decoder = Base64.class.getProtectionDomain().getCodeSource().getLocation();
        try{
            decoder = new String(stringbyte, "UTF-8");
            System.out.println("stringtoEndode "+decoder);
        }
        catch (Exception e){
            System.out.println("error = "+e);
        }
        SecretSignatureConfiguration abc = new SecretSignatureConfiguration("secret");
        return principal.getName();
    }


    @Get("/api/checking")
    public void checkPhoneNoOrEmail(HttpRequest<?> request){
        String via = request.getParameters().get("via");
        if(via.equals(Common.VIA_EMAIL)){
            String email = request.getParameters().get("email");
            boolean existOrNot = homeService.checkEmail(email);
            if (existOrNot){

            }
        }
        if(via.equals(Common.VIA_MOBILE_PHONE_NO)){
            String number = request.getParameters().get("mobilePhoneNo");
            boolean existOrNot = homeService.checkEmail(number);
            if(existOrNot){
                HashMap map = new HashMap();
                map.put("destination",number);
                map.put("otp",RandomInt());
                emailRepository.sendSms("OTP",map);
            }

        }
    }

    public int RandomInt(){
        int random = (int )(Math.random() * 9999 + 1);
        return random;
    }

}