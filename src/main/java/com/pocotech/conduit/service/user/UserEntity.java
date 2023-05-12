package com.pocotech.conduit.service.user;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

public record UserEntity(
        UUID id,
        String username,
        String email,
        String bio,
        URL imageURL,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
