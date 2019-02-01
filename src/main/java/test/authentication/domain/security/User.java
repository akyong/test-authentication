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

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="user")
public class User {

    public User(){}

    public User(@NotNull @Email String email, @NotNull String mobilePhoneNo, @NotNull String password, @NotNull boolean enabled, @NotNull boolean accountExpired, @NotNull boolean accountLocked){
        this.email = email;
        this.mobilePhoneNo = mobilePhoneNo;
        this.password = password;
        this.enabled = enabled;
        this.accountExpired = accountExpired;
        this.accountLocked = accountLocked;
//        this.passwordExpired = passwordExpired;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @JsonIgnore
    @Email
    @Column(name="email",nullable = false, unique = true) //set unique true
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "mobile_phone_number", nullable = false, unique = true)
    private String mobilePhoneNo;

    @NotNull
    @Column(name ="enabled")
    private boolean enabled;

    @NotNull
    @Column(name = "account_expired")
    private boolean accountExpired;

    @NotNull
    @Column(name = "account_locked")
    private boolean accountLocked;

    /*
    * password expired is a Date
    * the date when the password will expired or use for the last time
    * */
    @Column(name = "password_expired")
    private Date passwordExpired;

    /**
     * Configuration for Join to table UserDetails
     */
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = UserDetails.class)
//    private UserDetails userDetails;

    /**
     * Configuration for Join to table UserRole
     */
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user",targetEntity = UserRole.class)
//    private UserRole userRole;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; } //set id gak boleh ada

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) { this.version = version; }

    public String getMobilePhoneNo() { return mobilePhoneNo; }

    public void setMobilePhoneNo(String mobilePhoneNo) { this.mobilePhoneNo = mobilePhoneNo; }

    public void setEmail(@NotNull @Email String email){ this.email = email; }

    public String getEmail() { return email; }

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

    public void setPasswordExpired(Date passwordExpired) {
        this.passwordExpired = passwordExpired;
    }

    public Date isPasswordExpired() {
        return passwordExpired;
    }

//    public void setUserDetails(UserDetails userDetails) {
//        this.userDetails = userDetails;
//    }
//
//    public UserDetails getUserDetails() {
//        return userDetails;
//    }

//    Set<Role> getAuthorities(){
//
//    }

    public String toString(){
       return email;
    }




}
