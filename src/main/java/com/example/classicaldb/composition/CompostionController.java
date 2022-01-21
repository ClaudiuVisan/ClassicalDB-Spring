package com.example.classicaldb.composition;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompostionController {

    @Autowired
    private CompositionService service;

    @GetMapping("/compositions")
    public String showCompositionList(Model model){
        List<Composition> compositionList = service.listAll();
        model.addAttribute("compositionList", compositionList);

        return "compositions";
    }

    @GetMapping("/compositions/new")
    public String showNewForm(Model model) {
        model.addAttribute("composition", new Composition());
        model.addAttribute("pageTitle", "Add composition");
        model.addAttribute("pageHeader", "Adauga compozitie");
        return "composition_form";
    }

    @PostMapping("/compositions/save")
    public String saveUser(Composition composition) {
        service.save(composition);

        return "redirect:/compositions";
    }

    @GetMapping("/compositions/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        try {
            Composition composition = service.get(id);
            model.addAttribute("composition",composition);
            model.addAttribute("pageTitle", "Edit composition");
            model.addAttribute("pageHeader", "Editare compozitie");

            return  "composition_form";
        } catch (CompositionNotFoundException e) {
            return "redirect:/compositions";
        }
    }

    @GetMapping("/compositions/delete/{id}")
    public String deleteComposition(@PathVariable("id") Integer id){
        try {
            service.delete(id);
        } catch (CompositionNotFoundException e) {
        }
        return "redirect:/compositions";
    }
}
