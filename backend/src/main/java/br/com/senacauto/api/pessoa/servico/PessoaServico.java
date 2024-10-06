package br.com.senacauto.api.pessoa.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.senacauto.api.pessoa.modelo.PessoaModelo;
import br.com.senacauto.api.pessoa.modelo.RespostaModelo;
import br.com.senacauto.api.pessoa.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {

    @Autowired
    private PessoaRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    // Lista todas as pessoas
    public Iterable<PessoaModelo> listar(){
        return pr.findAll();
    }

    // Método para cadatrar pessoas
    public ResponseEntity<?> cadastrarAlterar(PessoaModelo pm, String acao){

        if (pm.getMatricula().equals("")){
            rm.setMensagem("Matrícula é obrigatória");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getEmail().equals("")){
            rm.setMensagem("Email é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getNome().equals("")){
            rm.setMensagem("Nome é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getTelefone().equals("")){
            rm.setMensagem("Telefone é obrigatório");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else if (pm.getSenha().equals("")){
            rm.setMensagem("Senha é obrigatória");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        // } else if (pm.getFoto().equals(null)){
        //     rm.setMensagem("Foto é obrigatória");
        //     return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")){
                return new ResponseEntity<PessoaModelo>(pr.save(pm), HttpStatus.CREATED);
            } else{
                return new ResponseEntity<PessoaModelo>(pr.save(pm), HttpStatus.OK);
            }
        }
    }

    //método para remover pessoa
    public ResponseEntity<RespostaModelo> remover(long id){
        pr.deleteById(id);
        rm.setMensagem("Pessoa removida com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }

}
