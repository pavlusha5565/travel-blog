package com.artifactIntelligence.travelbook.Role;

import org.springframework.stereotype.Service;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public RoleEntity findByName(String name) {
        return roleRepository.findByName(name);
    }

    public RoleEntity save(RoleEntity roleEntity) {
        return roleRepository.save(roleEntity);
    }

    public RoleEntity findById(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    public Iterable<RoleEntity> findAll() {
        return roleRepository.findAll();
    }

    public boolean existsById(Long id) {
        return roleRepository.existsById(id);
    }

    public long count() {
        return roleRepository.count();
    }

    public void delete(RoleEntity roleEntity) {
        roleRepository.delete(roleEntity);
    }
}
