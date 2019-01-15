package test.authentication.repository;

import test.authentication.domain.security.Role;
import test.authentication.domain.security.User;
import test.authentication.domain.security.UserRole;

import javax.validation.constraints.NotNull;

public interface UserRoleServiceRepository {
    UserRole save(@NotNull User user, @NotNull Role role);
    UserRole findByUserAndRole(User user, Role role);
}
