package com.github.searchgithubapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    @GetMapping("/home")
    String getHome(Model model){
        model.addAttribute("project", "");
        return "index";
    }

    @GetMapping("/project/{proj}/{owner}")
    String getProject(Model model, @PathVariable(name="proj") String projName, @PathVariable(name="owner") String ownerName){
        model.addAttribute("project", projName);
        model.addAttribute("owner", ownerName);
        return "project";
    }

    @GetMapping("/search/home/{proj}")
    String getSearchHome(Model model, @PathVariable(name="proj") String projName){
        model.addAttribute("project", projName);
        return "index";
    }
}
