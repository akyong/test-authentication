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
 * @author Bobby
 * @since 1.0.0
 */


package test.authentication;

import javax.annotation.Nullable;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.Optional;

public class SortingAndOrderArguments {
    public SortingAndOrderArguments() {

    }

    @Nullable
    @PositiveOrZero
    private Integer offset;

    @Nullable
    @Positive
    private Integer max;

    @Nullable
    @Pattern(regexp = "id|corpName|address1|address2|joinDate|dateCreated|status")//harus diteliti lagi
    private String sort;

    @Nullable
    @Pattern(regexp = "asc|ASC|desc|DESC")
    private String order;


    public Optional<Integer> getOffset() {
        if(offset == null) {
            return Optional.empty();
        }
        return Optional.of(offset);
    }

    public void setOffset(@Nullable Integer offset) {
        this.offset = offset;
    }

    public Optional<Integer> getMax() {
        if(max == null) {
            return Optional.empty();
        }
        return Optional.of(max);
    }

    public void setMax(@Nullable Integer max) {
        this.max = max;
    }

    public Optional<String> getSort() {
        if(sort == null) {
            return Optional.empty();
        }
        return Optional.of(sort);
    }

    public void setSort(@Nullable String sort) {
        this.sort = sort;
    }

    public Optional<String> getOrder() {
        if(order == null) {
            return Optional.empty();
        }
        return Optional.of(order);
    }

    public void setOrder(@Nullable String order) {
        this.order = order;
    }
}
