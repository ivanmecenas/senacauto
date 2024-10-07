package br.com.senacauto.api.veiculo.servico;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senacauto.api.veiculo.modelo.RespostaModeloVeiculo;
import br.com.senacauto.api.veiculo.modelo.VeiculoModelo;
import br.com.senacauto.api.veiculo.repositorio.VeiculoRepositorio;

@Service
public class VeiculoServico {

    @Autowired
    VeiculoRepositorio repositorio;

    @Autowired
    RespostaModeloVeiculo resposta;

    // Lista todos os veículos
    public Iterable<VeiculoModelo> listar() {
        return repositorio.findAll();
    }

    // Método para cadatrar veículos
    public ResponseEntity<?> cadastrarAlterar(VeiculoModelo entidade, String acao) {

        if (entidade.getModelo().equals("")) {
            resposta.setMensagem("O modelo é obrigatório");
            return new ResponseEntity<RespostaModeloVeiculo>(resposta, HttpStatus.BAD_REQUEST);
        } else if (entidade.getAno() == null) {
            resposta.setMensagem("O ano é obrigatório");
            return new ResponseEntity<RespostaModeloVeiculo>(resposta, HttpStatus.BAD_REQUEST);
        } else if (entidade.getPlaca().equals("")) {
            resposta.setMensagem("A placa é obrigatória");
            return new ResponseEntity<RespostaModeloVeiculo>(resposta, HttpStatus.BAD_REQUEST);
        } else if (entidade.getCategoria().equals("")) {
            resposta.setMensagem("A categoria é obrigatória");
            return new ResponseEntity<RespostaModeloVeiculo>(resposta, HttpStatus.BAD_REQUEST);
        } else if (entidade.getSituacao().equals("")) {
            resposta.setMensagem("A situação é obrigatória");
            return new ResponseEntity<RespostaModeloVeiculo>(resposta, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<VeiculoModelo>(repositorio.save(entidade), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<VeiculoModelo>(repositorio.save(entidade), HttpStatus.OK);
            }
        }
    }

    // método para remover veículo
    public ResponseEntity<RespostaModeloVeiculo> remover(long id) {

        Optional<VeiculoModelo> veiculoPorId = repositorio.findById(id);

        // Verifica se o veículo está presente
        if (veiculoPorId.isPresent()) {
            repositorio.deleteById(id);
            resposta.setMensagem("Veículo removido com sucesso!");
            return new ResponseEntity<RespostaModeloVeiculo>(resposta, HttpStatus.OK);
        } else {
            resposta.setMensagem("Agendamento não encontrado!");
            return new ResponseEntity<RespostaModeloVeiculo>(resposta, HttpStatus.BAD_REQUEST);
        }
    }
}
