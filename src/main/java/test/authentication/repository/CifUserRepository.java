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

import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.app.cif.CifUser;
import test.authentication.domain.security.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public interface CifUserRepository {
    CifUser save(
            @NotNull Cif cif,
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
            @NotNull @NotBlank String sysAdmin);
}
