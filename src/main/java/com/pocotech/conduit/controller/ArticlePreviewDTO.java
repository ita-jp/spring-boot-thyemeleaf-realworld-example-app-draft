package com.pocotech.conduit.controller;

import java.time.LocalDate;

public record ArticlePreviewDTO(String title, String author, String description, LocalDate createdAt) {
}