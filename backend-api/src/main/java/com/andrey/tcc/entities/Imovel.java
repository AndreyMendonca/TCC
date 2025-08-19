package com.andrey.tcc.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

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

    @OneToOne
    @JoinColumn(name = "locacao_id")
    private Aluguel aluguel;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "imovel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Manutencao> manutencoes = new ArrayList<>();

    @OneToMany(mappedBy = "imovel")
    private List<Lancamento> lancamentos = new ArrayList<>();

    public Imovel(){}

    public Imovel(BigDecimal aream2Util, BigDecimal areametrosquadrados, Integer banheiros, String descricao, Endereco endereco, Long id, String identificacao, Boolean imovelMobiliado, String link, Aluguel aluguel, Integer numeroQuartos, Boolean permiteAnimais, Boolean permiteFumar, String regrasDaCasa, Integer suite, TipoImovel tipoImovel, Integer vagasCarros) {
        this.aream2Util = aream2Util;
        this.areametrosquadrados = areametrosquadrados;
        this.banheiros = banheiros;
        this.descricao = descricao;
        this.endereco = endereco;
        this.id = id;
        this.identificacao = identificacao;
        this.imovelMobiliado = imovelMobiliado;
        this.link = link;
        this.aluguel = aluguel;
        this.numeroQuartos = numeroQuartos;
        this.permiteAnimais = permiteAnimais;
        this.permiteFumar = permiteFumar;
        this.regrasDaCasa = regrasDaCasa;
        this.suite = suite;
        this.tipoImovel = tipoImovel;
        this.vagasCarros = vagasCarros;
    }

    public BigDecimal getAream2Util() {
        return aream2Util;
    }

    public BigDecimal getAreametrosquadrados() {
        return areametrosquadrados;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Long getId() {
        return id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public Boolean getImovelMobiliado() {
        return imovelMobiliado;
    }

    @JsonIgnore
    public List<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public String getLink() {
        return link;
    }

    public Aluguel getLocacao() {
        return aluguel;
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public Integer getNumeroQuartos() {
        return numeroQuartos;
    }

    public Boolean getPermiteAnimais() {
        return permiteAnimais;
    }

    public Boolean getPermiteFumar() {
        return permiteFumar;
    }

    public String getRegrasDaCasa() {
        return regrasDaCasa;
    }

    public Integer getSuite() {
        return suite;
    }

    public TipoImovel getTipoImovel() {
        return tipoImovel;
    }

    public Integer getVagasCarros() {
        return vagasCarros;
    }

    public void setAream2Util(BigDecimal aream2Util) {
        this.aream2Util = aream2Util;
    }

    public void setAreametrosquadrados(BigDecimal areametrosquadrados) {
        this.areametrosquadrados = areametrosquadrados;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public void setImovelMobiliado(Boolean imovelMobiliado) {
        this.imovelMobiliado = imovelMobiliado;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLocacao(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public void setNumeroQuartos(Integer numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public void setPermiteAnimais(Boolean permiteAnimais) {
        this.permiteAnimais = permiteAnimais;
    }

    public void setPermiteFumar(Boolean permiteFumar) {
        this.permiteFumar = permiteFumar;
    }

    public void setRegrasDaCasa(String regrasDaCasa) {
        this.regrasDaCasa = regrasDaCasa;
    }

    public void setSuite(Integer suite) {
        this.suite = suite;
    }

    public void setTipoImovel(TipoImovel tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public void setVagasCarros(Integer vagasCarros) {
        this.vagasCarros = vagasCarros;
    }
}
