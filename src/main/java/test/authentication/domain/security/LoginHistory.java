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
import java.util.Date;

@Entity
@Table(name = "login_history")
public class LoginHistory {

    public LoginHistory(@NotNull String userid, @NotNull String loginVia, @NotNull Date loginTime, @NotNull Date logoutTime){
        this.userid = userid;
        this.loginVia = loginVia;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //table ini tidak butuh version

    @NotNull
    @Column(name = "userid")
    private String userid;

    @NotNull
    @Column(name = "login_media")
    private String loginVia;

    @Column(name = "login_time")
    private Date loginTime;

    @Column(name = "logout_time")
    private Date logoutTime;

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setLoginVia(String loginVia) { this.loginVia = loginVia; }

    public String getLoginVia() { return loginVia; }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("LoginHistory{");
        sb.append("id=");
        sb.append(id);
        sb.append(", userid='");
        sb.append("', loginTime=");
        sb.append(loginTime);
        sb.append("', logoutTime=");
        sb.append(logoutTime);
        sb.append("}");
        return  sb.toString();
    }
}