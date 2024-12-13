package com.universidad.agenda_service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.universidad.agenda_service.Entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    
}
