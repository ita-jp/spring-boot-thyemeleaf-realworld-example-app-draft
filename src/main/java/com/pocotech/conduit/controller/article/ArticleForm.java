package com.pocotech.conduit.controller.article;

public record ArticleForm(
        String title,
        String description,
        String body
) {
}
