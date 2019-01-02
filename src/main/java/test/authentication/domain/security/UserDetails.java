package test.authentication.domain.security;

import javax.inject.Singleton;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="user_details")
public class UserDetails {

    public UserDetails(){}

    public UserDetails(@NotNull String firstName,
                       @NotNull String lastName,
                       @NotNull User user,
                       @NotNull String userAlias,
                       @NotNull String email,
                       @NotNull String mobilePhoneNo,
                       @NotNull boolean forceChangePassword,
                       @NotNull boolean activateToken,
                       @NotNull int retry,
                       @NotNull int noOfWrongChangedPassword,
                       @NotNull int noOfWrongToken,
                       @NotNull String status,
                       @NotNull String deleteFlag,
                       @NotNull String createdBy,
                       @NotNull Date dateCreated,
                       @NotNull String updatedBy,
                       @NotNull Date lastUpdated,
                       @NotNull String activationKey){
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.userAlias = userAlias;
        this.email = email;
        this.mobilePhoneNo = mobilePhoneNo;
        this.forceChangePassword = forceChangePassword;
        this.activateToken = activateToken;
        this.retry = retry;
        this.noOfWrongChangedPassword = noOfWrongChangedPassword;
        this.noOfWrongToken = noOfWrongToken;
        this.status = status;
        this.deleteFlag = deleteFlag;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.updatedBy = updatedBy;
        if(!lastUpdated.equals(null)){
            this.lastUpdated = new Date();
        }
        this.activationKey = activationKey;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "users_id")
    private User user;

    @NotNull
    @Column(name = "user_alias")
    private String userAlias;

    @Email
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "mobile_phone_no")
    private String mobilePhoneNo;

    @Column(name = "force_change_password")
    private boolean forceChangePassword;

    @Column(name = "active_token")
    private boolean activateToken = false;

    @Column(name = "retry")
    private int retry;

    @Column(name = "no_of_wrong_change_password")
    private int noOfWrongChangedPassword;

    @Column(name = "no_of_wrong_token")
    private int noOfWrongToken;

    @Column(name = "status")
    private String status;

    @Column(name = "delete_flag")
    private String deleteFlag = "N";

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "updated_by")
    private String updatedBy = "";

    @Column(name = "last_updated")
    private Date lastUpdated;

    @Column(name = "activation_key")
    private String activationKey;

    @Column(name = "new_email")
    private String newEmail;

    @Column(name = "language")
    private String language;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public boolean isForceChangePassword() {
        return forceChangePassword;
    }

    public void setForceChangePassword(boolean forceChangePassword) {
        this.forceChangePassword = forceChangePassword;
    }

    public boolean isActivateToken() {
        return activateToken;
    }

    public void setActivateToken(boolean activateToken) {
        this.activateToken = activateToken;
    }

    public int getRetry() {
        return retry;
    }

    public void setRetry(int retry) {
        this.retry = retry;
    }

    public int getNoOfWrongChangedPassword() {
        return noOfWrongChangedPassword;
    }

    public void setNoOfWrongChangedPassword(int noOfWrongChangedPassword) {
        this.noOfWrongChangedPassword = noOfWrongChangedPassword;
    }

    public int getNoOfWrongToken() {
        return noOfWrongToken;
    }

    public void setNoOfWrongToken(int noOfWrongToken) {
        this.noOfWrongToken = noOfWrongToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
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

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("UserDetails{");
        sb.append("id=");
        sb.append(id);
        sb.append(", version=");
        sb.append(version);
        sb.append(", firstName='");
        sb.append(firstName);
        sb.append("', lastName='");
        sb.append(lastName);
        sb.append("', User=");
        sb.append(user);
        sb.append(", userAlias='");
        sb.append(userAlias);
        sb.append("', email='");
        sb.append(email);
        sb.append("', mobilePhoneNo='");
        sb.append(mobilePhoneNo);
        sb.append("', forceChangePassword=");
        sb.append(forceChangePassword);
        sb.append(", activateToken=");
        sb.append(activateToken);
        sb.append(", retry=");
        sb.append(retry);
        sb.append(", noOfWrongChangePassword=");
        sb.append(noOfWrongChangedPassword);
        sb.append(", noOfWrongToken=");
        sb.append(noOfWrongToken);
        sb.append(", status='");
        sb.append(status);
        sb.append("', deleteFlag='");
        sb.append(deleteFlag);
        sb.append("', createdBy='");
        sb.append(createdBy);
        sb.append("', dateCreated='");
        sb.append(dateCreated);
        sb.append("', updatedBy='");
        sb.append(updatedBy);
        sb.append("', lastUpdated='");
        sb.append(lastUpdated);
        sb.append("', activationKey='");
        sb.append(activationKey);
        sb.append("', newEmail='");
        sb.append(newEmail);
        sb.append("', language='");
        sb.append(language);
        sb.append("'}");

        return sb.toString();
    }
}