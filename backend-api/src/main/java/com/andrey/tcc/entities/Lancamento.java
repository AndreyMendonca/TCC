package com.andrey.tcc.entities;

import com.andrey.tcc.entities.enums.TipoLancamentoEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_lancamento")
public class Lancamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificacao;
    private String descricaco;
    @Enumerated(EnumType.STRING)
    private TipoLancamentoEnum tipoLancamento;
    private BigDecimal valorTotal;
    private BigDecimal valorParcela;
    private Integer numeroParcelas;
    private Integer parcelaAtual;
    private LocalDate dataLancamento;
    private LocalDate dataVencimento;
    private LocalDate datExecutado;
    private Boolean statusLancamento;
    private Character realizadoPorQuem;
    private Long idFamilia;

    @ManyToOne
    @JoinColumn(name = "imovel_id")
    private Imovel imovel;

    public Lancamento(){}
}
