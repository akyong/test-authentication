package test.authentication;

import javax.validation.constraints.NotNull;

public class TotalCount {

    public TotalCount(){}

    @NotNull
    private Integer totalcount;

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }
}
