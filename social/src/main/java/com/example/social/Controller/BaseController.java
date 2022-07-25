package com.example.social.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@AllArgsConstructor
public class BaseController {

    @GetMapping("/")
    public ModelAndView index(ModelAndView mv)
    {
        mv.setViewName("index");
        return mv;
    }

    @GetMapping("/user")
    public ModelAndView user(ModelAndView mv)
    {
        mv.setViewName("user");
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv)
    {
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/accessDenied")
    public ModelAndView accessDenied(ModelAndView mv) {
        mv.setViewName("accessDenied");
        return mv;
    }
}
