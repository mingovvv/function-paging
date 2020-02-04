package com.devyu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.devyu.domain.Board;

@Repository
public class BoardRepository {

	@PersistenceContext
	private EntityManager em;

	public int findAllCnt() {
		return ((Number) em.createQuery("select count(*) from Board")
					.getSingleResult()).intValue();
	}

	public List<Board> findAll() {
		return em.createQuery("select b from Board b", Board.class)
					.getResultList();
	}

	public List<Board> findListPaging(int startIndex, int pageSize) {
		return em.createQuery("select b from Board b", Board.class)
					.setFirstResult(startIndex)
					.setMaxResults(pageSize)
					.getResultList();
	}
}
