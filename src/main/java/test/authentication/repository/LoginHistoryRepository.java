package test.authentication.repository;

import javax.validation.constraints.NotNull;
import java.util.Date;

public interface LoginHistoryRepository {

    void save(@NotNull String userid, @NotNull String loginVia, Date loginTime, Date logutTime);
}
