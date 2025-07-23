package com.andrey.tcc.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_tipo_imovel")
public class TipoImovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificao;

    public TipoImovel(){}

    public TipoImovel(Long id, String identificao) {
        this.id = id;
        this.identificao = identificao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentificao() {
        return identificao;
    }

    public void setIdentificao(String identificao) {
        this.identificao = identificao;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TipoImovel that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(identificao, that.identificao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identificao);
    }
}
