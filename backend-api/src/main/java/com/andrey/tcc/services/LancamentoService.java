package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.controllers.DTOS.LancamentoRequestDTO;
import com.andrey.tcc.entities.Imovel;
import com.andrey.tcc.entities.Lancamento;
import com.andrey.tcc.exceptions.ResourceNotFoundException;
import com.andrey.tcc.repositories.LancamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository repository;

    @Autowired
    private ImovelService imovelService;

    public List<Lancamento> save(LancamentoRequestDTO dto){
        BigDecimal valorParcela = dto.getValorTotal()
                .divide(BigDecimal.valueOf(dto.getNumeroParcelas()), 2, RoundingMode.HALF_UP);

        Lancamento primeiraParcela = Mapper.parseObject(dto, Lancamento.class);
        primeiraParcela.setValorParcela(valorParcela);
        primeiraParcela.setParcelaAtual(1);
        primeiraParcela.setStatusLancamento(false);
        Imovel imovel = imovelService.findById(dto.getImovelId());
        primeiraParcela.setImovel(imovel);
        repository.save(primeiraParcela);

        primeiraParcela.setIdFamilia(primeiraParcela.getId());

        List<Lancamento> lancamentos = new ArrayList<>();
        lancamentos.add(primeiraParcela);

        if(dto.getNumeroParcelas() > 1){
            for (int i = 2; i <= dto.getNumeroParcelas(); i++) {
                Lancamento parcela = Mapper.parseObject(dto, Lancamento.class);
                parcela.setValorParcela(valorParcela);
                parcela.setParcelaAtual(i);
                parcela.setStatusLancamento(false);
                parcela.setIdFamilia(primeiraParcela.getId()); // usa o ID da primeira
                parcela.setDataVencimento(dto.getDataVencimento().plusMonths(i - 1));
                parcela.setIdentificacao(parcela.getIdentificacao() + " - " + i +"º Parcela");
                parcela.setImovel(imovel);
                lancamentos.add(parcela);
            }
            repository.saveAll(lancamentos);
        }
        return lancamentos;
    }

    public Lancamento findById(Long id){
        return repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Lançamento não encontrado"));
    }

    public List<Lancamento> findAll(){
        return repository.findAll();
    }

    public Lancamento update(Long id, Lancamento lancamento){
        this.findById(id);
        lancamento.setId(id);
        return repository.save(lancamento);
    }
}
