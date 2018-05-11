package com.cserny.controller;

import com.cserny.model.Something1;
import com.cserny.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    MainService mainService;

    @RequestMapping("/jsp")
    public String displayMainJsp(Model model) {
        model.addAttribute("test", 15);
        return "main";
    }

    @ResponseBody
    @RequestMapping("/")
    public String displayDefaultPage() {
        List<Something1> something1List = mainService.search(Something1.class);
        StringBuilder builder = new StringBuilder();
        if (something1List != null) {
            something1List.forEach(builder::append);
        }
        return "Some default page body " + builder.toString();
    }
}
