package com.pocotech.conduit.controller.profile;

import com.pocotech.conduit.config.LoggedInUser;
import com.pocotech.conduit.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

    private final UserService userService;

    @GetMapping("/{username}")
    public String showProfile(@PathVariable("username") String username, Model model) {
        userService.findByUsername(username)
                .ifPresentOrElse(
                        entity -> model.addAttribute("profile", entity),
                        () -> {
                            throw new IllegalArgumentException("NG");
                        }
                );

        return "profiles/detail";
    }

    @PutMapping
    public String updateSetting(LoggedInUser user, ProfileForm form) {
        userService.update(
                user.id(),
                form.username(),
                form.email(),
                form.password(),
                form.bio(),
                form.imageURL()
        );
        return "redirect:/profiles/" + form.username();
    }
}
