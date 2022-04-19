package br.com.checkpoint02.dao.impl;

import br.com.checkpoint02.dao.HibernateGenericDAO;
import br.com.checkpoint02.entity.Modelo;

public class ModeloDAOImpl extends HibernateGenericDAO<Modelo, Long>{
	
	private static ModeloDAOImpl instance = null;
	
	private ModeloDAOImpl() {
		super(Modelo.class);
	}
	
	public static ModeloDAOImpl getInstance() {
		if(instance == null) {
			instance = new ModeloDAOImpl();
		}
		return instance;
	}
}
