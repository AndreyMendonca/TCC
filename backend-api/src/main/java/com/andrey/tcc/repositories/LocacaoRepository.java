package com.andrey.tcc.repositories;

import com.andrey.tcc.entities.Aluguel;
import com.andrey.tcc.entities.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
}
