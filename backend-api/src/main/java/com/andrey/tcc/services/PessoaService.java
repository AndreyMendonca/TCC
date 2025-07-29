package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.entities.Locacao;
import com.andrey.tcc.entities.Pessoa;
import com.andrey.tcc.entities.enums.TipoPessoaEnum;
import com.andrey.tcc.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public void save(Pessoa pessoa){
        repository.save(pessoa);
    }

    public Pessoa findById(Long id){
        Pessoa pessoa = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Pessoa não encontrada"));
        return Mapper.parseObject(pessoa, Pessoa.class);
    }

    public List<Pessoa> findAll(){
        List<Pessoa> pessoas = repository.findAll();
        return Mapper.parseListObjects(pessoas, Pessoa.class);
    }

    public void update (Long id, Pessoa dto){
        this.findById(id);
        dto.setId(id);
        repository.save(Mapper.parseObject(dto, Pessoa.class));
    }
}
