package com.pocotech.conduit.service.article;

import java.time.LocalDate;
import java.util.List;

public class ArticleService {

    public List<ArticlePreviewEntity> list() {
        return List.of(
                new ArticlePreviewEntity("This is title.", "I'm author.", "Description is hogehoge.", LocalDate.now()),
                new ArticlePreviewEntity("This is title.", "I'm author.", "Description is hogehoge.", LocalDate.now()),
                new ArticlePreviewEntity("This is title.", "I'm author.", "Description is hogehoge.", LocalDate.now())
        );
    }
}
