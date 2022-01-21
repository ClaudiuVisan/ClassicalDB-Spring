package com.example.classicaldb.composer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ComposerController {
    @Autowired private ComposerService service;

    @GetMapping("/composers")
    public String showComposerList(Model model){
        List<Composer> composersList = service.listAll();
        model.addAttribute("composersList", composersList);

        return "composers";
    }

    @GetMapping("/composers/new")
    public String showNewForm(Model model) {
        model.addAttribute("composer", new Composer());
        model.addAttribute("pageTitle", "Add composer");
        model.addAttribute("pageHeader", "Adauga compozitor");

        return "composer_form";
    }

    @PostMapping("/composers/save")
    public String saveUser(Composer composer) {
        service.save(composer);

        return "redirect:/composers";
    }

    @GetMapping("/composers/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        try {
            Composer composer = service.get(id);
            model.addAttribute("composer",composer);
            model.addAttribute("pageTitle", "Edit composer");
            model.addAttribute("pageHeader", "Editare compozitor");

            return  "composer_form";
        } catch (ComposerNotFoundException e) {
            return "redirect:/composers";
        }
    }

    @GetMapping("/composers/delete/{id}")
    public String deleteComposer(@PathVariable("id") Integer id){
    try {
        service.delete(id);
    } catch (ComposerNotFoundException e) {
     }
        return "redirect:/composers";
    }
}
