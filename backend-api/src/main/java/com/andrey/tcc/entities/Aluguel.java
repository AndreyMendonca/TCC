package com.andrey.tcc.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tb_alugel")
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificacao;
    private LocalDate inicioAluguel;
    private LocalDate fimAluguel;
    private Integer diaDoPagamento;
    private BigDecimal caucao;
    private BigDecimal valorPrePagos;
    private BigDecimal valor;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "pessoa_inquilino_id")
    private Pessoa inquilino;

    @ManyToOne
    @JoinColumn(name = "pessoa_fiador_id")
    private Pessoa fiador;

    @OneToMany(mappedBy = "aluguel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Encargo> encargos = new ArrayList<>();

    @OneToOne(mappedBy = "aluguel")
    private Imovel imovel;

    public Aluguel(){}

    public Aluguel(Boolean ativo, BigDecimal caucao, Integer diaDoPagamento, Pessoa fiador, LocalDate fimAluguel, Long id, String identificacao, Imovel imovel, LocalDate inicioAluguel, Pessoa inquilino, BigDecimal valor, BigDecimal valorPrePagos) {
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

    public List<Encargo> getEncargos() {
        return encargos;
    }

    public Pessoa getFiador() {
        return fiador;
    }

    public void setFiador(Pessoa fiador) {
        this.fiador = fiador;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Pessoa getInquilino() {
        return inquilino;
    }

    public void setInquilino(Pessoa inquilino) {
        this.inquilino = inquilino;
    }
}
