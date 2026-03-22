package com.crudsimples.agendador_horarios.controller;

import com.crudsimples.agendador_horarios.infrastructure.entity.Agendamento;
import com.crudsimples.agendador_horarios.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {
    private final AgendamentoService agendamentoService;


    @PostMapping
    public ResponseEntity<Agendamento> salvarAgendamento(@RequestBody Agendamento agendamento){
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String nomeCliente, @RequestParam LocalDateTime dataHoraMarcada){
        agendamentoService.deletarAgendamento(dataHoraMarcada, nomeCliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Agendamento>> buscarAgendamentosPorDia(@RequestParam @DateTimeFormat(pattern = "dd/MM/yy") LocalDate data){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosPorDia(data));
    }

    @PutMapping
    public ResponseEntity<Agendamento> alterarAgendamento(@RequestBody Agendamento agendamento,
                                                          @RequestParam String nomeCliente,
                                                          @RequestParam LocalDateTime agendaMarcada){
        return ResponseEntity.ok().body(agendamentoService.alterarAgendamento(agendamento, nomeCliente,
                agendaMarcada));
    }
}
