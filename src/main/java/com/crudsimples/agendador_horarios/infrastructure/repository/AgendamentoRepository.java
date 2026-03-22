package com.crudsimples.agendador_horarios.infrastructure.repository;

import com.crudsimples.agendador_horarios.infrastructure.entity.Agendamento;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    Agendamento findByProdutoServicoAndDataMarcadaBetween(String prodServico, LocalDateTime horaInicio, LocalDateTime horaFim);

    @Transactional
    void deleteByDataMarcadaAndNomeCliente(LocalDateTime horaMarcada, String nome);

    List<Agendamento> findByDataMarcadaBetween(LocalDateTime horaInicio, LocalDateTime horaFinal);

    Agendamento findByDataMarcadaAndNomeCliente(LocalDateTime agendamento, String cliente);

}
