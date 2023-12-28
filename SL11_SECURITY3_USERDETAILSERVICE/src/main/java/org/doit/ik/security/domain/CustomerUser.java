package org.doit.ik.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.doit.ik.domain.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomerUser extends User {
	private static final long serialVersionUID = -4277076556567297471L;
	
	private MemberVO member;

	public CustomerUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomerUser(MemberVO vo) {
		super(vo.getId()
				, vo.getPwd() 
				// List<AuthVO>  -> 
	            //   Collection<? extends GrantedAuthority> authorities
	            , vo.getAuthList().stream().map( auth->new SimpleGrantedAuthority( auth.getAuthority() ) ).collect( Collectors.toList() ));
		this.member = vo;
	}

}
