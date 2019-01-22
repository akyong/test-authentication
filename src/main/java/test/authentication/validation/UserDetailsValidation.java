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

import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.security.User;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDetailsValidation {
    public UserDetailsValidation(){}

    public UserDetailsValidation(@NotNull String firstName,
                       @NotNull String lastName,
                       @NotNull String userAlias,
                       @NotNull String email,
                       @NotNull String mobilePhoneNo,
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
        this.firstName = firstName;
        this.lastName = lastName;
        this.userAlias = userAlias;
        this.email = email;
        this.mobilePhoneNo = mobilePhoneNo;
        this.status = status;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.updatedBy = updatedBy;
        if(lastUpdated == null){
            this.lastUpdated = new Date();
        }
        this.language = language;
        this.ipAddress = ipAddress;
        this.jwtId = jwtId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;


    @NotNull
    private String userAlias;

    @Email
    private String email;

    @NotNull
    private String mobilePhoneNo;

    private String status;

    private String createdBy;

    private Date dateCreated;

    private String updatedBy = "";

    private Date lastUpdated;

    private String language;

    private String ipAddress;

    private String jwtId;

    private Date loginTime;

    private Date logoutTime;

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserAlias() {
        return userAlias;
    }

    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNo() {
        return mobilePhoneNo;
    }

    public void setMobilePhoneNo(String mobilePhoneNo) {
        this.mobilePhoneNo = mobilePhoneNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIpAddress() { return ipAddress; }

    public void setIpAddress(String ipAddress) { this.ipAddress = ipAddress; }

    public String getJwtId() { return jwtId; }

    public void setJwtId(String jwtId) { this.jwtId = jwtId; }

    public Date getLoginTime() { return loginTime; }

    public void setLoginTime(Date loginTime) { this.loginTime = loginTime; }

    public Date getLogoutTime() { return logoutTime; }

    public void setLogoutTime(Date logoutTime) { this.logoutTime = logoutTime; }
}
