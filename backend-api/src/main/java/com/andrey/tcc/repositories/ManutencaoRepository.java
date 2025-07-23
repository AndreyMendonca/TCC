package com.andrey.tcc.repositories;

import com.andrey.tcc.entities.Encargo;
import com.andrey.tcc.entities.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {
}
