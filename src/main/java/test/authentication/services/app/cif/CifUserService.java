package test.authentication.services.app.cif;

import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.app.cif.CifUser;
import test.authentication.domain.security.UserDetails;
import test.authentication.repository.CifUserRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class CifUserService implements CifUserRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public CifUserService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public CifUserService(){}

    @Override
    @Transactional
    public CifUser save(@NotNull Cif cif,
                        @NotNull @NotBlank String firstName,
                        @NotNull @NotBlank String lastName,
                        @NotNull UserDetails userDetails,
                        @NotNull @NotBlank String deleteFlag,
                        @NotNull String createdBy,
                        @NotNull Date dateCreated,
                        @NotNull @NotBlank String updatedBy,
                        @NotNull Date lastUpdated,
                        @NotNull @NotBlank String bo,
                        @NotNull @NotBlank String finance,
                        @NotNull @NotBlank String sysAdmin){
        CifUser cifUser = new CifUser(cif, firstName, lastName, userDetails, deleteFlag, createdBy, dateCreated, updatedBy, lastUpdated, bo, finance, sysAdmin);
        entityManager.persist(cifUser);
        return cifUser;
    }
}
