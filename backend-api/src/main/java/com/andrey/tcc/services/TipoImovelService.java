package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.entities.TipoImovel;
import com.andrey.tcc.exceptions.ResourceNotFoundException;
import com.andrey.tcc.repositories.TipoImovelRepository;
import com.andrey.tcc.repositories.TipoImovelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoImovelService {
    @Autowired
    private TipoImovelRepository repository;

    public void save (TipoImovel dto){
        repository.save(Mapper.parseObject(dto, TipoImovel.class));
    }

    public TipoImovel findById(Long id){
        TipoImovel tipoImovel = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tipo de Imovel não encontrado"));
        return Mapper.parseObject(tipoImovel, TipoImovel.class);
    }

    public List<TipoImovel> findAll(){
        List<TipoImovel> tiposImovel = repository.findAll();
        return Mapper.parseListObjects(tiposImovel, TipoImovel.class);
    }

    public void update (Long id, TipoImovel dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, TipoImovel.class));
    }
}
