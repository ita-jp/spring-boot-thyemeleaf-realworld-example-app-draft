package com.pocotech.conduit.repository.article;

import com.pocotech.conduit.repository.user.UserRecord;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ArticleRecord {
    UUID id;
    UserRecord user;
    String title;
    String description;
    String body;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
