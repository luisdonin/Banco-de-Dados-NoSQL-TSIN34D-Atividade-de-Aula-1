package br.edu.utfpr.td.tsi.gerenciador.documentos.controle;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Documento;
import br.edu.utfpr.td.tsi.gerenciador.documentos.persistencia.BancoDados;



@Controller
public class DocumentoController {

	private final BancoDados bancoDados;

	public DocumentoController(BancoDados bancoDados) {
		this.bancoDados = bancoDados;
		System.out.println("Banco de dados injetado: " + bancoDados);
	}

	@GetMapping(value = "/cadastrarDocumento")
	public String exibirPaginaCadastrarDocumento(Model model) {
		List<Autor> autores = bancoDados.listarAutores(); 
		model.addAttribute("autores", autores); 
		System.out.println("Autores disponíveis: " + autores);
		return "cadastrarDocumento";
	}

	@PostMapping(value = "/cadastrarDocumento")
	public String cadastrarDocumento(@RequestParam("autor.Id") String autorId, Documento documento) {
		Autor autor = bancoDados.buscarAutor(autorId); 
		if (autor != null) {
			documento.setAutor(autor);
		}
		documento.setId(UUID.randomUUID().toString());
		bancoDados.persistirDocumento(documento); 
		System.out.println("Documento cadastrado: " + documento);
		return "index";
	}

	@GetMapping(value = "/listarDocumentos")
	public String exibirPaginaListarDocumentos(Model model) {
		List<Documento> documentos = bancoDados.listarDocumentos();
		System.out.println(documentos);
		model.addAttribute("documentos", documentos);
		return "listarDocumentos";
	}

	@GetMapping(value = "/removerDocumento")
	public String removerDocumentos(@RequestParam String idDocumento) {
		System.out.println("removendo documento de id " + idDocumento);
		bancoDados.removerDocumento(idDocumento);
		return "index";
	}

}
