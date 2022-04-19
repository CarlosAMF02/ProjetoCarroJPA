package br.com.checkpoint02.dao.impl;

import br.com.checkpoint02.dao.HibernateGenericDAO;
import br.com.checkpoint02.entity.Acessorio;

public class AcessorioDAOImpl extends HibernateGenericDAO<Acessorio, Long> {
	
	private static AcessorioDAOImpl instance = null;

	private AcessorioDAOImpl() {
		super(Acessorio.class);
	}

	public static AcessorioDAOImpl getInstance() {
		if (instance == null) {
			instance = new AcessorioDAOImpl();
		}
		return instance;
	}
}
