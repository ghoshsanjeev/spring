package com.bt.nat.engineer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class EngineerRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public TEsitestEngineerPostcode update(TEsitestEngineerPostcode item) {
		entityManager.merge(item);
		return item;
	}

	@Transactional
	public void delete(Long item) {
		entityManager.remove(findById(item));
	}

	@Transactional
	public TEsitestEngineerPostcode save(TEsitestEngineerPostcode item) {
		entityManager.persist(item);
		return item;
	}

	public TEsitestEngineerPostcode findByEin(Integer ein) {
		try {
			return entityManager
					.createNamedQuery(TEsitestEngineerPostcode.FIND_BY_EIN,
							TEsitestEngineerPostcode.class)
					.setParameter("ein", ein).getSingleResult();
		} catch (Exception e) {
			System.out.println("Error in findByEin");
			e.printStackTrace();
			return null;
		}
	}

	public TEsitestEngineerPostcode findById(Long id) {
		try {
			return entityManager.find(TEsitestEngineerPostcode.class, id);
		} catch (Exception e) {
			System.out.println("Error in findById");
			e.printStackTrace();
			return null;
		}
	}

	public TEsitestPostcodes findItemById(Integer id) {
		try {
			return entityManager.find(TEsitestPostcodes.class, id);
		} catch (Exception e) {
			System.out.println("Error in findById");
			e.printStackTrace();
			return null;
		}
	}

}
