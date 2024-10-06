package br.com.senacauto.api.agendamento.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.senacauto.api.agendamento.modelo.AgendamentoModelo;

@Repository
public interface AgendamentoRepositorio extends CrudRepository<AgendamentoModelo, Long>{
    
}
