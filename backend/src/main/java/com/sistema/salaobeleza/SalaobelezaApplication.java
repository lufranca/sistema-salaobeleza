package com.sistema.salaobeleza;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sistema.salaobeleza.entities.Cliente;
import com.sistema.salaobeleza.entities.Servico;
import com.sistema.salaobeleza.repositories.ClienteRepository;
import com.sistema.salaobeleza.repositories.ServicoRepository;

@SpringBootApplication
public class SalaobelezaApplication implements CommandLineRunner{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SalaobelezaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente c1 = new Cliente(null, "Maria da Silva");
		Cliente c2 = new Cliente(null, "Joana de Souza");
		
		Servico s1 = new Servico(null, "Alisamento", "Progressiva e corte", 250.00, c1);
		Servico s2 = new Servico(null, "Cor", "Raiz, escova", 90.00, c2);
		Servico s3 = new Servico(null, "Luzes", "Luzes cabelo curto", 220.00, c2);
		Servico s4 = new Servico(null, "Luzes", "Morena iluminada", 200.00, c1);
		
		c1.getServicos().addAll(Arrays.asList(s1, s4));
		c2.getServicos().addAll(Arrays.asList(s2, s3));
		
		clienteRepository.saveAll(Arrays.asList(c1, c2));
		servicoRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
	}
}
