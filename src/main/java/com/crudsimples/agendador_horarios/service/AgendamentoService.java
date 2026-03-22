package com.crudsimples.agendador_horarios.service;

import com.crudsimples.agendador_horarios.infrastructure.entity.Agendamento;
import com.crudsimples.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public Agendamento salvarAgendamento(Agendamento agendamento){
        LocalDateTime horaAgendada = agendamento.getDataMarcada();
        LocalDateTime horaFim = agendamento.getDataMarcada().plusHours(1);

        Agendamento agenda = agendamentoRepository.findByProdutoServicoAndDataMarcadaBetween(agendamento.getProdutoServico(), horaAgendada, horaFim);

        if(Objects.nonNull(agenda)){
            throw new RuntimeException("Essa data já foi agendada");
        }

        return agendamentoRepository.save(agendamento);
    }

    public void deletarAgendamento(LocalDateTime horaMarcada, String nome){
        agendamentoRepository.deleteByDataMarcadaAndNomeCliente(horaMarcada, nome);
    }

    public List<Agendamento> buscarAgendamentosPorDia(LocalDate data){
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinal = data.atTime(23, 59, 59);
        return agendamentoRepository.findByDataMarcadaBetween(primeiraHoraDia, horaFinal);
    }

    public Agendamento alterarAgendamento(Agendamento agendamento, String cliente, LocalDateTime agenda){
        Agendamento agendaMarcada = agendamentoRepository.findByDataMarcadaAndNomeCliente(agenda, cliente);

        if(Objects.isNull(agendaMarcada)){
            throw new RuntimeException("Hora não foi marcada");
        }

        agendamento.setId(agendamento.getId());
        return agendamentoRepository.save(agendamento);
    }



}
