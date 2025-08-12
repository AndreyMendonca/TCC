package com.andrey.tcc.services;

import com.andrey.tcc.config.mapper.Mapper;
import com.andrey.tcc.controllers.DTOS.PessoaRequestDTO;
import com.andrey.tcc.controllers.DTOS.PessoaResponseDTO;
import com.andrey.tcc.entities.Arquivo;
import com.andrey.tcc.entities.Pessoa;
import com.andrey.tcc.exceptions.ResourceNotFoundException;
import com.andrey.tcc.repositories.ArquivoRepository;
import com.andrey.tcc.repositories.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    @Autowired
    private ArquivoRepository arquivoRepository;

    public void save(Pessoa pessoa){
        repository.save(pessoa);
    }

    public Pessoa findById(Long id){
        Pessoa pessoa = repository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Pessoa não encontrada"));
        return Mapper.parseObject(pessoa, Pessoa.class);
    }

    public List<Pessoa> findAll(){
        List<Pessoa> pessoas = repository.findAll();
        return Mapper.parseListObjects(pessoas, Pessoa.class);
    }

    public void update (Long id, Pessoa dto){
        Pessoa pessoa = this.findById(id);
        dto.setId(id);
        if(pessoa.getEndereco() != null){
            dto.getEndereco().setId(pessoa.getEndereco().getId());
        }
        repository.save(Mapper.parseObject(dto, Pessoa.class));
    }

    public PessoaResponseDTO salvarComArquivo(PessoaRequestDTO data, MultipartFile imagemPerfil, List<MultipartFile> arquivos) throws IOException {
        Pessoa pessoa = Mapper.parseObject(data, Pessoa.class);

        if (imagemPerfil != null && !imagemPerfil.isEmpty()) {
            Arquivo img = new Arquivo();
            img.setNome(imagemPerfil.getOriginalFilename());
            img.setTipo(imagemPerfil.getContentType());
            img.setArquivo(imagemPerfil.getBytes());
            arquivoRepository.save(img);
            pessoa.setImagemPerfil(img);
        }

        // Salvar a pessoa primeiro para ter o ID
        Pessoa pessoaSalva = repository.save(pessoa);

        List<Arquivo> arquivosRetorno = new ArrayList<>();

        // Se tiver outros arquivos
        if (arquivos != null) {
            for (MultipartFile file : arquivos) {
                Arquivo arq = new Arquivo();
                arq.setNome(file.getOriginalFilename());
                arq.setTipo(file.getContentType());
                arq.setArquivo(file.getBytes());
                arq.setPessoa(pessoaSalva);
                arquivoRepository.save(arq);
                arquivosRetorno.add(arq);
            }
        }

        PessoaResponseDTO dto = Mapper.parseObject(pessoa, PessoaResponseDTO.class);

        arquivosRetorno.forEach( x -> {
            dto.getArquivos().add(buildImageURL(x).toString());
        });

        dto.setImagemPerfil(buildImageURL(pessoa.getImagemPerfil()).toString());

        return dto;
    }

    private URI buildImageURL(Arquivo imagem) {
        return ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/arquivos/")
                .path(imagem.getId().toString())
                .build()
                .toUri();
    }
}
