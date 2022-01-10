package br.com.tqi.evolution_test.repository.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor
public enum RoleEnum {
    ADMIN(1L, "ROLE_ADMIN", "Admin"),
    MASTER(2L, "ROLE_MASTER", "Master"),
    CUSTOMER(3L, "ROLE_CUSTOMER", "Customer");

    private final Long id;
    private final String role;
    private final String description;

    public static Role of(String roleName) {
        var roleEnum = RoleEnum.valueOf(roleName);
        var roleEntity = new Role();
        roleEntity.setDescription(roleEnum.getDescription());
        roleEntity.setRoleName(roleEnum.getRole());
        roleEntity.setId(roleEnum.getId());
        return roleEntity;
    }
}
