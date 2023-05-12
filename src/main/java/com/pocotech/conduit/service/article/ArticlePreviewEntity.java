package com.pocotech.conduit.service.article;

import java.net.URL;
import java.time.LocalDate;

public record ArticlePreviewEntity(
        String title,
        URL imageURL,
        String author,
        String description,
        LocalDate createdAt,
        String id
) {
}
