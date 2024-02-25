package com.artifactIntelligence.travelbook.User;

import com.artifactIntelligence.travelbook.Role.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    @Query(value = "SELECT * FROM user WHERE username = ?1", nativeQuery = true)
    UserEntity findByUserName(String username);

    @Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
    UserEntity findByEmail(String email);

    @Transactional
    @Modifying
    @Query(value = "update UserEntity u set u.roles = ?1 where u.id = ?2", nativeQuery = true)
    UserEntity updateRolesById(@NonNull RoleEntity roles, @NonNull String id);
}
