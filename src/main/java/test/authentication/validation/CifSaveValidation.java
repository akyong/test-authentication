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

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CifSaveValidation {

    @NotNull
    @NotBlank
    private String cifId;

    @NotNull
    @NotBlank
    private String corpName;

    /*
     * type :
     * 1 = Supermart
     * 2 = Seafood
     * 3 = Meat
     * 4 = Sembako
     * */
    @NotNull
    private Long type;

    @NotNull
    @NotBlank
    private String address1;

    private String address2;

    public CifSaveValidation(){}

    public CifSaveValidation(@NotNull @NotBlank String cifId, @NotNull @NotBlank String corpName, @NotNull Long type, @NotNull @NotBlank String address1, String address2){
        this.cifId = cifId;
        this.corpName = corpName;
        this.type = type;
        this.address1 = address1;
        this.address2 = address2;
    }

    public void setCifId(String cifId) { this.cifId = cifId; }

    public String getCifId() { return cifId; }

    public void setCorpName(String corpName) { this.corpName = corpName; }

    public String getCorpName() { return corpName; }

    public void setType(Long type) { this.type = type; }

    public Long getType() { return type; }

    public void setAddress1(String address1) { this.address1 = address1; }

    public String getAddress1() { return address1; }

    public void setAddress2(String address2) { this.address2 = address2; }

    public String getAddress2() { return address2; }
}
