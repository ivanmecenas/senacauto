package br.com.senacauto.api.pessoa.modelo;

// import java.sql.Blob;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EN_PESSOA")
@Getter
@Setter
public class PessoaModelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String matricula;
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    // private Blob foto;

}
