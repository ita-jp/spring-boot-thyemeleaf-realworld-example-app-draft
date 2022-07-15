package com.pocotech.conduit.service.article;

import com.pocotech.conduit.repository.ArticleRepository;
import com.pocotech.conduit.service.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<ArticlePreviewEntity> list() {
        return articleRepository.select()
                .stream()
                .map(r -> new ArticlePreviewEntity(
                        r.getSlug(),
                        r.getTitle(),
                        r.getUser().getImageURL(),
                        r.getUser().getUsername(),
                        r.getDescription(),
                        r.getCreatedAt().toLocalDate()
                ))
                .collect(Collectors.toList());
    }

    public Optional<ArticleEntity> find(String slug) {
        return articleRepository.selectBySlug(slug)
                .map(record -> new ArticleEntity(
                                record.getTitle(),
                                record.getSlug(),
                                new UserEntity(
                                        record.getUser().getId(),
                                        record.getUser().getUsername(),
                                        record.getUser().getImageURL(),
                                        record.getUser().getCreatedAt(),
                                        record.getUser().getUpdatedAt()
                                ),
                                record.getTitle(),
                                record.getDescription(),
                                record.getBody(),
                                record.getCreatedAt(),
                                record.getCreatedAt()
                        )
                );
    }
}
