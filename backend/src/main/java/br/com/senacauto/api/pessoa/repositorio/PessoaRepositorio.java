package br.com.senacauto.api.pessoa.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.senacauto.api.pessoa.modelo.PessoaModelo;

@Repository
public interface PessoaRepositorio extends CrudRepository<PessoaModelo, Long>{

    
}
