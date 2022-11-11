package com.mustache.springbootmustachebbs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MustacheController {

    @GetMapping("/hi")
    public String mustacheCon(Model model) {
        // View에 값을 넘기겠다
        model.addAttribute("username", "유저 이름");
        model.addAttribute("id", "");

        // "greetings"라는 view return
        return "greetings";
    }

    @GetMapping("/hi/{id}")
    public String mustacheCon2(Model model, @PathVariable String id) {
        model.addAttribute("username", "유저 이름");
        model.addAttribute("id", id);

        return "greetings";
    }
}
