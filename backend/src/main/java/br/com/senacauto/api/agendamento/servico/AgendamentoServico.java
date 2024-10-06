package br.com.senacauto.api.agendamento.servico;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senacauto.api.agendamento.modelo.AgendamentoModelo;
import br.com.senacauto.api.agendamento.modelo.RespostaModeloAgendamento;
import br.com.senacauto.api.agendamento.repositorio.AgendamentoRepositorio;

@Service
public class AgendamentoServico {

    @Autowired
    private AgendamentoRepositorio repositorio;

    @Autowired
    private RespostaModeloAgendamento resposta;

    // Lista todos os agendamentos
    public Iterable<AgendamentoModelo> listar() {
        return repositorio.findAll();
    }

    // Método para cadatrar agendamentos
    public ResponseEntity<?> cadastrarAlterar(AgendamentoModelo entidade, String acao) {

        if (entidade.getOrigem().equals("")) {
            resposta.setMensagem("A origem é obrigatória");
            return new ResponseEntity<RespostaModeloAgendamento>(resposta, HttpStatus.BAD_REQUEST);
        } else if (entidade.getDestino().equals("")) {
            resposta.setMensagem("O destino é obrigatório");
            return new ResponseEntity<RespostaModeloAgendamento>(resposta, HttpStatus.BAD_REQUEST);
        } else if (entidade.getStatus() == null) {
            resposta.setMensagem("O status é obrigatório");
            return new ResponseEntity<RespostaModeloAgendamento>(resposta, HttpStatus.BAD_REQUEST);
        } else if (entidade.getTurno().equals("")) {
            resposta.setMensagem("O turno é obrigatório");
            return new ResponseEntity<RespostaModeloAgendamento>(resposta, HttpStatus.BAD_REQUEST);
        }
        if (entidade.getDataAgendamento() == null || entidade.getDataAgendamento().equals(LocalDate.MIN)) {
            resposta.setMensagem("A data de agendamento é obrigatória");
            return new ResponseEntity<RespostaModeloAgendamento>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<AgendamentoModelo>(repositorio.save(entidade), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<AgendamentoModelo>(repositorio.save(entidade), HttpStatus.OK);
            }
        }
    }

    // método para remover agendamento
    public ResponseEntity<RespostaModeloAgendamento> remover(long id) {

        Optional<AgendamentoModelo> agendamentoPorId = repositorio.findById(id);

        // Verifica se o agendamento está presente
        if (agendamentoPorId.isPresent()) {
            repositorio.deleteById(id);
            resposta.setMensagem("Agendamento removido com sucesso!");
            return new ResponseEntity<RespostaModeloAgendamento>(resposta, HttpStatus.OK);
        } else {
            resposta.setMensagem("Agendamento não encontrado!");
            return new ResponseEntity<RespostaModeloAgendamento>(resposta, HttpStatus.BAD_REQUEST);
        }
    }

}