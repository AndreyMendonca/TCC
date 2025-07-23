package com.andrey.tcc.repositories;

import com.andrey.tcc.entities.Aluguel;
import com.andrey.tcc.entities.TipoImovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoImovelRepository extends JpaRepository<TipoImovel, Long> {
}
