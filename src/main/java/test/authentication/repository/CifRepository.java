package test.authentication.repository;

import test.authentication.SortingAndOrderArguments;
import test.authentication.domain.app.cif.Cif;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public interface CifRepository {
    Cif save(@NotNull String cifId,
             @NotNull String corpName,
             @NotNull String address1,
             String address2,
             @NotNull Date joinDate,
             @NotNull String deleteFlag,
             @NotNull Date dateCreated,
             @NotNull Date lastUpdated,
             @NotNull Date expireDate,
             @NotNull String status);

    List<Cif> findAll(@Valid SortingAndOrderArguments args);
}
