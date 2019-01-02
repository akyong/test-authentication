package test.authentication.domain.security;

import org.hibernate.query.criteria.internal.expression.function.SubstringFunction;

import javax.annotation.Nullable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "role")
public class Role {

    public Role(){}

    public Role(@NotNull String name, @NotNull String authority, @NotNull String isSystem){
        this.name = name;
        this.authority = authority;
        this.isSystem = isSystem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "authority")
    private String authority;

    @NotNull
    @Column(name = "is_system") // N ->dibuat oleh system secara otomatis, jika Y, maka ada orang yang buat.
    private String isSystem = "N";

    public void setId(Long id) { this.id = id; }

    public Long getId() {
        return id;
    }

    public void setVersion(Long version) { this.version = version; }

    public Long getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setIsSystem(String isSystem) {
        this.isSystem = isSystem;
    }

    public String getIsSystem() {
        return isSystem;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Role{");
        sb.append("id=");
        sb.append(id);
        sb.append(", version=");
        sb.append(version);
        sb.append(", name=");
        sb.append(name);
        sb.append(", authority=");
        sb.append(authority);
        sb.append(", is_system='");
        sb.append(isSystem);
        sb.append("'}");
        return sb.toString();
    }
}