package com.pocotech.conduit.service.article;

import com.pocotech.conduit.service.user.UserEntity;

import java.time.LocalDateTime;

public record ArticleEntity(
        String id,
        String slug,
        UserEntity user,
        String title,
        String description,
        String body,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
