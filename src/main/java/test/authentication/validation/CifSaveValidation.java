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

    @NotNull
    @NotBlank
    private String address1;

    private String address2;

    public CifSaveValidation(){}

    public CifSaveValidation(@NotNull @NotBlank String cifId, @NotNull @NotBlank String corpName, @NotNull @NotBlank String address1, String address2){
        this.cifId = cifId;
        this.corpName = corpName;
        this.address1 = address1;
        this.address2 = address2;
    }

    public void setCifId(String cifId) { this.cifId = cifId; }

    public String getCifId() { return cifId; }

    public void setCorpName(String corpName) { this.corpName = corpName; }

    public String getCorpName() { return corpName; }

    public void setAddress1(String address1) { this.address1 = address1; }

    public String getAddress1() { return address1; }

    public void setAddress2(String address2) { this.address2 = address2; }

    public String getAddress2() { return address2; }
}
