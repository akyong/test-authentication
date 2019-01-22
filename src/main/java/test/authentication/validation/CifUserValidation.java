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

package test.authentication.validation;

import test.authentication.domain.app.cif.Cif;
import test.authentication.domain.security.UserDetails;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CifUserValidation {

    @NotNull @NotBlank
    private String firstName;

    @NotNull @NotBlank
    private String lastName;

    public CifUserValidation(){

    }

    public CifUserValidation(@NotNull @NotBlank String firstName,
                             @NotNull @NotBlank String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getLastName() { return lastName; }

}
