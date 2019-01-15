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

import io.micronaut.spring.tx.annotation.Transactional;
import test.authentication.domain.security.Role;
import test.authentication.domain.security.User;
import test.authentication.repository.RoleRepository;

import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.constraints.NotNull;

@Singleton
public class RoleService implements RoleRepository {
    @PersistenceContext
    protected EntityManager entityManager;

    public RoleService(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public RoleService(){

    }

    @Override
    @Transactional
    public Role save(@NotNull String name, @NotNull String authority, @NotNull  String isSystem) {
        Role role = new Role(name, authority, isSystem);
        entityManager.persist(role);
        return role;
    }

    /**
     *
     * @param authority as Role Name
     * @return Role's Name if found
     */
    @Override
    @Transactional
    public Role findByAuthority(@NotNull String authority) {
        Query query = entityManager.createQuery("SELECT e FROM Role e WHERE authority = :authority").setParameter("authority",authority);
        if(query.getResultList().isEmpty()){
            return null;
        }
        else{
            return (Role) query.getResultList().get(0);
        }
    }


}
