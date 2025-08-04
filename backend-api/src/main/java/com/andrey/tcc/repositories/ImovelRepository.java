package com.andrey.tcc.repositories;

import com.andrey.tcc.entities.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
}
