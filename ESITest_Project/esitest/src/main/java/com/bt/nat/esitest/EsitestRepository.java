package com.bt.nat.esitest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class EsitestRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public TEsitestRecords update(TEsitestRecords item) {
		entityManager.merge(item);
		return item;
	}

	@Transactional
	public void delete(Long item) {
		entityManager.remove(findById(item));
	}

	@Transactional
	public TEsitestRecords save(TEsitestRecords item) {
		entityManager.persist(item);
		return item;
	}

	public List findByEinDue(Integer ein) {
		try {
			return entityManager
					.createNamedQuery(TEsitestRecords.FIND_BY_EIN_DUE)
					.setParameter("ein", ein).getResultList();
		} catch (Exception e) {
			System.out.println("Error in findByEin");
			e.printStackTrace();
			return null;
		}
	}

	public TEsitestRecords findById(Long id) {
		try {
			return entityManager.find(TEsitestRecords.class, id);
		} catch (Exception e) {
			System.out.println("Error in findById");
			e.printStackTrace();
			return null;
		}
	}
	
	public List findByEinOverDue(Integer ein) {
		try {
			
			return entityManager
					.createNamedQuery(TEsitestRecords.FIND_BY_EIN_OVERDUE)
					.setParameter("ein", ein).getResultList();

		} catch (Exception e) {
			System.out.println("Error in overdueEsiTests");
			e.printStackTrace();
			return null;
		}
	}

}
