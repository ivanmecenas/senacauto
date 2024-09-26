package br.com.senacauto.api.agendamento.controle;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class AgendamentoController {


    @GetMapping("/")
    public String home() {
        return new String("Ok, chegamos aqui.");
    }
    
}
