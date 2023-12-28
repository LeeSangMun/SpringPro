package org.doit.ik.security;

import org.doit.ik.domain.MemberVO;
import org.doit.ik.mapper.MemberMapper;
import org.doit.ik.security.domain.CustomerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("> Load User By UserName : " + username);
		MemberVO vo = this.memberMapper.read(username);
		log.warn("> Queried by Member mapper : " + vo);
		
		// MemberVO vo => UserDetails 타입 형 변환
		// CustomerUser extends User implements UserDetails
		
		return vo == null ? null : new CustomerUser(vo);
	}
	
}
