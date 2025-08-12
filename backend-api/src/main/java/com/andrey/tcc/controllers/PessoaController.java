package com.andrey.tcc.controllers;

import com.andrey.tcc.controllers.DTOS.PessoaRequestDTO;
import com.andrey.tcc.controllers.DTOS.PessoaResponseDTO;
import com.andrey.tcc.entities.Pessoa;
import com.andrey.tcc.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    @Autowired
    private PessoaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Pessoa pessoa){
        service.save(pessoa);
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping
    public List<Pessoa> findAll(){
        return service.findAll();
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Pessoa pessoa){
        service.update(id, pessoa);
    }

    @PostMapping(value = "/todosDados")
    public ResponseEntity<PessoaResponseDTO> salvar(
            @ModelAttribute PessoaRequestDTO dto,
            @RequestPart(value = "imagemPerfil", required = false) MultipartFile imagemPerfil,
            @RequestPart(value = "arquivos", required = false) List<MultipartFile> arquivos
    ) throws IOException {
        PessoaResponseDTO salva = service.salvarComArquivo(dto, imagemPerfil, arquivos);
        return ResponseEntity.ok(salva);
    }

}
