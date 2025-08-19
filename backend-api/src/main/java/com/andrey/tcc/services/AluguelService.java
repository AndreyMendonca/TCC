package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.controllers.DTOS.AluguelDTO;
import com.andrey.tcc.entities.Aluguel;
import com.andrey.tcc.entities.Encargo;
import com.andrey.tcc.entities.Imovel;
import com.andrey.tcc.entities.Pessoa;
import com.andrey.tcc.repositories.AluguelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AluguelService {
    @Autowired
    private AluguelRepository repository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ImovelService imovelService;

    @Autowired
    private EncargoService encargoService;

    public Aluguel save(AluguelDTO dto) {
        Aluguel aluguel = Mapper.parseObject(dto, Aluguel.class);

        Pessoa inquilino = pessoaService.findById(dto.getInquilino());
        Pessoa fiador = pessoaService.findById(dto.getFiador());
        Imovel imovel = imovelService.findById(dto.getImovel());

        if(!dto.getEncargos().isEmpty()){
            dto.getEncargos().forEach(encargoDTO -> {
                Encargo encargo = Mapper.parseObject(encargoDTO, Encargo.class);
                encargo.setAluguel(aluguel);
                aluguel.getEncargos().add(encargo);
            });
        }

        aluguel.setInquilino(inquilino);
        aluguel.setFiador(fiador);
        aluguel.setImovel(imovel);

        return repository.save(aluguel);
    }
}

