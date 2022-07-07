package com.pocotech.conduit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
public class IndexController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("articlePreviewList", List.of(
                new ArticlePreviewDTO("This is title.", "I'm author.", "Description is hogehoge.",LocalDate.now()),
                new ArticlePreviewDTO("This is title.", "I'm author.", "Description is hogehoge.",LocalDate.now()),
                new ArticlePreviewDTO("This is title.", "I'm author.", "Description is hogehoge.",LocalDate.now())
        ));
        return "index";
    }
}
