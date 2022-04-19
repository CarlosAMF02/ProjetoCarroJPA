package br.com.checkpoint02.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class HibernateGenericDAO<T extends Serializable, PK extends Serializable> implements GenericDAO<T, PK> {

	private Class<T> type;

	public HibernateGenericDAO(Class<T> type) {
		this.type = type;
	}

	@Override
	public void salvar(T entity, EntityManager entityManager) {
		entityManager.persist(entity);
	}

	@Override
	public void atualizar(T entity, EntityManager entityManager) {
		entityManager.merge(entity);
	}

	@Override
	public void remover(PK id, EntityManager entityManager) {
		T entity = obterPorId(id, entityManager);
		entityManager.remove(entity);
	}

	@Override
	public T obterPorId(PK id, EntityManager entityManager) {
		return entityManager.find(type, id);
	}

	@Override
	public List<T> listar(EntityManager entityManager) {
		Query consult = entityManager.createQuery("SELECT o FROM " + type.getName() + " o");
		return consult.getResultList();
	}
}
