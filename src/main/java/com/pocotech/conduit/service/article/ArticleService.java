package com.pocotech.conduit.service.article;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ArticleService {

    public List<ArticlePreviewEntity> list() {
        return List.of(
                new ArticlePreviewEntity("This is title.", "I'm author.", "Description is hogehoge.", LocalDate.now()),
                new ArticlePreviewEntity("This is title.", "I'm author.", "Description is hogehoge.", LocalDate.now()),
                new ArticlePreviewEntity("This is title.", "I'm author.", "Description is hogehoge.", LocalDate.now())
        );
    }
}
