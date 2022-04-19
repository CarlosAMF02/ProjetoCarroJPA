package br.com.checkpoint02.main;

import java.util.ArrayList;
import java.util.List;

import br.com.checkpoint02.entity.Acessorio;
import br.com.checkpoint02.entity.Carro;
import br.com.checkpoint02.entity.Modelo;
import br.com.checkpoint02.service.impl.AcessorioServiceImpl;
import br.com.checkpoint02.service.impl.CarroServiceImpl;
import br.com.checkpoint02.service.impl.ModeloServiceImpl;

public class Main {
	public static void main(String[] args) {
		Modelo modelo = new Modelo("Corolla");
		Acessorio acessorio1 = new Acessorio("Insulfilm");
		Acessorio acessorio2 = new Acessorio("Tapetes");
		Carro carro = new Carro("ASD9A90","Preto","9BG116GW04C400001");
		
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		
		modeloService.cadastrar(modelo);
		acessorioService.cadastrar(acessorio1);
		acessorioService.cadastrar(acessorio2);
		carroService.cadastrar(carro);
		
		List<Acessorio> acessorios = new ArrayList<Acessorio>();
		acessorios.add(acessorio1);
		acessorios.add(acessorio2);
		carro.setModelo(modelo);
		carro.setAcessorios(acessorios);
		carroService.atualizar(carro);
		List<Carro> carros = carroService.listar();
		carros.forEach(System.out::println);

	}
}
