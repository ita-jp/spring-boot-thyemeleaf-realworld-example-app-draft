package com.pocotech.conduit.service.article;

import com.pocotech.conduit.repository.ArticleRepository;
import com.pocotech.conduit.service.user.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public List<ArticlePreviewEntity> list(String author) {
        return articleRepository.select(author)
                .stream()
                .map(r -> new ArticlePreviewEntity(
                        r.getTitle(),
                        r.getUser().getImageURL(),
                        r.getUser().getUsername(),
                        r.getDescription(),
                        r.getCreatedAt().toLocalDate(),
                        r.getId().toString()
                ))
                .collect(Collectors.toList());
    }

    public Optional<ArticleEntity> find(String id) {
        return articleRepository.selectById(id)
                .map(record -> new ArticleEntity(
                                record.getTitle(),
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

    public void create(UUID userId, String title, String description, String body) {
        articleRepository.insert(UUID.randomUUID(), userId, title, description, body);
    }
}
