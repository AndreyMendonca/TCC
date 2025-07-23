package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.entities.Endereco;
import com.andrey.tcc.repositories.EnderecoRepository;
import com.andrey.tcc.repositories.EnderecoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository repository;

    public void save (Endereco dto){
        repository.save(Mapper.parseObject(dto, Endereco.class));
    }

    public Endereco findById(Long id){
        Endereco endereco = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Endereco não encontrado"));
        return Mapper.parseObject(endereco, Endereco.class);
    }

    public void update (Long id, Endereco dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, Endereco.class));
    }
}
