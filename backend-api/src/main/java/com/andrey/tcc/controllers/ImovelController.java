package com.andrey.tcc.controllers;

import com.andrey.tcc.controllers.DTOS.ImovelRequestDTO;
import com.andrey.tcc.entities.Imovel;
import com.andrey.tcc.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("imoveis")
public class ImovelController {
    @Autowired
    private ImovelService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ImovelRequestDTO dto){
        service.save(dto);
    }

    @GetMapping("/{id}")
    public Imovel findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Imovel> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ImovelRequestDTO dto){
        service.update(id, dto);
    }

}
