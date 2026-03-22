package com.crudsimples.agendador_horarios.infrastructure.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "agendamento")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yy HH:mm")
    private LocalDateTime dataMarcada;
    private LocalDateTime dataAtual = LocalDateTime.now();
    private String produtoServico;
    private String nomeCliente;
    private String telefoneCliente;
    private String nomeProfissional;
}
