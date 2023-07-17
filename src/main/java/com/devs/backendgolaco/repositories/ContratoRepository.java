package com.devs.backendgolaco.repositories;

import com.devs.backendgolaco.entities.Campo;
import com.devs.backendgolaco.entities.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato,Long> {
}
