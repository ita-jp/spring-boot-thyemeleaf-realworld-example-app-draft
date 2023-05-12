package com.pocotech.conduit.controller;

import com.pocotech.conduit.controller.article.ArticlePreviewDTO;
import com.pocotech.conduit.service.article.ArticleService;
import com.pocotech.conduit.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final ArticleService articleService;
    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        var entityList = articleService.list();
        var dtoList = entityList.stream()
                .map(ArticlePreviewDTO::from)
                .toList();
        model.addAttribute("articlePreviewList", dtoList);
        return "index";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(RegistrationForm form) {
        userService.createUser(form.username(), form.email(), form.password());
        return "redirect:/login";
    }
}
