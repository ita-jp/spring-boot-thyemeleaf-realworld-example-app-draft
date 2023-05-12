package com.pocotech.conduit.controller.article;

import com.pocotech.conduit.config.LoggedInUser;
import com.pocotech.conduit.service.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/{id}")
    public String showArticle(@PathVariable String id, Model model) {
        var entity = articleService.find(id)
                        .orElseThrow(() -> new IllegalArgumentException("NG")); // TODO specific exception

        model.addAttribute("article", entity);
        return "articles/detail";
    }

    @PostMapping
    public String createArticle(ArticleForm form, LoggedInUser user) {
        articleService.create(user.id(), form.title(), form.description(), form.body());
        return "redirect:/";
    }

    @GetMapping(headers = "HX-Request")
    public String showList(Model model) {
        var articleList = articleService.list()
                .stream()
                .map(ArticlePreviewDTO::from)
                .toList();
        model.addAttribute("articleList", articleList);
        return "articles/list :: articleList";
    }
}
