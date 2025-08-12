package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.entities.Aluguel;
import com.andrey.tcc.exceptions.ResourceNotFoundException;
import com.andrey.tcc.repositories.LocacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository repository;

    public void save (Aluguel dto){
        repository.save(Mapper.parseObject(dto, Aluguel.class));
    }

    public Aluguel findById(Long id){
        Aluguel aluguel = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Locacao não encontrado"));
        return Mapper.parseObject(aluguel, Aluguel.class);
    }

    public List<Aluguel> findAll(){
        List<Aluguel> locacoes = repository.findAll();
        return Mapper.parseListObjects(locacoes, Aluguel.class);
    }

    public void update (Long id, Aluguel dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, Aluguel.class));
    }
}
