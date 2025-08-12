package com.andrey.tcc.repositories;

import com.andrey.tcc.entities.Arquivo;
import com.andrey.tcc.entities.Encargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {
}
