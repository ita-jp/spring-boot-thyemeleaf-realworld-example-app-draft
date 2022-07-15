package com.pocotech.conduit.controller;

import java.time.LocalDate;

public record ArticlePreviewDTO(
        String slug,
        String title,
        String author,
        String description,
        LocalDate createdAt
) {
}