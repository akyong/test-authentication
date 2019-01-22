package test.authentication.services.security;

import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.domain.security.Role;
import test.authentication.domain.security.User;
import test.authentication.domain.security.UserRole;
import test.authentication.repository.UserRoleServiceRepository;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Singleton
public class UserRoleService implements UserRoleServiceRepository {
    @PersistenceContext
    protected EntityManager entityManager;

    public UserRoleService(){}

    public UserRoleService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public UserRole save(@NotNull User user, @NotNull Role role) {
        UserRole userRole = new UserRole(user, role);
        entityManager.persist(userRole);
        return userRole;
    }

    @Override
    @Transactional
    public UserRole findByUserAndRole(User user, Role role){
        Query query = entityManager.createQuery("SELECT e FROM UserRole e WHERE e.user = :user AND e.role = :role").setParameter("user",user).setParameter("role",role);
        if(query.getResultList().isEmpty()){
            return null;
        }
        else{
            return (UserRole) query.getResultList().get(0);
        }
    }

    @Override
    @Transactional
    public ArrayList findAllByUser(User user){
        Query query = entityManager.createQuery("SELECT e FROM UserRole e WHERE e.user = :user").setParameter("user",user);
        if(query.getResultList().isEmpty()){
            return null;
        }
        else{
            ArrayList userRoles = new ArrayList();
            for (UserRole roles:(Collection<UserRole>)  query.getResultList())
            {
                userRoles.add(roles.getRole().getAuthority());
            }
            return userRoles;
        }
    }

}
