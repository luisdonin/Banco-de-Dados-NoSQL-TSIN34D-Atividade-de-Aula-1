package br.edu.utfpr.td.tsi.gerenciador.documentos.persistencia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Autor;
import br.edu.utfpr.td.tsi.gerenciador.documentos.modelo.Documento;
@Component
public class BancoDados {

	private List<Documento> documentos = new ArrayList<Documento>();
	private List<Autor> autores = new ArrayList<Autor>();

	public void persistirAutor(Autor autor){
		this.autores.add(autor);
		System.out.println("Autor persistido: " + autor.getNome());
	}

	public void persistirDocumento(Documento documento) {
		this.documentos.add(documento);
	}

	public List<Documento> listarDocumentos() {
		return documentos;
	}

	public List<Autor> listarAutores() {
		return autores;
	}
	public Autor buscarAutor(String id) {
		for (Autor autor : autores){
			if(autor.getId().equals(id)){
				return autor;
			}
		}
		return null;
	}

	public void removerDocumento(String id) {
		List<Documento> listaAtualizada = new ArrayList<Documento>();
		for (Documento documento : documentos) {
			if (!documento.getId().equals(id)) {
				listaAtualizada.add(documento);
			}
		}
		this.documentos = listaAtualizada;
	}

	

}
