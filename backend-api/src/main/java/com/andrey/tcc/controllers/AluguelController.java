package com.andrey.tcc.controllers;

import com.andrey.tcc.controllers.DTOS.AluguelDTO;
import com.andrey.tcc.entities.Aluguel;
import com.andrey.tcc.services.AluguelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alugueis")
public class AluguelController {
    @Autowired
    private AluguelService service;

    @PostMapping
    public Aluguel save(@RequestBody AluguelDTO dto){
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Aluguel update(@PathVariable Long id,@RequestBody AluguelDTO dto){
        return service.update(id, dto);
    }
}
