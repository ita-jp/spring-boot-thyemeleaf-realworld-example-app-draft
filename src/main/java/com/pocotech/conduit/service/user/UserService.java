package com.pocotech.conduit.service.user;

import com.pocotech.conduit.repository.user.UserRecord;
import com.pocotech.conduit.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(String username, String email, String rawPassword) {
        var encodedPassword = passwordEncoder.encode(rawPassword);
        userRepository.insert(UUID.randomUUID(), username, email, encodedPassword);
    }

    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.selectByUsername(username)
                .map(UserRecord::toEntity);
    }

    public Optional<UserEntity> findById(UUID id) {
        return userRepository.selectById(id)
                .map(UserRecord::toEntity);
    }

    @Transactional
    public void update(UUID userId, String username, String email, String rawPassword, String bio, String imageURL) {
        var encodedPassword = Optional.ofNullable(rawPassword)
                .map(passwordEncoder::encode)
                .orElse(null);
        userRepository.update(userId, username, email, encodedPassword, bio, imageURL);
    }
}
