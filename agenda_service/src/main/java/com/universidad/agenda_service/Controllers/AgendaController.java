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

        @GetMapping("/agenda/{usuarioId}")
    public String obtenerAgenda(@PathVariable Long usuarioId) {
        // Llamada al microservicio usuario-service
        String usuarioInfo = restTemplate.getForObject("http://usuario-service/usuarios/" + usuarioId, String.class);

        // Obtener la agenda del usuario
        Optional<Agenda> agenda = agendaRepository.findById(usuarioId);
        return agenda.map(a -> "Agenda de " + usuarioInfo + ": " + a.getDescripcion())
                     .orElse("Agenda no encontrada para el usuario");
    }



}
