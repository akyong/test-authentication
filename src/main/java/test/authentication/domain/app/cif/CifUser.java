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
        this.userDetails = userDetails;
        this.firstName = firstName;
        this.lastName = lastName;
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

    @ManyToOne
    @JoinColumn(name = "cif_id")
    private Cif cif;

    /**
     * Column user_details_id as relation to table userDetails
     * */
    @ManyToOne
    @JoinColumn(name = "user_details_id")
    private UserDetails userDetails;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "delete_flag")
    private String deleteFlag;

    @Column(name = "created_by")
    private String createdBy;

    @NotNull
    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "updated_by")
    private String updatedBy;

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

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public void setCif(Cif cif) { this.cif = cif; }

    public Cif getCif() { return cif; }

    public void setUserDetails(UserDetails userDetails) { this.userDetails = userDetails; }

    public UserDetails getUserDetails() { return userDetails; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLastName() { return lastName; }

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
        sb.append(cif.getId());
        sb.append("userDetails=");
        sb.append(userDetails);
        sb.append(", firstName='");
        sb.append(firstName);
        sb.append("', lastName='");
        sb.append(lastName);
        sb.append("', deleteFlag='");
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