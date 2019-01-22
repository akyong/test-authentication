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
package test.authentication.validation;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserValidation {
    @NotNull
    @Email
    private String email;

//    @NotNull
//    private String password;

    @NotNull
    private String username;

    /*
     * password expired is a Date
     * the date when the password will expired or use for the last time
     * */
    private Date passwordExpired;

    public UserValidation(){

    }

    public UserValidation(@NotNull String email, @NotNull String username, Date passwordExpired){ this.email=email; this.username=username; this.passwordExpired = passwordExpired;}

    public void setUsername(@NotNull String username){ this.username = username; }

    public String getUsername() { return username; }

    public void setEmail(@NotNull @Email String email){ this.email = email; }

    public String getEmail() { return email; }

//    public void setPassword(@NotNull String password){ this.password = password; }
//
//    public String getPassword(){ return password; }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public boolean isEnabled() { //getEnabled
//        return enabled;
//    }
//
//    public void setAccountExpired(boolean accountExpired) {
//        this.accountExpired = accountExpired;
//    }
//
//    public boolean isAccountExpired() {
//        return accountExpired;
//    }
//
//    public void setAccountLocked(boolean accountLocked) {
//        this.accountLocked = accountLocked;
//    }
//
//    public boolean isAccountLocked() {
//        return accountLocked;
//    }
//
    public void setPasswordExpired(Date passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Date isPasswordExpired() {
        return passwordExpired;
    }
}
