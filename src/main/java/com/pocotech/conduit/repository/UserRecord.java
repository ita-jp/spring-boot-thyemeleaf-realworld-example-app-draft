package com.pocotech.conduit.repository;

import lombok.Data;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class UserRecord {
    private UUID id;
    private String username;
    private URL imageURL;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
