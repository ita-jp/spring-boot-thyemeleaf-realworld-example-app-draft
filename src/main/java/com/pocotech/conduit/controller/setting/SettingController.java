package com.pocotech.conduit.controller.setting;

import com.pocotech.conduit.config.LoggedInUser;
import com.pocotech.conduit.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
@RequiredArgsConstructor
public class SettingController {

    private final UserService userService;

    @GetMapping
    public String showSetting(LoggedInUser user, Model model) {
        userService.findById(user.id())
                .ifPresentOrElse(
                        entity -> model.addAttribute("profile", entity),
                        () -> {
                            throw new IllegalArgumentException("NG");
                        }
                );
        return "settings/detail";
    }
}
