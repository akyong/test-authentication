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

package test.authentication.repository;

import test.authentication.domain.security.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface UserRepository {
    User save(@NotNull @Email String email, @NotNull String username, @NotNull  String encodedPassword, @NotNull boolean enabled, @NotNull boolean accountExpired, @NotNull boolean accountLocked);

    String generateRandomString();

    String encodePassword(String plainText);

    String getNewPasswordWithEncoded();

    User findByEmail(@NotNull @Email String email);

    List<User> findAll();
}
