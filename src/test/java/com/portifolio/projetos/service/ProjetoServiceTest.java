package com.portifolio.projetos.service;

import com.portifolio.projetos.model.Projeto;
import com.portifolio.projetos.model.StatusEnum;
import com.portifolio.projetos.repository.ProjetoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @InjectMocks
    private ProjetoService projetoService;

    @Test
    void testFindAll() {
        Projeto projeto1 = new Projeto();
        Projeto projeto2 = new Projeto();
        List<Projeto> projetos = Arrays.asList(projeto1, projeto2);

        when(projetoRepository.findAll()).thenReturn(projetos);

        List<Projeto> result = projetoService.findAll();

        assertEquals(2, result.size());
        verify(projetoRepository, times(1)).findAll();
    }

    @Test
    void testSave() {
        Projeto projeto = new Projeto();

        when(projetoRepository.save(projeto)).thenReturn(projeto);

        Projeto result = projetoService.save(projeto);

        assertEquals(projeto, result);
        verify(projetoRepository, times(1)).save(projeto);
    }

    @Test
    void testFindById() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);

        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        Optional<Projeto> result = projetoService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(projeto, result.get());
        verify(projetoRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteById() {
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setStatus(StatusEnum.ANALISE_APROVADA);

        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));
        doNothing().when(projetoRepository).deleteById(1L);

        assertDoesNotThrow(() -> projetoService.deleteById(1L));

        verify(projetoRepository, times(1)).findById(1L);
        verify(projetoRepository, times(1)).deleteById(1L);
    }


    @Test
    void testDeleteByIdThrowsException() {
        // Arrange
        Projeto projeto = new Projeto();
        projeto.setId(1L);
        projeto.setStatus(StatusEnum.INICIADO);

        when(projetoRepository.findById(1L)).thenReturn(Optional.of(projeto));

        assertThrows(Exception.class, () -> projetoService.deleteById(1L));
        verify(projetoRepository, times(1)).findById(1L);
        verify(projetoRepository, never()).deleteById(1L);
    }
}
