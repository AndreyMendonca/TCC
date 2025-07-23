package com.andrey.tcc.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_encargo")
public class Encargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "aluguel_id")
    private Aluguel aluguel;

    public Encargo(){}

    public Encargo(Long id, BigDecimal valor, String descricao, Aluguel aluguel) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.aluguel = aluguel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Encargo encargo)) return false;
        return Objects.equals(id, encargo.id) && Objects.equals(valor, encargo.valor) && Objects.equals(descricao, encargo.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, descricao);
    }
}
