package com.andrey.tcc.controllers.DTOS;

import com.andrey.tcc.entities.enums.TipoLancamentoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LancamentoRequestDTO {

    private Long id;
    private String identificacao;
    private String descricaco;
    private TipoLancamentoEnum tipoLancamento;
    private BigDecimal valorTotal;
    private Integer numeroParcelas;
    private LocalDate dataVencimento;
    private Long imovelId;

    public LancamentoRequestDTO(){}

    public LancamentoRequestDTO(Long id, LocalDate dataVencimento, String descricaco, String identificacao, Long idImovel, Integer numeroParcelas, TipoLancamentoEnum tipoLancamento, BigDecimal valorTotal) {
        this.id = id;
        this.dataVencimento = dataVencimento;
        this.descricaco = descricaco;
        this.identificacao = identificacao;
        this.imovelId = idImovel;
        this.numeroParcelas = numeroParcelas;
        this.tipoLancamento = tipoLancamento;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getImovelId() {
        return imovelId;
    }

    public void setImovelId(Long imovelId) {
        this.imovelId = imovelId;
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

}
