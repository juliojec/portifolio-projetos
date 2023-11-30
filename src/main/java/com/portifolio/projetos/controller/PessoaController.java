package com.portifolio.projetos.controller;

import com.portifolio.projetos.model.Pessoa;
import com.portifolio.projetos.service.PessoaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("pessoa")
public class PessoaController {

    PessoaService pessoaService;

    @PostMapping
    public Pessoa save(Pessoa pessoa) {
        return pessoaService.salvar(pessoa);
    }

}
