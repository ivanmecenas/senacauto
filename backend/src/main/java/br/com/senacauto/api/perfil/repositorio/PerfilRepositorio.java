package br.com.senacauto.api.perfil.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.senacauto.api.perfil.modelo.PerfilModelo;

@Repository
public interface PerfilRepositorio extends CrudRepository<PerfilModelo, Long>{
    
}
