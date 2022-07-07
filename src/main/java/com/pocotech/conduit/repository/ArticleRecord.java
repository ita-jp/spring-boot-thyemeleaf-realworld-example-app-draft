package com.pocotech.conduit.repository;

import java.time.LocalDateTime;
import java.util.UUID;

public record ArticleRecord(
        UUID id,
        UUID authorId,
        String title,
        String description,
        String body,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
