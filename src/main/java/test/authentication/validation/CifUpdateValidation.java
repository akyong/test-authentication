package test.authentication.validation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CifUpdateValidation {
    @NotNull
    private Long id;

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

    public CifUpdateValidation(){}

    public CifUpdateValidation(@NotNull @NotBlank Long id, @NotNull @NotBlank String corpName, @NotNull Long type, @NotNull @NotBlank String address1, String address2){
        this.id = id;
        this.corpName = corpName;
        this.type = type;
        this.address1 = address1;
        this.address2 = address2;
    }

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public void setCorpName(String corpName) { this.corpName = corpName; }

    public String getCorpName() { return corpName; }

    public void setType(Long type) { this.type = type; }

    public Long getType() { return type; }

    public void setAddress1(String address1) { this.address1 = address1; }

    public String getAddress1() { return address1; }

    public void setAddress2(String address2) { this.address2 = address2; }

    public String getAddress2() { return address2; }
}
