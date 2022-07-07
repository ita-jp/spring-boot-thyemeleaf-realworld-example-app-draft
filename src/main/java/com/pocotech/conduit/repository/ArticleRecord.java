package com.pocotech.conduit.repository;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ArticleRecord {
    UUID id;
    UUID authorId;
    String title;
    String description;
    String body;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
