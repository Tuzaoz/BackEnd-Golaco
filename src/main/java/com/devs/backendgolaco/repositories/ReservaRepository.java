package com.devs.backendgolaco.repositories;

import com.devs.backendgolaco.entities.Campo;
import com.devs.backendgolaco.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long> {

    @Query( "SELECT obj FROM Reserva obj where obj.dataMarcada between :min and :max")
    List<Reserva> getReservasByDateRange (LocalDate min, LocalDate max);

    @Query("select obj FROM Reserva obj WHERE obj.dataMarcada = CURRENT_DATE ")
    List<Reserva> getTodayReservas();

    @Query("select obj FROM Reserva obj WHERE obj.dataMarcada = :date ")
    List<Reserva> getReservasByDay(LocalDate date);
}
