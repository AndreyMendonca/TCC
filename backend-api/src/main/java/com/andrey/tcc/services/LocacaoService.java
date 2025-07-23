package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.entities.Locacao;
import com.andrey.tcc.repositories.LocacaoRepository;
import com.andrey.tcc.repositories.LocacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocacaoService {
    @Autowired
    private LocacaoRepository repository;

    public void save (Locacao dto){
        repository.save(Mapper.parseObject(dto, Locacao.class));
    }

    public Locacao findById(Long id){
        Locacao locacao = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Locacao não encontrado"));
        return Mapper.parseObject(locacao, Locacao.class);
    }

    public List<Locacao> findAll(){
        List<Locacao> locacoes = repository.findAll();
        return Mapper.parseListObjects(locacoes, Locacao.class);
    }

    public void update (Long id, Locacao dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, Locacao.class));
    }
}
