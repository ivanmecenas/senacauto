package br.com.senacauto.api.perfil.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senacauto.api.perfil.modelo.PerfilModelo;
import br.com.senacauto.api.perfil.modelo.RespostaModeloPerfil;
import br.com.senacauto.api.perfil.servico.PerfilServico;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

    @Autowired
    PerfilServico servico;
    
    @GetMapping("/listar")
    public Iterable<PerfilModelo> listar() {
        return servico.listar();
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody PerfilModelo entidade) {
        return servico.cadastrarAlterar(entidade,"alterar");
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody PerfilModelo entidade) {
        return servico.cadastrarAlterar(entidade,"cadastrar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModeloPerfil>remover(@PathVariable long id) {
        return servico.remover(id);
    }
}
