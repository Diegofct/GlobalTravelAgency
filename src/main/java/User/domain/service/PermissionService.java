package User.domain.service;

import java.util.List;

import User.domain.entity.Permission;

public interface PermissionService {
    List<Permission> getPermissionsByRole(int roleId);
}
