package com.example.classicaldb.catalogue;

import com.example.classicaldb.composer.Composer;
import com.example.classicaldb.composer.ComposerService;
import com.example.classicaldb.composition.Composition;
import com.example.classicaldb.composition.CompositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CatalogueController {
    @Autowired
    private CatalogueService catalogueService;

    @Autowired
    private ComposerService composerService;

    @Autowired
    private CompositionService compositionService;

    @GetMapping("/catalogues")
    public String showCatalogueList(Model model){
        List<Catalogue> cataloguesList = catalogueService.listAll();
        model.addAttribute("cataloguesList", cataloguesList);

        return "catalogues";
    }

    @GetMapping("/catalogues/new")
    public String showNewForm(Model model) {
        List<Composer> composerList = composerService.listAll();
        List<Composition> compositionList = compositionService.listAll();
        model.addAttribute("catalogue", new Catalogue());
        model.addAttribute("composerList", composerList);
        model.addAttribute("compositionList", compositionList);
        model.addAttribute("pageTitle", "Add catalogue");
        model.addAttribute("pageHeader", "Adauga catalog");

        return "catalogue_form";
    }

    @PostMapping("/catalogues/save")
    public String saveUser(Catalogue catalogue) {
        catalogueService.save(catalogue);

        return "redirect:/catalogues";
    }

    @GetMapping("/catalogues/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) throws CatalogueNotFoundException {
            Catalogue catalogue = catalogueService.get(id);
            List<Composer> composerList = composerService.listAll();
            List<Composition> compositionList = compositionService.listAll();
            model.addAttribute("catalogue", catalogue);
            model.addAttribute("composerList", composerList);
            model.addAttribute("compositionList", compositionList);
            model.addAttribute("pageTitle", "Edit catalogue");
            model.addAttribute("pageHeader", "Editare catalog");

            return "catalogue_form";
    }

    @GetMapping("/catalogues/delete/{id}")
    public String deleteCatalogue(@PathVariable("id") Integer id){
        try {
            catalogueService.delete(id);

        } catch (CatalogueNotFoundException e) {
        }
        return "redirect:/catalogues";
    }
}
