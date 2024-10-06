package br.com.senacauto.api.agendamento.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.senacauto.api.agendamento.modelo.AgendamentoModelo;
import br.com.senacauto.api.agendamento.modelo.RespostaModeloAgendamento;
import br.com.senacauto.api.agendamento.servico.AgendamentoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/agendamento")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    AgendamentoServico servico;

    @GetMapping("/listar")
    public Iterable<AgendamentoModelo> listar() {
        return servico.listar();
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody AgendamentoModelo entidade) {
        return servico.cadastrarAlterar(entidade,"alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody AgendamentoModelo entidade) {
        return servico.cadastrarAlterar(entidade,"cadastrar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModeloAgendamento>remover(@PathVariable long id) {
        return servico.remover(id);
    }
    
}
