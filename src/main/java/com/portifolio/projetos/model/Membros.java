package com.portifolio.projetos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "membros")
public class Membros {
    @Id
    @Column(name = "idprojeto")
    private Long idProjeto;

    @Id
    @Column(name = "idpessoa")
    private Long idPessoa;

    @ManyToOne
    @JoinColumn(name = "idprojeto", referencedColumnName = "id", nullable = false)
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "idpessoa", referencedColumnName = "id", nullable = false)
    private Pessoa pessoa;
}
