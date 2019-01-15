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

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "cif")
public class Cif {

    public Cif(){}

    public Cif(@NotNull String cifId,
               @NotNull String corpName,
               @NotNull String address1,
               String address2,
               @NotNull Date joinDate,
               @NotNull String deleteFlag,
               @NotNull Date dateCreated,
               @NotNull Date lastUpdated,
               @NotNull Date expireDate,
               @NotNull String status){
        this.cifId = cifId;
        this.corpName = corpName;
        this.address1 = address1;
        this.address2 = address2;
        this.joinDate = joinDate;
        this.deleteFlag = deleteFlag;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.expireDate = expireDate;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Column(name = "cif_id", unique = true)
    private String cifId;

    @NotNull
    @Column(name = "corp_name")
    private String corpName;

    @NotNull
    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "join_date")
    private Date joinDate;

    @NotNull
    @Column(name = "delete_flag")
    private String deleteFlag = "N";

    @NotNull
    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @Column(name = "expire_date")
    private Date expireDate;

    @NotNull
    @Column(name = "status")
    private String status;
    /**
     * Every action must be approved
     *
     * Status
     * 1 - Pending Create
     * 2 - Pending Update
     * 3 - Pending Delete
     * 4 - Active
     * */

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

    public void setStatus(String status) { this.status = status; }

    public String getStatus() { return status; }

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
        sb.append(", status='");
        sb.append(status);
        sb.append("'}");
        return sb.toString();
    }
}