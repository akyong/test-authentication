package test.authentication.services.app.cif;

import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.app.cif.CifUser;
import test.authentication.domain.security.User;
import test.authentication.domain.security.UserDetails;
import test.authentication.repository.UserDetailsRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDetailsService implements UserDetailsRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public UserDetailsService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public UserDetailsService(){

    }

    @Override
    @Transactional
    public UserDetails save(@NotNull String firstName,
                            @NotNull String lastName,
                            @NotNull User user,
                            @NotNull Cif cif,
                            @NotNull String userAlias,
                            @NotNull String email,
                            @NotNull String mobilePhoneNo,
                            @NotNull String status,
                            @NotNull String createdBy,
                            @NotNull Date dateCreated,
                            @NotNull String updatedBy,
                            @NotNull Date lastUpdated,
                            @NotNull String language,
                            String ipAddress,
                            String jwtId,
                            Date loginTime,
                            Date logoutTime){
        UserDetails userDetails = new UserDetails(
                firstName,
                lastName,
                user,
                cif,
                userAlias,
                email,
                mobilePhoneNo,
                status,
                createdBy,
                dateCreated,
                updatedBy,
                lastUpdated,
                language,
                ipAddress,
                jwtId,
                loginTime,
                logoutTime);
        entityManager.persist(userDetails);
        return userDetails;
    }
}
