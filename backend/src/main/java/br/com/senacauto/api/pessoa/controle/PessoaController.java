package br.com.senacauto.api.pessoa.controle;

import org.springframework.web.bind.annotation.RestController;

import br.com.senacauto.api.pessoa.modelo.PessoaModelo;
import br.com.senacauto.api.pessoa.modelo.RespostaModelo;
import br.com.senacauto.api.pessoa.servico.PessoaServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin(origins = "*")
public class PessoaController {

    @Autowired
    private PessoaServico ps;

    @GetMapping("/teste")
    public String teste() {
        return "ok, PessoaController acessível";
    }

    @GetMapping("/listar")
    public Iterable<PessoaModelo> listar() {
        return ps.listar();
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody PessoaModelo pm) {
        return ps.cadastrarAlterar(pm,"alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody PessoaModelo pm) {
        return ps.cadastrarAlterar(pm,"cadastrar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo>remover(@PathVariable long id) {
        return ps.remover(id);
    }

}
