package com.devs.backendgolaco.repositories;

import com.devs.backendgolaco.entities.Campo;
import com.devs.backendgolaco.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long> {
}
