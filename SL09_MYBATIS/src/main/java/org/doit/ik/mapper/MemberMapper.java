package org.doit.ik.mapper;

import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;

public interface MemberMapper {
	MemberVO getMember(String id) throws ClassNotFoundException, SQLException;
	int insert(MemberVO member) throws ClassNotFoundException, SQLException;
}
