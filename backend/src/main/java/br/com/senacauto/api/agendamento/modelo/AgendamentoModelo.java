package br.com.senacauto.api.agendamento.modelo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EN_AGENDAMENTO")
@Getter
@Setter
public class AgendamentoModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoAgendamento;
    private String origem;
    private String destino;
    private Boolean status; // Se é um agendamento ativo ou nao
    private String turno;
    private LocalDate dataAgendamento;
    // FK DE VEÍCULO
    // FK DE MOTORISTA
}
