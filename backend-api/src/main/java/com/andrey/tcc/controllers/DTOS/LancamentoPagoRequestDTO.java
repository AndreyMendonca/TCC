package com.andrey.tcc.controllers.DTOS;

public class LancamentoPagoRequestDTO {
    private Character realizadoPorQuem;

    public LancamentoPagoRequestDTO(){}

    public LancamentoPagoRequestDTO(Character realizadoPorQuem) {
        this.realizadoPorQuem = realizadoPorQuem;
    }

    public Character getRealizadoPorQuem() {
        return realizadoPorQuem;
    }

    public void setRealizadoPorQuem(Character realizadoPorQuem) {
        this.realizadoPorQuem = realizadoPorQuem;
    }
}
