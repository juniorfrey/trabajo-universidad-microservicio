package com.universidad.agenda_service.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.universidad.agenda_service.Entities.Agenda;
import com.universidad.agenda_service.Repositories.AgendaRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@RestController
public class AgendaController {
    
    private final RestTemplate restTemplate;
    private final AgendaRepository agendaRepository;

    public AgendaController(AgendaRepository agendaRepository, RestTemplate restTemplate) {
        this.agendaRepository = agendaRepository;
        this.restTemplate = restTemplate;
    }




}
