package com.andrey.tcc.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="tb_locacao")
public class Locacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificacao;
    private LocalDate inicioAluguel;
    private LocalDate fimAluguel;
    private Integer diaDoPagamento;
    private BigDecimal caucao;
    private BigDecimal valorPrePagos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluguel_id")
    private Aluguel aluguel;

    public Locacao(){}

    public Locacao(Long id, String identificacao, LocalDate inicioAluguel, LocalDate fimAluguel, Integer diaDoPagamento, BigDecimal caucao, BigDecimal valorPrePagos) {
        this.id = id;
        this.identificacao = identificacao;
        this.inicioAluguel = inicioAluguel;
        this.fimAluguel = fimAluguel;
        this.diaDoPagamento = diaDoPagamento;
        this.caucao = caucao;
        this.valorPrePagos = valorPrePagos;
    }

    public Locacao(Long id, String identificacao, LocalDate inicioAluguel, LocalDate fimAluguel, Integer diaDoPagamento, BigDecimal caucao, BigDecimal valorPrePagos, Aluguel aluguel) {
        this.id = id;
        this.identificacao = identificacao;
        this.inicioAluguel = inicioAluguel;
        this.fimAluguel = fimAluguel;
        this.diaDoPagamento = diaDoPagamento;
        this.caucao = caucao;
        this.valorPrePagos = valorPrePagos;
        this.aluguel = aluguel;
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

    public LocalDate getInicioAluguel() {
        return inicioAluguel;
    }

    public void setInicioAluguel(LocalDate inicioAluguel) {
        this.inicioAluguel = inicioAluguel;
    }

    public LocalDate getFimAluguel() {
        return fimAluguel;
    }

    public void setFimAluguel(LocalDate fimAluguel) {
        this.fimAluguel = fimAluguel;
    }

    public Integer getDiaDoPagamento() {
        return diaDoPagamento;
    }

    public void setDiaDoPagamento(Integer diaDoPagamento) {
        this.diaDoPagamento = diaDoPagamento;
    }

    public BigDecimal getCaucao() {
        return caucao;
    }

    public void setCaucao(BigDecimal caucao) {
        this.caucao = caucao;
    }

    public BigDecimal getValorPrePagos() {
        return valorPrePagos;
    }

    public void setValorPrePagos(BigDecimal valorPrePagos) {
        this.valorPrePagos = valorPrePagos;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}
