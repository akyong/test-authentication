package test.authentication.domain.security;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "login_history")
public class LoginHistory {

    public LoginHistory(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //table ini tidak butuh version

    @NotNull
    @Column(name = "userid")
    private String userid;

    @NotNull
    @Column(name = "login_time")
    private Date loginTime;

    @NotNull
    @Column(name = "logout_time")
    private Date logoutTime;

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

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