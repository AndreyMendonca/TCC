package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.controllers.DTOS.EncargoDTO;
import com.andrey.tcc.entities.Encargo;
import com.andrey.tcc.repositories.EncargoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncargoService {
    @Autowired
    private EncargoRepository repository;

    public void save (EncargoDTO dto){
        repository.save(Mapper.parseObject(dto, Encargo.class));
    }

    public EncargoDTO findById(Long id){
        Encargo encargo = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Encarco não encontrado"));
        return Mapper.parseObject(encargo, EncargoDTO.class);
    }

    public List<EncargoDTO> findAll(){
        List<Encargo> encargos = repository.findAll();
        return Mapper.parseListObjects(encargos, EncargoDTO.class);
    }

    public void update (Long id, EncargoDTO dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, Encargo.class));
    }
}
