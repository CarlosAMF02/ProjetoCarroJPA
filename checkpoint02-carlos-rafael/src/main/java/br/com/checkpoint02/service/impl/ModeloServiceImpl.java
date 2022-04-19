package br.com.checkpoint02.service.impl;

import java.util.List;

import br.com.checkpoint02.dao.impl.ModeloDAOImpl;
import br.com.checkpoint02.entity.Modelo;
import br.com.checkpoint02.service.GenericService;

public class ModeloServiceImpl extends GenericService<Modelo, Long>{
	
	private static ModeloServiceImpl instance = null;

	private ModeloDAOImpl modeloDAO;

	private ModeloServiceImpl() {
		this.modeloDAO = ModeloDAOImpl.getInstance();
	}

	public static ModeloServiceImpl getInstance() {
		if (instance == null) {
			instance = new ModeloServiceImpl();
		}
		return instance;
	}

	@Override
	public void cadastrar(Modelo entity) {
		try {
			modeloDAO.salvar(entity, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}

	}

	@Override
	public void atualizar(Modelo entity) {
		try {
			modeloDAO.atualizar(entity, getEntityManager());
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
			modeloDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Modelo obter(Long id) {
		Modelo modelo = null;

		try {
			modelo = modeloDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}

		return modelo;
	}

	@Override
	public List<Modelo> listar() {
		List<Modelo> modelos = null;

		try {
			modelos = modeloDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}

		return modelos;
	}
}
