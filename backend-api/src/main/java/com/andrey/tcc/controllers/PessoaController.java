package com.andrey.tcc.controllers;

import com.andrey.tcc.entities.Pessoa;
import com.andrey.tcc.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping
    public void save(@RequestBody Pessoa pessoa){
        service.save(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Pessoa> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Pessoa pessoa){
        service.update(id, pessoa);
    }

}
