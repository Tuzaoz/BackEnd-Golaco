package com.devs.backendgolaco.services;

import com.devs.backendgolaco.entities.Reserva;
import com.devs.backendgolaco.repositories.ReservaRepository;
import com.devs.backendgolaco.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    private ReservaRepository reservaRepository;

    public List<Reserva> findAll(){
        return reservaRepository.findAll();
    }

    public Reserva findById(Integer id) {
        Optional<Reserva> obj = reservaRepository.findById(Long.valueOf(id));
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Reserva> findTodayDate(){
        return reservaRepository.getTodayReservas();
    }

    public Reserva insert(Reserva reserva){
        return reservaRepository.save(reserva);
    }
    
    public List<Reserva> getReservasByDateRange(String minDate, String maxDate){
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return reservaRepository.getReservasByDateRange(min,max);
    }
    public List<Reserva> getReservasByDay(String date){
        LocalDate data = LocalDate.parse(date);
        return reservaRepository.getReservasByDay(data);
    }
    public Reserva update(Long id, Reserva reserva) {
        reserva.setId(id);
        Reserva reservaupdt = reservaRepository.getReferenceById(Long.valueOf(id));
        updateData(reservaupdt,reserva);
        return reservaRepository.save(reservaupdt);
    }
    private void updateData(Reserva entity, Reserva obj) {
        entity.setHorario(obj.getHorario());
        entity.setCampo(obj.getCampo());
        entity.setDataMarcada(obj.getDataMarcada());

    }

}
