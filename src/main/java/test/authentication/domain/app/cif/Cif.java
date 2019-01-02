package test.authentication.domain.app.cif;

import test.authentication.domain.security.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cif")
public class Cif {

    public Cif(){}

    public Cif(@NotNull Long version,
               @NotNull String cifId,
               @NotNull String corpName,
               @NotNull String address1,
               @NotNull String address2,
               @NotNull Date joinDate,
               @NotNull String deleteFlag,
               @NotNull Date dateCreated,
               @NotNull Date lastUpdated,
               @NotNull Date expireDate,
               @NotNull String pending,
               @NotNull String status,
               @NotNull UserDetails userDetails){
        this.version = version;
        this.cifId = cifId;
        this.corpName = corpName;
        this.address1 = address1;
        this.address2 = address2;
        this.joinDate = joinDate;
        this.deleteFlag = deleteFlag;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.expireDate = expireDate;
        this.pending = pending;
        this.status = status;
        this.userDetails = userDetails;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Column(name = "cif_id")
    private String cifId;

    @NotNull
    @Column(name = "corp_name")
    private String corpName;

    @NotNull
    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @NotNull
    @Column(name = "join_date")
    private Date joinDate;

    @NotNull
    @Column(name = "delete_flag")
    private String deleteFlag = "N";

    @NotNull
    @Column(name = "date_created")
    private Date dateCreated;

    @NotNull
    @Column(name = "last_updated")
    private Date lastUpdated;

    @NotNull
    @Column(name = "expire_date")
    private Date expireDate;

    @NotNull
    @Column(name = "pending")
    private String pending;

    @NotNull
    @Column(name = "status")
    private String status;
    /**
     * Status
     * 1 - Pending Create
     * 2 - Pending Update
     * 3 - Pending Delete
     * 4 - Active
     * */

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_detail_id")
    private UserDetails userDetails;

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public void setVersion(Long version) { this.version = version; }

    public Long getVersion() { return version; }

    public void setCifId(String cifId) { this.cifId = cifId; }

    public String getCifId() { return cifId; }

    public void setCorpName(String corpName) { this.corpName = corpName; }

    public String getCorpName() { return corpName; }

    public void setAddress1(String address1) { this.address1 = address1; }

    public String getAddress1() { return address1; }

    public void setAddress2(String address2) { this.address2 = address2; }

    public String getAddress2() { return address2; }

    public void setJoinDate(Date joinDate) { this.joinDate = joinDate; }

    public Date getJoinDate() { return joinDate; }

    public void setDeleteFlag(String deleteFlag) { this.deleteFlag = deleteFlag; }

    public String getDeleteFlag() { return deleteFlag; }

    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }

    public Date getDateCreated() { return dateCreated; }

    public void setLastUpdated(Date lastUpdated) { this.lastUpdated = lastUpdated; }

    public Date getLastUpdated() { return lastUpdated; }

    public void setExpireDate(Date expireDate) { this.expireDate = expireDate; }

    public Date getExpireDate() { return expireDate; }

    public void setPending(String pending) { this.pending = pending; }

    public String getPending() { return pending; }

    public void setStatus(String status) { this.status = status; }

    public String getStatus() { return status; }

    public void setUserDetails(UserDetails pic1) { this.userDetails = userDetails; }

    public UserDetails getUserDetails() { return userDetails; }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Cif{");
        sb.append("id=");
        sb.append(id);
        sb.append(", version=");
        sb.append(version);
        sb.append(", cifId='");
        sb.append(cifId);
        sb.append("', corpName='");
        sb.append(corpName);
        sb.append("', address1='");
        sb.append(address1);
        sb.append("', address2='");
        sb.append(address2);
        sb.append("', joinDate=");
        sb.append(joinDate);
        sb.append(", deleteFlag='");
        sb.append(deleteFlag);
        sb.append("', dateCreated=");
        sb.append(dateCreated);
        sb.append(", lsatUpdated=");
        sb.append(lastUpdated);
        sb.append(", expireDate=");
        sb.append(expireDate);
        sb.append(", pending='");
        sb.append(pending);
        sb.append("', status='");
        sb.append(status);
        sb.append(", user_details=");
        sb.append(userDetails);
        sb.append("}");
        return sb.toString();
    }
}