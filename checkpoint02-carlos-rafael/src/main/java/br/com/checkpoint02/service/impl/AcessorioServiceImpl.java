package br.com.checkpoint02.service.impl;

import java.util.List;

import br.com.checkpoint02.dao.impl.AcessorioDAOImpl;
import br.com.checkpoint02.entity.Acessorio;
import br.com.checkpoint02.service.GenericService;

public class AcessorioServiceImpl extends GenericService<Acessorio, Long>{
	
	private static AcessorioServiceImpl instance = null;

	private AcessorioDAOImpl acessorioDAO;

	private AcessorioServiceImpl() {
		this.acessorioDAO = AcessorioDAOImpl.getInstance();
	}

	public static AcessorioServiceImpl getInstance() {
		if (instance == null) {
			instance = new AcessorioServiceImpl();
		}
		return instance;
	}

	@Override
	public void cadastrar(Acessorio entity) {
		try {
			acessorioDAO.salvar(entity, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}

	}

	@Override
	public void atualizar(Acessorio entity) {
		try {
			acessorioDAO.atualizar(entity, getEntityManager());
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
			acessorioDAO.remover(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
			getEntityManager().getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
	}

	@Override
	public Acessorio obter(Long id) {
		Acessorio acessorio = null;

		try {
			acessorio = acessorioDAO.obterPorId(id, getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}

		return acessorio;
	}

	@Override
	public List<Acessorio> listar() {
		List<Acessorio> acessorios = null;

		try {
			acessorios = acessorioDAO.listar(getEntityManager());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeEntityManager();
		}

		return acessorios;
	}
	
}
