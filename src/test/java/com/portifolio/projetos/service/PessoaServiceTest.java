package com.portifolio.projetos.service;

import com.portifolio.projetos.model.Pessoa;
import com.portifolio.projetos.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void testListaGerentes() {
        Pessoa gerente1 = new Pessoa();
        gerente1.setGerente(true);

        Pessoa gerente2 = new Pessoa();
        gerente2.setGerente(true);

        Pessoa naoGerente = new Pessoa();
        gerente1.setGerente(false);

        List<Pessoa> pessoas = Arrays.asList(gerente1, gerente2, naoGerente);

        when(pessoaRepository.findByGerenteTrue()).thenReturn(pessoas);
        List<Pessoa> gerentes = pessoaService.listaGerentes();
        assertEquals(3, gerentes.size());
        verify(pessoaRepository, times(1)).findByGerenteTrue();
    }

    @Test
    void testSalvar() {
        Pessoa pessoa = new Pessoa();
        when(pessoaRepository.save(pessoa)).thenReturn(pessoa);
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        assertEquals(pessoa, pessoaSalva);
        verify(pessoaRepository, times(1)).save(pessoa);
    }
}
