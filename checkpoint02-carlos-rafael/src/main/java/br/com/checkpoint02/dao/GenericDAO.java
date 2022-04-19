package br.com.checkpoint02.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericDAO <T extends Serializable, PK extends Serializable> {
	
	void salvar(T entity, EntityManager entityManager);
	void atualizar(T entity, EntityManager entityManager);
	void remover(PK id, EntityManager entityManager);
	T obterPorId(PK id, EntityManager entityManager);
	List<T> listar(EntityManager entityManager);
}
