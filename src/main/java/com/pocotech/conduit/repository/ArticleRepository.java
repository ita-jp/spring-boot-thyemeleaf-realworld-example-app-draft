package com.pocotech.conduit.repository;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class ArticleRepository {

    public List<ArticleRecord> select() {
        return List.of(
                new ArticleRecord(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        "aaa title.",
                        "aaa description.",
                        "aaa body.",
                        LocalDateTime.now(),
                        LocalDateTime.now()
                ),
                new ArticleRecord(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        "bbb title.",
                        "bbb description.",
                        "bbb body.",
                        LocalDateTime.now(),
                        LocalDateTime.now()
                ),
                new ArticleRecord(
                        UUID.randomUUID(),
                        UUID.randomUUID(),
                        "ccc title.",
                        "ccc description.",
                        "ccc body.",
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );
    }

}
