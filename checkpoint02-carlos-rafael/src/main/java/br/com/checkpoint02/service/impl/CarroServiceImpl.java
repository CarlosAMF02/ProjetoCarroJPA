package br.com.checkpoint02.service.impl;

import java.util.List;

import br.com.checkpoint02.dao.impl.CarroDAOImpl;
import br.com.checkpoint02.entity.Carro;
import br.com.checkpoint02.service.GenericService;

public class CarroServiceImpl extends GenericService<Carro, Long> {

	private static CarroServiceImpl instance = null;

	private CarroDAOImpl carroDAO;

	private CarroServiceImpl() {
		this.carroDAO = CarroDAOImpl.getInstance();
	}

	public static CarroServiceImpl getInstance() {
		if (instance == null) {
			instance = new CarroServiceImpl();
		}
		return instance;
	}

	@Override
	public void cadastrar(Carro entity) {
		try {
			carroDAO.salvar(entity, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}

	}

	@Override
	public void atualizar(Carro entity) {
		try {
			carroDAO.atualizar(entity, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public void remover(Long id) {
		try {
			carroDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Carro obter(Long id) {
		Carro carro = null;

		try {
			carro = carroDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}

		return carro;
	}

	@Override
	public List<Carro> listar() {
		List<Carro> carros = null;

		try {
			carros = carroDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}

		return carros;
	}
}
