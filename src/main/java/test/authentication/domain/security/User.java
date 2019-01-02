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

package test.authentication.domain.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class User {

    public User(){}

    public User(@NotNull String username, @NotNull String password, @NotNull boolean enabled, @NotNull boolean accountExpired, @NotNull boolean accountLocked, @NotNull boolean passwordExpired){
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
        this.passwordExpired = passwordExpired;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Column(name="username",nullable = false, unique = true) //set unique true
    private String username;

    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name ="enabled")
    private boolean enabled;

    @NotNull
    @Column(name = "account_expired")
    private boolean accountExpired;

    @NotNull
    @Column(name = "account_locked")
    private boolean accountLocked;

    @NotNull
    @Column(name = "password_expired")
    private boolean passwordExpired;

    /**
     * Configuration for Join to table userDetails
     * @return
     */

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private UserDetails userDetails;

    /**
     * End of Configuration for join to table userDetails
     * @return
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; } //set id gak boleh ada

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) { this.version = version; }

    public void setUsername(@NotNull String username){ this.username = username; }

    public String getUsername() { return username; }

    public void setPassword(@NotNull String password){ this.password = password; }

    public String getPassword(){ return password; }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() { //getEnabled
        return enabled;
    }

    public void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public boolean isAccountExpired() {
        return accountExpired;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public boolean isPasswordExpired() {
        return passwordExpired;
    }

//    public void setUserDetails(UserDetails userDetails) {
//        this.userDetails = userDetails;
//    }
//
//    public UserDetails getUserDetails() {
//        return userDetails;
//    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("User{");
        sb.append("id=");
        sb.append(id);
        sb.append(", version=");
        sb.append(version);
        sb.append(", username='");
        sb.append(username);
        sb.append("', password=");
        sb.append("'Protected Bro!'");
        sb.append(", accountExpired");
        sb.append(accountExpired);
        sb.append(", accountLocked=");
        sb.append(accountLocked);
        sb.append(", passwordExpired=");
        sb.append(passwordExpired);
        sb.append("'}");
        return sb.toString();
    }
}
