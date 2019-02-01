package test.authentication.services;

import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.repository.HomeRepository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class HomeService implements HomeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public HomeService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public HomeService(){

    }

    @Override
    @Transactional
    public boolean checkPhoneNo(@NotNull String mobilePhoneNo){
        Query query = entityManager.createQuery("SELECT a FROM User as a WHERE a.mobilePhoneNo = :mobilePhoneNo").setParameter("mobilePhoneNo",mobilePhoneNo);
        if(query.getResultList().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    @Transactional
    public boolean checkEmail(@NotNull @Email String email){
        Query query = entityManager.createQuery("SELECT a FROM User as a WHERE a.email = :email").setParameter("email",email);
        if(query.getResultList().isEmpty()){
            return false;
        }
        else{
            return true;
        }
    }
}
