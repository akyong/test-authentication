//package test.authentication.domain.security;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//
///***
// * table ini dibuat terlebih dahulu, tapi
// * gak tau kedepannya pakai atau ngak.
// * kalau gk dipakai dibuang saja.
// */
//
//@Entity
//@Table(name = "request_map")
//public class RequestMap {
//
//    public RequestMap(){}
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Version
//    private Long version;
//
//    @NotNull
//    @Column(name = "url",unique = true)
//    private String url;
//
//    @NotNull
//    @Column(name = "config_attribute")
//    private String configAttribute;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Long getVersion() {
//        return version;
//    }
//
//    public void setVersion(Long version) {
//        this.version = version;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getConfigAttribute() {
//        return configAttribute;
//    }
//
//    public void setConfigAttribute(String configAttribute) {
//        this.configAttribute = configAttribute;
//    }
//
//    public String toString(){
//        StringBuilder sb = new StringBuilder();
//        sb.append("RequestMap{");
//        sb.append("id=");
//        sb.append(id);
//        sb.append(", version=");
//        sb.append(version);
//        sb.append(",url='");
//        sb.append(url);
//        sb.append("', configAttribute='");
//        sb.append(configAttribute);
//        sb.append("'}");
//        return sb.toString();
//    }
//}