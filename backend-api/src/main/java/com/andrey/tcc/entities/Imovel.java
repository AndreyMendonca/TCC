package com.andrey.tcc.entities;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_imovel")
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificacao;
    private BigDecimal areametrosquadrados;
    private BigDecimal aream2Util;
    private Integer numeroQuartos;
    private Integer suite;
    private Integer banheiros;
    private Integer vagasCarros;
    private String descricao;
    private String regrasDaCasa;
    private String link;
    private Boolean imovelMobiliado;
    private Boolean permiteFumar;
    private Boolean permiteAnimais;

    @ManyToOne
    @JoinColumn(name = "tipoImove_id")
    private TipoImovel tipoImovel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "locacao_id")
    private Locacao locacao;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "imovel")
    private List<Manutencao> manutencoes = new ArrayList<>();

    @OneToMany(mappedBy = "imovel")
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Imovel(){}

}
