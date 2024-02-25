package com.artifactIntelligence.travelbook.User;

import com.artifactIntelligence.travelbook.Role.RoleEntity;
import com.artifactIntelligence.travelbook.core.exeption.TravelbookException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    public UserEntity findUserByUsername(String username) {
        UserEntity data = this.userRepository.findByUserName(username);

        if (data == null) {
            throw new TravelbookException("User not found");
        }

        return data;
    }

    public UserEntity findUserByEmail(String email) {
        UserEntity data = this.userRepository.findByEmail(email);

        if (data == null) {
            throw new TravelbookException("User not found");
        }

        return data;
    }

    public List<UserEntity> findAllUsers() {
        return this.userRepository.findAll();
    }

    public UserEntity createUser(UserEntity user) {
        UserEntity userDB = this.userRepository.findByEmail(user.getEmail());

        if (userDB != null) {
            throw new TravelbookException("User already exists");
        }

        user.setRoles(Collections.singleton(new RoleEntity(1L, "ROLE_USER")));
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return this.userRepository.save(user);
    }

    public UserEntity updateUser(String id, UserEntity user, RoleEntity role) {
        UserEntity userDB = this.userRepository.findById(id).orElse(null);

        if (userDB == null) {
            throw new TravelbookException("User not found");
        }

        return userRepository.updateRolesById(role, id);
    }

    public void deleteUser(String id) {
        UserEntity user = this.userRepository.findById(id).orElse(null);

        if (user == null) {
            throw new TravelbookException("User not found");
        }

        this.userRepository.delete(user);
    }

    @Override
    public UserEntity loadUserByUsername(String email) {
        return this.findUserByEmail(email);
    }
}
