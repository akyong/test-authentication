/**
 * Copyright (c) 2019. PT. Distributor Indonesia Unggul. All rights reserverd.
 *
 * This source code is an unpublished work and the use of  a copyright  notice
 * does not imply otherwise. This source  code  contains  confidential,  trade
 * secret material of PT. Distributor Indonesia Unggul.
 * Any attempt or participation in deciphering, decoding, reverse  engineering
 * or in any way altering the source code is strictly  prohibited, unless  the
 * prior  written consent of Distributor Indonesia Unggul. is obtained.
 *
 * Unless  required  by  applicable  law  or  agreed  to  in writing, software
 * distributed under the License is distributed on an "AS IS"  BASIS,  WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or  implied.  See  the
 * License for the specific  language  governing  permissions  and limitations
 * under the License.
 *
 * Author : Bobby
 */


package test.authentication.services.security;

import io.micronaut.security.authentication.providers.PasswordEncoder;
import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.domain.security.User;
import test.authentication.repository.UserRepository;
import test.authentication.services.PasswordGeneratorService;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.logging.Logger;

@Singleton
public class UserService implements UserRepository {
    @PersistenceContext
    protected EntityManager entityManager;
    protected PasswordEncoder passwordEncoder;

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public UserService(EntityManager em) {
        this.entityManager = em;
    }

    public UserService() {

    }

    @Override
    @Transactional
    public User save(@NotNull @Email String email, @NotNull String username, @NotNull  String encodedPassword, @NotNull boolean enabled, @NotNull boolean accountExpired, @NotNull boolean accountLocked) {
        User user = new User(email, username, encodedPassword, enabled,accountExpired, accountLocked);
        entityManager.persist(user);
        return user;
    }

    /**
     *
     * @return List of User's Instance as List
     * you can use Collection too
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        Query query = entityManager.createQuery("SELECT e FROM user e");
        return (List<User>) query.getResultList();
    }

    /**
     *
     * @param email The plain text as E-mail
     * @return User's Instance if found
     */
    @Override
    @Transactional
    public User findByEmail(@NotNull @Email String email) {
        Query query = entityManager.createQuery("SELECT e FROM User e WHERE email = :email").setParameter("email",email);
        if(query.getResultList().isEmpty()){
            return null;
        }
        else{
            return (User) query.getResultList().get(0);
        }
    }

    /**
     *
     * @return Random String as String
     */
    @Override
    public String generateRandomString(){
        PasswordGeneratorService getRandomPassword = new PasswordGeneratorService();
        return getRandomPassword.createRandomString();

    }

    @Override
    public String encodePassword(String plainText){
        return passwordEncoder.encode(plainText);
    }


    public String getNewPasswordWithEncoded(){
        return encodePassword(generateRandomString());
    }


}
