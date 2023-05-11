package com.pocotech.conduit.controller;

import java.net.URL;
import java.time.LocalDate;

public record ArticlePreviewDTO(
        String title,
        URL imageURL,
        String author,
        String description,
        LocalDate createdAt
) {
}