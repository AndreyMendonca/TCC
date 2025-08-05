package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.controllers.DTOS.ImovelRequestDTO;
import com.andrey.tcc.controllers.DTOS.ManutencaoDTO;
import com.andrey.tcc.entities.Endereco;
import com.andrey.tcc.entities.Imovel;
import com.andrey.tcc.entities.Manutencao;
import com.andrey.tcc.entities.TipoImovel;
import com.andrey.tcc.repositories.ImovelRepository;
import com.andrey.tcc.repositories.TipoImovelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImovelService {

    @Autowired
    private ImovelRepository repository;

    @Autowired
    private TipoImovelService tipoImovelService;

    @Transactional
    public void save(ImovelRequestDTO dto){
        Imovel data = new Imovel();

        data = Mapper.parseObject(dto, Imovel.class);

        TipoImovel tipoImovel = tipoImovelService.findById(dto.getTipoImovel());
        data.setTipoImovel(tipoImovel);

        repository.save(data);
    }

    public Imovel findById(Long id){
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Imóvel não localizado"));
    }

    public List<Imovel> findAll(){
        return repository.findAll();
    }

    @Transactional
    public void update(Long id, ImovelRequestDTO dto){
        Imovel imovel = this.findById(id);

        dto.setId(id);
        if(imovel.getEndereco() != null){
            dto.getEndereco().setId(imovel.getEndereco().getId());
        }

        imovel = Mapper.parseObject(dto, Imovel.class);
        imovel.setTipoImovel(tipoImovelService.findById(dto.getTipoImovel()));

        repository.save(imovel);
    }

    @Transactional
    public Imovel addManutencao(Long id, ManutencaoDTO dto) {
        Imovel imovel = this.findById(id);
        Manutencao manutencao = Mapper.parseObject(dto, Manutencao.class);
        manutencao.setImovel(imovel);
        imovel.getManutencoes().add(manutencao);
        return repository.save(imovel);
    }

    public Imovel updateManutencao(Long id, Long idManutencao, ManutencaoDTO dto) {
        Imovel imovel = this.findById(id);
        Manutencao manutencao = buscarManutencao(idManutencao, imovel);

        manutencao.setIdentificao(dto.getIdentificao());
        manutencao.setDescricao(dto.getDescricao());
        manutencao.setDataRealizacao(dto.getDataRealizacao());

        return repository.save(imovel);
    }
    
    public void deleteManutencao(Long id, Long idManutencao){
        Imovel imovel = this.findById(id);
        Manutencao manutencao = buscarManutencao(idManutencao, imovel);
        imovel.getManutencoes().remove(manutencao);
        repository.save(imovel);
    }

    private Manutencao buscarManutencao(Long idManutencao, Imovel imovel) {
        return imovel.getManutencoes().stream()
                .filter(m -> m.getId().equals(idManutencao))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Manutenção não encontrada"));
    }
}
