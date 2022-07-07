package com.pocotech.conduit.service.article;

import com.pocotech.conduit.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<ArticlePreviewEntity> list() {
        return articleRepository.select()
                .stream()
                .map(r -> new ArticlePreviewEntity(
                        r.getTitle(),
                        r.getAuthorId().toString(),
                        r.getDescription(),
                        r.getCreatedAt().toLocalDate()
                ))
                .collect(Collectors.toList());
    }
}
