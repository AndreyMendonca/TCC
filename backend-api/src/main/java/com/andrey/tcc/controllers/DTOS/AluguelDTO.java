package com.andrey.tcc.controllers.DTOS;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AluguelDTO {

    private Long id;
    private String identificacao;
    private LocalDate inicioAluguel;
    private LocalDate fimAluguel;
    private Integer diaDoPagamento;
    private BigDecimal caucao;
    private BigDecimal valorPrePagos;
    private BigDecimal valor;
    private Boolean ativo;

    private Long inquilino;

    private Long fiador;

    private Long imovel;

    private List<EncargoDTO> encargos = new ArrayList<>();

    public AluguelDTO(Boolean ativo, BigDecimal caucao, Integer diaDoPagamento, Long fiador, LocalDate fimAluguel, Long id, String identificacao, Long imovel, LocalDate inicioAluguel, Long inquilino, BigDecimal valor, BigDecimal valorPrePagos) {
        this.ativo = ativo;
        this.caucao = caucao;
        this.diaDoPagamento = diaDoPagamento;
        this.fiador = fiador;
        this.fimAluguel = fimAluguel;
        this.id = id;
        this.identificacao = identificacao;
        this.imovel = imovel;
        this.inicioAluguel = inicioAluguel;
        this.inquilino = inquilino;
        this.valor = valor;
        this.valorPrePagos = valorPrePagos;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getCaucao() {
        return caucao;
    }

    public void setCaucao(BigDecimal caucao) {
        this.caucao = caucao;
    }

    public Integer getDiaDoPagamento() {
        return diaDoPagamento;
    }

    public void setDiaDoPagamento(Integer diaDoPagamento) {
        this.diaDoPagamento = diaDoPagamento;
    }

    public List<EncargoDTO> getEncargos() {
        return encargos;
    }

    public Long getFiador() {
        return fiador;
    }

    public void setFiador(Long fiador) {
        this.fiador = fiador;
    }

    public LocalDate getFimAluguel() {
        return fimAluguel;
    }

    public void setFimAluguel(LocalDate fimAluguel) {
        this.fimAluguel = fimAluguel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Long getImovel() {
        return imovel;
    }

    public void setImovel(Long imovel) {
        this.imovel = imovel;
    }

    public LocalDate getInicioAluguel() {
        return inicioAluguel;
    }

    public void setInicioAluguel(LocalDate inicioAluguel) {
        this.inicioAluguel = inicioAluguel;
    }

    public Long getInquilino() {
        return inquilino;
    }

    public void setInquilino(Long inquilino) {
        this.inquilino = inquilino;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getValorPrePagos() {
        return valorPrePagos;
    }

    public void setValorPrePagos(BigDecimal valorPrePagos) {
        this.valorPrePagos = valorPrePagos;
    }
}
