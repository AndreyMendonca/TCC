package com.andrey.tcc.controllers.DTOS;

import com.andrey.tcc.entities.Aluguel;
import com.andrey.tcc.entities.Arquivo;
import com.andrey.tcc.entities.Endereco;
import com.andrey.tcc.entities.enums.TipoPessoaEnum;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PessoaResponseDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private LocalDate dataNascimento;
    private String profissao;
    private Boolean ativa;
    private TipoPessoaEnum tipoPessoa;
    private EnderecoDTO endereco;

    private String imagemPerfil;

    private List<String> arquivos = new ArrayList<>();

    public PessoaResponseDTO(){}

    public PessoaResponseDTO(List<String> arquivos, Boolean ativa, String cpf, LocalDate dataNascimento, String email, EnderecoDTO endereco, Long id, String imagemPerfil, String nome, String profissao, String sobrenome, TipoPessoaEnum tipoPessoa) {
        this.arquivos = arquivos;
        this.ativa = ativa;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.endereco = endereco;
        this.id = id;
        this.imagemPerfil = imagemPerfil;
        this.nome = nome;
        this.profissao = profissao;
        this.sobrenome = sobrenome;
        this.tipoPessoa = tipoPessoa;
    }

    public List<String> getArquivos() {
        return arquivos;
    }

    public void setArquivos(List<String> arquivos) {
        this.arquivos = arquivos;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagemPerfil() {
        return imagemPerfil;
    }

    public void setImagemPerfil(String imagemPerfil) {
        this.imagemPerfil = imagemPerfil;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public TipoPessoaEnum getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(TipoPessoaEnum tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }
}
