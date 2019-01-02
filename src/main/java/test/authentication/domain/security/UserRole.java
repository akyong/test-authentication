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
@Table(name = "user_role")
public class UserRole {

    public UserRole(){}

    public UserRole(@NotNull User user, @NotNull Role role){
        this.user = user;
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Long getVersion() {
        return version;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("UserRole{");
        sb.append("id=");
        sb.append(id);
        sb.append(", version=");
        sb.append(version);
        sb.append(", User=");
        sb.append(user);
        sb.append(", Role=");
        sb.append(role);
        sb.append("}");
        return sb.toString();
    }
}