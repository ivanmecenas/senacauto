package br.com.senacauto.api.perfil.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senacauto.api.perfil.modelo.PerfilModelo;
import br.com.senacauto.api.perfil.modelo.RespostaModeloPerfil;
import br.com.senacauto.api.perfil.repositorio.PerfilRepositorio;

@Service
public class PerfilServico {

    @Autowired
    private PerfilRepositorio repositorio;

    @Autowired
    private RespostaModeloPerfil resposta;

    // Lista todos os agendamentos
    public Iterable<PerfilModelo> listar() {
        return repositorio.findAll();
    }

    // Método para cadatrar agendamentos
    public ResponseEntity<?> cadastrarAlterar(PerfilModelo entidade, String acao) {

        if (entidade.getDescricao().equals("")) {
            resposta.setMensagem("A descrição é obrigatória");
            return new ResponseEntity<RespostaModeloPerfil>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<PerfilModelo>(repositorio.save(entidade), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<PerfilModelo>(repositorio.save(entidade), HttpStatus.OK);
            }
        }
    }

    // método para remover agendamento
    public ResponseEntity<RespostaModeloPerfil> remover(long id) {

        Optional<PerfilModelo> agendamentoPorId = repositorio.findById(id);

        // Verifica se o agendamento está presente
        if (agendamentoPorId.isPresent()) {
            repositorio.deleteById(id);
            resposta.setMensagem("Agendamento removido com sucesso!");
            return new ResponseEntity<RespostaModeloPerfil>(resposta, HttpStatus.OK);
        } else {
            resposta.setMensagem("Agendamento não encontrado!");
            return new ResponseEntity<RespostaModeloPerfil>(resposta, HttpStatus.BAD_REQUEST);
        }
    }

}
