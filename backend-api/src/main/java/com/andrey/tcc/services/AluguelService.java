package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.controllers.DTOS.EncargoDTO;
import com.andrey.tcc.entities.Aluguel;
import com.andrey.tcc.entities.Encargo;
import com.andrey.tcc.repositories.AluguelRepository;
import com.andrey.tcc.repositories.EncargoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository repository;

    public void save (Aluguel dto){
        repository.save(Mapper.parseObject(dto, Aluguel.class));
    }

    public Aluguel findById(Long id){
        Aluguel aluguel = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Encarco não encontrado"));
        return Mapper.parseObject(aluguel, Aluguel.class);
    }

    public List<Aluguel> findAll(){
        List<Aluguel> alugueis = repository.findAll();
        return Mapper.parseListObjects(alugueis, Aluguel.class);
    }

    public void update (Long id, Aluguel dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, Aluguel.class));
    }
}
