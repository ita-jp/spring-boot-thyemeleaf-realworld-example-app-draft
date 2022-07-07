package com.pocotech.conduit.controller;

import com.pocotech.conduit.service.article.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    private ArticleService articleService = new ArticleService();

    @GetMapping
    public String index(Model model) {
        var entityList = articleService.list();
        var dtoList = entityList.stream()
                .map(entity -> new ArticlePreviewDTO(
                        entity.title(),
                        entity.author(),
                        entity.description(),
                        entity.createdAt()
                ))
                .toList();
        model.addAttribute("articlePreviewList", dtoList);
        return "index";
    }
}
