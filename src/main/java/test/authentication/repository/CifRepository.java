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

import io.micronaut.security.authentication.Authentication;
import test.authentication.SortingAndOrderArguments;
import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.security.User;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;

public interface CifRepository {
    Cif save(@NotNull @NotBlank String cifId,
             @NotNull @NotBlank String corpName,
             @NotNull Long type,
             @NotNull @NotBlank String address1,
             String address2,
             @NotNull Date joinDate,
             @NotNull String deleteFlag,
             @NotNull Date dateCreated,
             @NotNull Date lastUpdated,
             @NotNull Date expireDate,
             @NotNull String status);

    ArrayList findAll(@Valid SortingAndOrderArguments args);

    Cif findAllByCifId(@NotNull @NotBlank String cifId);

    int update(@NotNull @NotBlank Long id, @NotNull @NotBlank String corpName, @NotNull Long type, @NotNull @NotBlank String address1, String address2);

    Cif findById(@NotNull Long id);

    Cif findCifByUser(User user);

    Cif getCurrentCif(Authentication authentication);
}
