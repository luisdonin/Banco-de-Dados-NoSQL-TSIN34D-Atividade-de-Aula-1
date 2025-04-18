package br.edu.utfpr.td.tsi.gerenciador.documentos.controle;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import br.edu.utfpr.td.tsi.gerenciador.documentos.persistencia.BancoDados;

@Controller
public class AutorController {

    private final BancoDados bancoDados;

    
    public AutorController(BancoDados bancoDados) {
        this.bancoDados = bancoDados;
    }

    @GetMapping(value = "/cadastrarAutor")
    public String exibirPaginaCadastrarAutor() {
        return "cadastrarAutor";
    }

    @PostMapping(value = "/cadastrarAutor")
    public String cadastrarAutor(Autor autor) {
        autor.setId(UUID.randomUUID().toString());
        bancoDados.persistirAutor(autor);
        System.out.println("Autor cadastrado: " + autor);
        return "index";
    }
}


