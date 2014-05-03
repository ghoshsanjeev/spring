package com.bt.nat.account;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserService implements UserDetailsService {

	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("in loadUserByUsername");
		TEsitestWebGatekeeperUsers account = accountRepository.findByEin(new Integer(username));

		if (account == null) {
			System.out.println("account not found ");
			throw new UsernameNotFoundException("user not found");
		}
		System.out.println("account found "+account.getWguEin());

		return createUser(account);
	}

	public void signin(TEsitestWebGatekeeperUsers account) {
		System.out.println("in signin");
		SecurityContextHolder.getContext().setAuthentication(
				authenticate(account));
	}

	private Authentication authenticate(TEsitestWebGatekeeperUsers account) {
		System.out.println("in Authenticate");
		return new UsernamePasswordAuthenticationToken(createUser(account),
				null, Collections.singleton(createAuthority(account)));
	}

	private User createUser(TEsitestWebGatekeeperUsers account) {
		System.out.println("in create User for role-- >" + account.getWguProfileName());
		User user = null;
		try {
			user = new User(account.getWguEin().toString(), "test",
					Collections.singleton(createAuthority(account)));
		} catch (Exception e) {
			System.out.println("Error in createUser");
			e.printStackTrace();
			return null;
		}
		return user;
	}

	private GrantedAuthority createAuthority(TEsitestWebGatekeeperUsers account) {
		return new SimpleGrantedAuthority(account.getWguProfileName());
	}

}
