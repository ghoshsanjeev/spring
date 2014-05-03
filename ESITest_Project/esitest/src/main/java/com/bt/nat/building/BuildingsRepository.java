package com.bt.nat.building;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class BuildingsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<TEsitestBuildings> findAllBuildings() {
		try {
			return entityManager.createNamedQuery(TEsitestBuildings.FIND_ALL,
					TEsitestBuildings.class).getResultList();
		} catch (Exception e) {
			System.out.println("Error in findByEin");
			e.printStackTrace();
			return null;
		}
	}
}
