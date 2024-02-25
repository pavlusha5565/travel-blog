package com.artifactIntelligence.travelbook.Role;

import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    public RoleEntity findByName(String name) {
        return roleService.findByName(name);
    }

    public RoleEntity save(RoleEntity roleEntity) {
        return roleService.save(roleEntity);
    }

    public RoleEntity findById(Long id) {
        return roleService.findById(id);
    }

    public void deleteById(Long id) {
        roleService.deleteById(id);
    }

    public Iterable<RoleEntity> findAll() {
        return roleService.findAll();
    }

    public boolean existsById(Long id) {
        return roleService.existsById(id);
    }

    public long count() {
        return roleService.count();
    }

    public void delete(RoleEntity roleEntity) {
        roleService.delete(roleEntity);
    }
}
