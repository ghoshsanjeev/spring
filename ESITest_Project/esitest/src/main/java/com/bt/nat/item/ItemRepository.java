package com.bt.nat.item;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ItemRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public TEsitestItems update(TEsitestItems item) {
		entityManager.merge(item);
		return item;
	}

	@Transactional
	public void delete(Long item) {
		entityManager.remove(findById(item));
	}

	@Transactional
	public TEsitestItems save(TEsitestItems item) {
		entityManager.persist(item);
		return item;
	}

	public List<TEsitestItems> findByEin(Integer ein) {
		try {
			return entityManager
					.createNamedQuery(TEsitestItems.FIND_BY_EIN,
							TEsitestItems.class).setParameter("ein", ein)
					.getResultList();
		} catch (Exception e) {
			System.out.println("Error in findByEin");
			e.printStackTrace();
			return null;
		}
	}

	public TEsitestItems findById(Long id) {
		try {
			return entityManager.find(TEsitestItems.class, id);
		} catch (Exception e) {
			System.out.println("Error in findById");
			e.printStackTrace();
			return null;
		}
	}

	public TEsitestItemMaster findItemById(Integer id) {
		try {
			return entityManager.find(TEsitestItemMaster.class, id);
		} catch (Exception e) {
			System.out.println("Error in findById");
			e.printStackTrace();
			return null;
		}
	}

	public List<TEsitestItemMaster> findAllItems() {
		try {
			return entityManager.createNamedQuery(TEsitestItemMaster.FIND_ALL,
					TEsitestItemMaster.class).getResultList();
		} catch (Exception e) {
			System.out.println("Error in findAllItems");
			e.printStackTrace();
			return null;
		}
	}
}
