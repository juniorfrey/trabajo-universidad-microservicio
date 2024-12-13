package com.universidad.agenda_service.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.universidad.agenda_service.Entities.Agenda;
import com.universidad.agenda_service.Repositories.AgendaRepository;

import java.util.Optional;

@RestController
public class AgendaController {
    
    @Autowired
    private AgendaRepository agendaRepository;

     // Crear una nueva agenda
    @PostMapping
    public ResponseEntity<Agenda> crearAgenda(@RequestBody Agenda agenda) {
        //agenda.setFechaCreacion(new Date()); // Establecer la fecha de creación
        Agenda nuevaAgenda = agendaRepository.save(agenda);
        return new ResponseEntity<>(nuevaAgenda, HttpStatus.CREATED);
    }

     // Obtener todas las agendas
     @GetMapping("/agenda")
     public ResponseEntity<List<Agenda>> obtenerTodasLasAgendas() {
         List<Agenda> agendas = agendaRepository.findAll();
         return new ResponseEntity<>(agendas, HttpStatus.OK);
     }

     @GetMapping("/agenda/{id}")
     public ResponseEntity<Agenda> obtenerAgendaPorId(@PathVariable Long id) {
         Optional<Agenda> agenda = agendaRepository.findById(id);
         return agenda.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                 .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
     }

    
    // Obtener agendas por usuario ID
    @GetMapping("/agenda/{usuarioId}")
    public ResponseEntity<List<Agenda>> obtenerAgendasPorUsuarioId(@PathVariable Long usuarioId) {
        List<Agenda> agendas = agendaRepository.findByUsuarioId(usuarioId);
        return new ResponseEntity<>(agendas, HttpStatus.OK);
    }

       // Actualizar una agenda por ID
    @PutMapping("/agenda/{id}")
    public ResponseEntity<Agenda> actualizarAgenda(@PathVariable Long id, @RequestBody Agenda agendaDetails) {
        Optional<Agenda> agendaOptional = agendaRepository.findById(id);
        if (agendaOptional.isPresent()) {
            Agenda agenda = agendaOptional.get();
            agenda.setTitulo(agendaDetails.getDescripcion());
            agenda.setDescripcion(agendaDetails.getDescripcion());
            Agenda agendaActualizada = agendaRepository.save(agenda);
            return new ResponseEntity<>(agendaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una agenda por ID
    @DeleteMapping("/agenda/{id}")
    public ResponseEntity<Void> eliminarAgenda(@PathVariable Long id) {
        Optional<Agenda> agenda = agendaRepository.findById(id);
        if (agenda.isPresent()) {
            agendaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
