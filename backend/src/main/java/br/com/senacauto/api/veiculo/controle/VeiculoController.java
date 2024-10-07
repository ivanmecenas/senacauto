package br.com.senacauto.api.veiculo.controle;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.senacauto.api.veiculo.modelo.RespostaModeloVeiculo;
import br.com.senacauto.api.veiculo.modelo.VeiculoModelo;
import br.com.senacauto.api.veiculo.servico.VeiculoServico;

@RestController
@RequestMapping("/veiculo")
@CrossOrigin(origins = "*")
public class VeiculoController {

    @Autowired
    VeiculoServico servico;

    @GetMapping("/listar")
    public Iterable<VeiculoModelo> listar() {
        return servico.listar();
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody VeiculoModelo entidade) {
        return servico.cadastrarAlterar(entidade,"alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody VeiculoModelo entidade) {
        return servico.cadastrarAlterar(entidade,"cadastrar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModeloVeiculo>remover(@PathVariable long id) {
        return servico.remover(id);
    }
    
}
