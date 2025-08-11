package com.andrey.tcc.controllers;

import com.andrey.tcc.controllers.DTOS.LancamentoRequestDTO;
import com.andrey.tcc.entities.Lancamento;
import com.andrey.tcc.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
