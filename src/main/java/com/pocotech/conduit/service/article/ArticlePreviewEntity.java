package com.pocotech.conduit.service.article;

import java.time.LocalDate;

public record ArticlePreviewEntity(String title, String author, String description, LocalDate createdAt) {
}
