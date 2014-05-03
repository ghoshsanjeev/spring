package com.bt.nat.account;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class AccountRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Inject
	private PasswordEncoder passwordEncoder;

	public TEsitestWebGatekeeperUsers findByEin(Integer ein) {
		return entityManager
				.createNamedQuery(TEsitestWebGatekeeperUsers.FIND_BY_EIN,
						TEsitestWebGatekeeperUsers.class)
				.setParameter("ein", ein).getSingleResult();
	}

}
