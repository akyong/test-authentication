package test.authentication.domain.app.cif;

import test.authentication.domain.security.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cif_user")
public class CifUser {

    public CifUser(){}

    public CifUser(@NotNull Cif cif,
                   @NotNull String firstName,
                   @NotNull String lastName,
                   @NotNull UserDetails userDetails,
                   @NotNull String deleteFlag,
                   @NotNull String createdBy,
                   @NotNull Date dateCreated,
                   @NotNull String updatedBy,
                   @NotNull Date lastUpdated,
                   @NotNull String bo,
                   @NotNull String finance,
                   @NotNull String sysAdmin){
        this.cif = cif;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userDetails = userDetails;
        this.deleteFlag = deleteFlag;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
        this.updatedBy = updatedBy;
        this.lastUpdated = lastUpdated;
        this.bo = bo;
        this.finance = finance;
        this.sysAdmin = sysAdmin;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cif_id")
    private Cif cif;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_detail_id")
    private UserDetails userDetails;

    @NotNull
    @Column(name = "delete_flag")
    private String deleteFlag;

    @NotNull
    @Column(name = "created_by")
    private String createdBy;

    @NotNull
    @Column(name = "date_created")
    private Date dateCreated;

    @NotNull
    @Column(name = "updated_by")
    private String updatedBy;

    @NotNull
    @Column(name = "last_updated")
    private Date lastUpdated;

    @NotNull
    @Column(name = "bo")
    private String bo = "N";

    @NotNull
    @Column(name = "finance")
    private String finance = "N";

    @NotNull
    @Column(name = "sys_admin")
    private String sysAdmin = "N";

    public void setCif(Cif cif) { this.cif = cif; }

    public Cif getCif() { return cif; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLastName() { return lastName; }

    public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }

    public UserDetails getUserDetails() { return userDetails; }

    public void setDeleteFlag(String deleteFlag) { this.deleteFlag = deleteFlag; }

    public String getDeleteFlag() { return deleteFlag; }

    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public String getCreatedBy() { return createdBy; }

    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public Date getDateCreated() { return dateCreated; }

    public void setUpdatedBy(String updatedBy) { this.updatedBy = updatedBy; }

    public String getUpdatedBy() { return updatedBy; }

    public void setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; }

    public Date getLastUpdated() { return lastUpdated; }

    public void setBo(String bo) { this.bo = bo; }

    public String getBo() { return bo; }

    public void setFinance(String finance) { this.finance = finance; }

    public String getFinance() { return finance; }

    public void setSysAdmin(String sysAdmin) { this.sysAdmin = sysAdmin; }

    public String getSysAdmin() { return sysAdmin; }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("CifUser{");
        sb.append("cif=");
        sb.append(cif);
        sb.append(", firstName='");
        sb.append(firstName);
        sb.append("', lastName='");
        sb.append(lastName);
        sb.append("', userDetils=");
        sb.append(userDetails);
        sb.append(", deleteFlag='");
        sb.append(deleteFlag);
        sb.append("', createdBy='");
        sb.append(createdBy);
        sb.append("', dateCreated=");
        sb.append(dateCreated);
        sb.append(", updatedBy='");
        sb.append(updatedBy);
        sb.append(", lastUpdated=");
        sb.append(lastUpdated);
        sb.append(", bo='");
        sb.append(bo);
        sb.append("', finance='");
        sb.append(finance);
        sb.append("', sysAdmin='");
        sb.append(sysAdmin);
        sb.append("'}");
        return sb.toString();
    }
}