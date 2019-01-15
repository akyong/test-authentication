package test.authentication.services.app.cif;

import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.SortingAndOrderArguments;
import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.configuration.ApplicationConfiguration;
import test.authentication.repository.CifRepository;

import javax.persistence.EntityManager;
import javax.persistence.OrderBy;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class CifService implements CifRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final static List<String> VALID_PROPERTY_NAMES = Arrays.asList("id", "corpName","address1","address2","joinDate","dateCreated","status");
    private static ApplicationConfiguration applicationConfiguration;

    public CifService(EntityManager entityManager,ApplicationConfiguration applicationConfiguration){
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    public CifService(){

    }

    @Override
    @Transactional(readOnly = true)
    public List<Cif> findAll(@NotNull SortingAndOrderArguments args) {
        String qlString = "SELECT g FROM Cif as g";
        if (args.getOrder().isPresent() && args.getSort().isPresent() && VALID_PROPERTY_NAMES.contains(args.getSort().get())) {
            qlString += " ORDER BY g." + args.getSort().get() + " " + args.getOrder().get().toLowerCase();
        }
        TypedQuery<Cif> query = entityManager.createQuery(qlString, Cif.class);
        query.setMaxResults(args.getMax().orElseGet(applicationConfiguration::getMax));
        args.getOffset().ifPresent(query::setFirstResult);

        return query.getResultList();
    }


    @Override
    @Transactional
    public Cif save(@NotNull String cifId,
                    @NotNull String corpName,
                    @NotNull String address1,
                    String address2,
                    @NotNull Date joinDate,
                    @NotNull String deleteFlag,
                    @NotNull Date dateCreated,
                    @NotNull Date lastUpdated,
                    @NotNull Date expireDate,
                    @NotNull String status) {
        Cif cif = new Cif(cifId, corpName, address1, address2, joinDate, deleteFlag, dateCreated, lastUpdated, expireDate, status);
        entityManager.persist(cif);
        return cif;
    }
}
