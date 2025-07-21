package com.andrey.tcc.repositories;

import com.andrey.tcc.entities.Encargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncargoRepository extends JpaRepository<Encargo, Long> {
}
