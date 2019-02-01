package test.authentication.repository;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public interface HomeRepository {
    boolean checkPhoneNo(@NotNull String mobilePhoneNo);

    boolean checkEmail(@NotNull @Email String email);
}
