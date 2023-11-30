package com.portifolio.projetos.service;

import com.portifolio.projetos.model.Pessoa;
import com.portifolio.projetos.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    public List<Pessoa> listaGerentes() {
        return pessoaRepository.findByGerenteTrue();
    }

    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


}
