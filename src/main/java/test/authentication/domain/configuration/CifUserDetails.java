package test.authentication.domain.configuration;

import io.micronaut.security.authentication.UserDetails;

import java.util.Collection;

public class CifUserDetails extends UserDetails {
    private String cifId;

    public CifUserDetails(String username, Collection<String> roles){
        super(username, roles);
    }

    public CifUserDetails(String username, Collection<String> roles, String cifId){
        super(username, roles);
        this.cifId = cifId;
    }

    public String getCifId() {
        return cifId;
    }

    public void setCifId(String cifId) {
        this.cifId = cifId;
    }


}
