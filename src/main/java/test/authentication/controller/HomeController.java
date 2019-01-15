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

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import com.nimbusds.jose.util.Base64;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.token.jwt.signature.secret.SecretSignatureConfiguration;
import java.security.Principal;

@Secured("isAuthenticated()")
@Controller("/")
public class HomeController {

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


}