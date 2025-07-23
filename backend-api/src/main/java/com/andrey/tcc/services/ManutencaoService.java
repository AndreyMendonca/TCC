package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.entities.Manutencao;
import com.andrey.tcc.repositories.ManutencaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoService {
    @Autowired
    private ManutencaoRepository repository;

    public void save (Manutencao dto){
        repository.save(Mapper.parseObject(dto, Manutencao.class));
    }

    public Manutencao findById(Long id){
        Manutencao manutencao = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Manutencao não encontrado"));
        return Mapper.parseObject(manutencao, Manutencao.class);
    }

    public List<Manutencao> findAll(){
        List<Manutencao> manutencaos = repository.findAll();
        return Mapper.parseListObjects(manutencaos, Manutencao.class);
    }

    public void update (Long id, Manutencao dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, Manutencao.class));
    }
}
