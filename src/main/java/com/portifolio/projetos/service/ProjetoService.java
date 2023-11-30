package com.portifolio.projetos.service;

import com.portifolio.projetos.model.Projeto;
import com.portifolio.projetos.model.StatusEnum;
import com.portifolio.projetos.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> findAll() {
        return projetoRepository.findAll();
    }

    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public Optional<Projeto> findById(Long id) {
        return projetoRepository.findById(id);
    }

    public void deleteById(Long id) throws Exception {
        Optional<Projeto> projeto = this.findById(id);
        if(StatusEnum.INICIADO.equals(projeto.get().getStatus()) || StatusEnum.EM_ANDAMENTO.equals(projeto.get().getStatus()) || StatusEnum.ENCERRADO.equals(projeto.get().getStatus()))
            throw new Exception("Projeto não pode ser excluido pois seu status esta como: " + projeto.get().getStatus().name());
        projetoRepository.deleteById(id);
    }

}
