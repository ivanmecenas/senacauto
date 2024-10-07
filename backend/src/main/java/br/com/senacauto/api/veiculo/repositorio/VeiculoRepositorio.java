package br.com.senacauto.api.veiculo.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.senacauto.api.veiculo.modelo.VeiculoModelo;

@Repository
public interface VeiculoRepositorio extends CrudRepository<VeiculoModelo, Long> {
    
}
