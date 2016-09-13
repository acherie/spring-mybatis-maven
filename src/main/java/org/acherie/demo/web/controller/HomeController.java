package org.acherie.demo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wangjie on 9/13/2016.
 */
@Controller
@RequestMapping(value = {"/"})
public class HomeController {

    @RequestMapping
    public String home(Model model) {
        return "index";
    }
}
