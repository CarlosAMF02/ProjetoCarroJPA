package br.com.checkpoint02.dao.impl;

import br.com.checkpoint02.dao.HibernateGenericDAO;
import br.com.checkpoint02.entity.Carro;

public class CarroDAOImpl extends HibernateGenericDAO<Carro, Long> {

	private static CarroDAOImpl instance = null;

	private CarroDAOImpl() {
		super(Carro.class);
	}

	public static CarroDAOImpl getInstance() {
		if (instance == null) {
			instance = new CarroDAOImpl();
		}
		return instance;
	}
}
