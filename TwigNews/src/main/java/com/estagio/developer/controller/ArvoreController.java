package com.estagio.developer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.estagio.developer.model.Arvore;
import com.estagio.developer.service.ArvoreService;

@Controller
public class ArvoreController {
    @Autowired
    private ArvoreService arvoreService;

    @GetMapping("/arvore")
    public String index(Model model) {
        model.addAttribute("arvores", arvoreService.findAll());
        return "list";
    }

    @GetMapping("/arvore/create")
    public String create(Model model) {
        model.addAttribute("arvore", new Arvore());
        return "form";
    }

    @GetMapping("/arvore/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("arvore", arvoreService.findOne(id));
        return "form";
    }

    @PostMapping("/arvore/save")
    public String save(@Valid Arvore arvore, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "form";
        }
        arvoreService.save(arvore);
        redirect.addFlashAttribute("success", "Item salvo com sucesso!");
        return "redirect:/arvore";
    }

    @GetMapping("/arvore/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
    	arvoreService.delete(id);
        redirect.addFlashAttribute("success", "Item removido com sucesso!");
        return "redirect:/arvore";
    }

    @GetMapping("/arvore/search")
    public String search(@RequestParam("s") String s, Model model) {
        if (s.equals("")) {
            return "redirect:/arvore";
        }

        model.addAttribute("arvores", arvoreService.search(s));
        return "list";
    }
}
