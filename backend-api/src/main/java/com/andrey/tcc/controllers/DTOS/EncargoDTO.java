package com.andrey.tcc.controllers.DTOS;

import java.math.BigDecimal;
import java.util.Objects;

public class EncargoDTO {
    private Long id;
    private BigDecimal valor;
    private String descricao;

    public EncargoDTO(){}

    public EncargoDTO(Long id, BigDecimal valor, String descricao) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EncargoDTO that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor) && Objects.equals(descricao, that.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, descricao);
    }
}
