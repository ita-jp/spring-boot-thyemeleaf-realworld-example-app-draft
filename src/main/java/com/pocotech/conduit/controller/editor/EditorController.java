package com.pocotech.conduit.controller.editor;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/editor")
@RequiredArgsConstructor
public class EditorController {

    @GetMapping
    public String showEditor() {
        return "editor";
    }
}
