package com.pocotech.conduit.service.user;

import java.time.LocalDateTime;
import java.util.UUID;

public record UserEntity(
        UUID id,
        String username,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
