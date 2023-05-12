package com.pocotech.conduit.controller.article;

import com.pocotech.conduit.service.article.ArticlePreviewEntity;

import java.net.URL;
import java.time.LocalDate;

public record ArticlePreviewDTO(
        String title,
        URL imageURL,
        String author,
        String description,
        LocalDate createdAt,
        String id
) {

    public static ArticlePreviewDTO from(ArticlePreviewEntity entity) {
        return new ArticlePreviewDTO(
                entity.title(),
                entity.imageURL(),
                entity.author(),
                entity.description(),
                entity.createdAt(),
                entity.id()
        );
    }
}