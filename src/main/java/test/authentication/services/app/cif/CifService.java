package test.authentication.services.app.cif;

import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.SortingAndOrderArguments;
import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.configuration.ApplicationConfiguration;
import test.authentication.domain.security.UserDetails;
import test.authentication.repository.CifRepository;

import javax.persistence.*;
import javax.print.attribute.HashAttributeSet;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.logging.Logger;

public class CifService implements CifRepository {
    @PersistenceContext
    private EntityManager entityManager;
    private final static List<String> VALID_PROPERTY_NAMES = Arrays.asList("id", "corpName","address1","address2","joinDate","dateCreated","status");
    private static ApplicationConfiguration applicationConfiguration;
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public CifService(EntityManager entityManager,ApplicationConfiguration applicationConfiguration){
        this.entityManager = entityManager;
        this.applicationConfiguration = applicationConfiguration;
    }

    public CifService(){

    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList findById(@NotNull Long id) {
        Cif cifInstance = entityManager.find(Cif.class, id);
        Query qlStringUserDetails = entityManager.createQuery("SELECT a FROM UserDetails as a WHERE a.cif = :cif").setParameter("cif",cifInstance);
        Query qlStringCifUser = entityManager.createQuery("SELECT b FROM CifUser as b WHERE b.cif = :cif").setParameter("cif",cifInstance);

        ArrayList list = new ArrayList();
        HashMap map = new HashMap();
        map.put("Cif",cifInstance);
        map.put("UserDetails",qlStringUserDetails.getResultList().get(0));
        map.put("CifUser",qlStringCifUser.getResultList().get(0));

        list.add(map);

        return list;
    }

    @Override
    @Transactional(readOnly = true)
    public ArrayList findAll(@NotNull SortingAndOrderArguments args) {
        String qlString = "SELECT g FROM Cif as g";
        if (args.getOrder().isPresent() && args.getSort().isPresent() && VALID_PROPERTY_NAMES.contains(args.getSort().get())) {
            qlString += " ORDER BY g." + args.getSort().get() + " " + args.getOrder().get().toLowerCase();
        }
        TypedQuery<Cif> query = entityManager.createQuery(qlString, Cif.class);
        TypedQuery<Cif> query1 = entityManager.createQuery(qlString, Cif.class);
        query.setMaxResults(args.getMax().orElseGet(applicationConfiguration::getMax));
        args.getOffset().ifPresent(query::setFirstResult);

        HashMap resultAndTotal = new HashMap();
        resultAndTotal.put("results",query.getResultList());
        resultAndTotal.put("totalCount",query1.getResultList().size());

        ArrayList result = new ArrayList();
        result.add(resultAndTotal);
        return result;
    }


    @Override
    @Transactional
    public Cif save(@NotNull @NotBlank String cifId,
                    @NotNull @NotBlank String corpName,
                    @NotNull Long type,
                    @NotNull @NotBlank String address1,
                    String address2,
                    @NotNull Date joinDate,
                    @NotNull String deleteFlag,
                    @NotNull Date dateCreated,
                    @NotNull Date lastUpdated,
                    @NotNull Date expireDate,
                    @NotNull String status) {
        Cif cif = new Cif(cifId, corpName, type, address1, address2, joinDate, deleteFlag, dateCreated, lastUpdated, expireDate, status);
        entityManager.persist(cif);
        return cif;
    }

    @Override
    @Transactional
    public int update(@NotNull @NotBlank Long id, @NotNull @NotBlank String corpName, @NotNull Long type, @NotNull @NotBlank String address1, String address2){
        return entityManager.createQuery(
                "UPDATE Cif g SET " +
                        "version = version + 1, " +
                        "corpName = :corpName, " +
                        "type = :type, " +
                        "address1 = :address1, " +
                        "address2 = :address2 " +
                        "where id = : id"
        )
                .setParameter("corpName",corpName)
                .setParameter("type",type)
                .setParameter("address1",address1)
                .setParameter("address2",address2)
                .setParameter("id",id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public Cif findAllByCifId(@NotNull @NotBlank String cifId){
        Query query = entityManager.createQuery("SELECT a FROM Cif as a WHERE cifId = :cifId").setParameter("cifId",cifId);
        if(query.getResultList().isEmpty()){
            return null;
        }
        else{
            return (Cif) query.getResultList().get(0);
        }
    }
}
