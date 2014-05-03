package com.bt.nat.home;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class HomeRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public List<TEsitestMainMenuButtons> findMainMenuButtonsByType(String type,
			List<String> userType) {
		try {
			return entityManager
					.createNamedQuery(TEsitestMainMenuButtons.FIND_BUTTONS,
							TEsitestMainMenuButtons.class)
					.setParameter("name", type).setParameter("type", userType)
					.getResultList();
		} catch (Exception e) {
			System.out.println("Error in findMainMenuButtonsByType");
			e.printStackTrace();
			return null;
		}
	}

	public List<TEsitestMainMenuButtons> findSubMenuButtonsByType(String type) {
		try {
			return entityManager
					.createNamedQuery(TEsitestMainMenuButtons.FIND_SUB_BUTTONS,
							TEsitestMainMenuButtons.class)
					.setParameter("name", type).getResultList();
		} catch (Exception e) {
			System.out.println("Error in findSubMenuButtonsByType");
			e.printStackTrace();
			return null;
		}
	}

}
