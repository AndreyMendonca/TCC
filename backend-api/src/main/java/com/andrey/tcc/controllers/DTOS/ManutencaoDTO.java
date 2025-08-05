package com.andrey.tcc.controllers.DTOS;

import java.time.LocalDate;

public class ManutencaoDTO {
    private Long id;
    private String identificao;
    private String descricao;
    private LocalDate dataRealizacao;

    public ManutencaoDTO(){}

    public ManutencaoDTO(LocalDate dataRealizacao, String descricao, Long id, String identificao) {
        this.dataRealizacao = dataRealizacao;
        this.descricao = descricao;
        this.id = id;
        this.identificao = identificao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificao() {
        return identificao;
    }

    public void setIdentificao(String identificao) {
        this.identificao = identificao;
    }
}
