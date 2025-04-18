package br.edu.utfpr.td.tsi.gerenciador.documentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/gerenciador.documentos");
		SpringApplication.run(Main.class, args);
	}
}
