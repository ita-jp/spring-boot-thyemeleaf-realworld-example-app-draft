package com.pocotech.conduit.controller;

import java.time.LocalDate;

public class ArticlePreviewDTO {

    private String title;
    private String author;
    private String description;
    private LocalDate createdAt;

    public ArticlePreviewDTO(String title, String author, String description, LocalDate createdAt) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }
}
