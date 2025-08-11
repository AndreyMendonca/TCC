package com.andrey.tcc.controllers.DTOS;

import com.andrey.tcc.entities.enums.TipoLancamentoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoRequestDTO {

    private String identificacao;
    private String descricaco;
    @Enumerated(EnumType.STRING)
    private TipoLancamentoEnum tipoLancamento;
    private BigDecimal valorTotal;
    private Integer numeroParcelas;
    private LocalDate dataLancamento;
    private LocalDate dataVencimento;
    private LocalDate dataExecutado;
    private Boolean statusLancamento;
    private Character realizadoPorQuem;

    public LancamentoRequestDTO(){}

    public LancamentoRequestDTO(LocalDate dataExecutado, LocalDate dataLancamento, LocalDate dataVencimento, String descricaco, String identificacao, Integer numeroParcelas, Character realizadoPorQuem, Boolean statusLancamento, TipoLancamentoEnum tipoLancamento, BigDecimal valorTotal) {
        this.dataExecutado = dataExecutado;
        this.dataLancamento = dataLancamento;
        this.dataVencimento = dataVencimento;
        this.descricaco = descricaco;
        this.identificacao = identificacao;
        this.numeroParcelas = numeroParcelas;
        this.realizadoPorQuem = realizadoPorQuem;
        this.statusLancamento = statusLancamento;
        this.tipoLancamento = tipoLancamento;
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataExecutado() {
        return dataExecutado;
    }

    public void setDataExecutado(LocalDate dataExecutado) {
        this.dataExecutado = dataExecutado;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDescricaco() {
        return descricaco;
    }

    public void setDescricaco(String descricaco) {
        this.descricaco = descricaco;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }

    public Character getRealizadoPorQuem() {
        return realizadoPorQuem;
    }

    public void setRealizadoPorQuem(Character realizadoPorQuem) {
        this.realizadoPorQuem = realizadoPorQuem;
    }

    public Boolean getStatusLancamento() {
        return statusLancamento;
    }

    public void setStatusLancamento(Boolean statusLancamento) {
        this.statusLancamento = statusLancamento;
    }

    public TipoLancamentoEnum getTipoLancamento() {
        return tipoLancamento;
    }

    public void setTipoLancamento(TipoLancamentoEnum tipoLancamento) {
        this.tipoLancamento = tipoLancamento;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
