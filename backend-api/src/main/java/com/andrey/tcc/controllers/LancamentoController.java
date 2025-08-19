package com.andrey.tcc.controllers;

import com.andrey.tcc.controllers.DTOS.LancamentoPagoRequestDTO;
import com.andrey.tcc.controllers.DTOS.LancamentoRequestDTO;
import com.andrey.tcc.entities.Lancamento;
import com.andrey.tcc.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {
    @Autowired
    private LancamentoService service;

    @PostMapping
    public List<Lancamento> save(@RequestBody LancamentoRequestDTO dto){
        return service.save(dto);
    }

    @PutMapping("/{id}/pago")
    public Lancamento updatePago(@PathVariable Long id, @RequestBody LancamentoPagoRequestDTO dto){
        return service.updatePago(id, dto);
    }

}
