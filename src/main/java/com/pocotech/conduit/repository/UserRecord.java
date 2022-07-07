package com.pocotech.conduit.repository;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserRecord {
    private UUID id;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
