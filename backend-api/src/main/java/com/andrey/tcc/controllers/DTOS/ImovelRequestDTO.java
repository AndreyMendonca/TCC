package com.andrey.tcc.controllers.DTOS;

import com.andrey.tcc.entities.Endereco;

import java.math.BigDecimal;

public class ImovelRequestDTO {
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
    private EnderecoDTO endereco;
    private Long tipoImovel;

    public ImovelRequestDTO(){}

    public ImovelRequestDTO(BigDecimal aream2Util, BigDecimal areametrosquadrados, Integer banheiros, String descricao, EnderecoDTO endereco, Long id, String identificacao, Boolean imovelMobiliado, String link, Integer numeroQuartos, Boolean permiteAnimais, Boolean permiteFumar, String regrasDaCasa, Integer suite, Long tipoImovel, Integer vagasCarros) {
        this.aream2Util = aream2Util;
        this.areametrosquadrados = areametrosquadrados;
        this.banheiros = banheiros;
        this.descricao = descricao;
        this.endereco = endereco;
        this.id = id;
        this.identificacao = identificacao;
        this.imovelMobiliado = imovelMobiliado;
        this.link = link;
        this.numeroQuartos = numeroQuartos;
        this.permiteAnimais = permiteAnimais;
        this.permiteFumar = permiteFumar;
        this.regrasDaCasa = regrasDaCasa;
        this.suite = suite;
        this.tipoImovel = tipoImovel;
        this.vagasCarros = vagasCarros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(Long tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public BigDecimal getAream2Util() {
        return aream2Util;
    }

    public void setAream2Util(BigDecimal aream2Util) {
        this.aream2Util = aream2Util;
    }

    public BigDecimal getAreametrosquadrados() {
        return areametrosquadrados;
    }

    public void setAreametrosquadrados(BigDecimal areametrosquadrados) {
        this.areametrosquadrados = areametrosquadrados;
    }

    public Integer getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(Integer banheiros) {
        this.banheiros = banheiros;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public Boolean getImovelMobiliado() {
        return imovelMobiliado;
    }

    public void setImovelMobiliado(Boolean imovelMobiliado) {
        this.imovelMobiliado = imovelMobiliado;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(Integer numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public Boolean getPermiteAnimais() {
        return permiteAnimais;
    }

    public void setPermiteAnimais(Boolean permiteAnimais) {
        this.permiteAnimais = permiteAnimais;
    }

    public Boolean getPermiteFumar() {
        return permiteFumar;
    }

    public void setPermiteFumar(Boolean permiteFumar) {
        this.permiteFumar = permiteFumar;
    }

    public String getRegrasDaCasa() {
        return regrasDaCasa;
    }

    public void setRegrasDaCasa(String regrasDaCasa) {
        this.regrasDaCasa = regrasDaCasa;
    }

    public Integer getSuite() {
        return suite;
    }

    public void setSuite(Integer suite) {
        this.suite = suite;
    }

    public Integer getVagasCarros() {
        return vagasCarros;
    }

    public void setVagasCarros(Integer vagasCarros) {
        this.vagasCarros = vagasCarros;
    }
}
