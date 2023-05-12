package com.pocotech.conduit.repository;

import com.pocotech.conduit.service.user.UserEntity;
import lombok.Data;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserRecord {
    private UUID id;
    private String username;
    private String email;
    private String bio;
    private String password;
    private URL imageURL;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserEntity toEntity() {
        return new UserEntity(id, username, email, bio, imageURL, createdAt, updatedAt);
    }
}
