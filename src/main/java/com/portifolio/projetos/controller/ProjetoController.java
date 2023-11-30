package com.portifolio.projetos.controller;

import com.portifolio.projetos.model.Projeto;
import com.portifolio.projetos.model.StatusEnum;
import com.portifolio.projetos.service.PessoaService;
import com.portifolio.projetos.service.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@SessionAttributes("name")
public class ProjetoController {

    @Autowired
    ProjetoService projetoService;

    @Autowired
    PessoaService pessoaService;

    @RequestMapping
    public String listAllProject(ModelMap modelMap){
        List<Projeto> projetos = projetoService.findAll();
        modelMap.addAttribute("projetos", projetos);
        return "listaProjetos";
    }

    @RequestMapping(value = "adicionar-projeto", method = RequestMethod.GET)
    public String projetoPagina(ModelMap modelMap){
        Projeto projeto = new Projeto();
        modelMap.put("projeto", projeto);
        modelMap.put("statusEnum", StatusEnum.values());
        modelMap.put("gerentes", pessoaService.listaGerentes());
        return "adicionarProjeto";
    }

    @RequestMapping(value = "adicionar-projeto", method = RequestMethod.POST)
    public String adicionarProjeto(ModelMap modelMap, @Valid Projeto projeto, BindingResult result){
        if (result.hasErrors()) {
            return "adicionarProjeto";
        }
        projetoService.save(projeto);
        return "redirect:/";
    }
    @RequestMapping("excluir-projeto")
    public String deleteProject(@RequestParam Long id, RedirectAttributes redirectAttributes) throws Exception {
        try {
            projetoService.deleteById(id);
        } catch(Exception e) {
            redirectAttributes.addFlashAttribute("erro", true);
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "atualizar-projeto", method = RequestMethod.GET)
    public String atualizarProjetoPagina(@RequestParam Long id, ModelMap modelMap){
        Projeto projeto = projetoService.findById(id).get();
        modelMap.addAttribute("projeto", projeto);
        modelMap.addAttribute("statusEnum", StatusEnum.values());
        modelMap.addAttribute("gerentes", pessoaService.listaGerentes());
        return "adicionarProjeto";
    }

    @RequestMapping(value = "atualizar-projeto", method = RequestMethod.POST)
    public String atualizarProjeto(ModelMap modelMap, @Valid Projeto projeto, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()) {
            return "adicionarProjeto";
        }

        try {
            projetoService.save(projeto);
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("erro", true);
            redirectAttributes.addFlashAttribute("mensagem", e.getMessage());
        }

        return "redirect:/";
    }


}
