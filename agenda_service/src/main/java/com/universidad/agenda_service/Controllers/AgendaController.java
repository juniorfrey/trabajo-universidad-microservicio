package com.universidad.agenda_service.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.universidad.agenda_service.Repositories.AgendaRepository;

@RestController
public class AgendaController {
    
    private final AgendaRepository agendaRepository;

        public AgendaController(AgendaRepository agendaRepository) {
        this.agendaRepository = agendaRepository;
    }



}
