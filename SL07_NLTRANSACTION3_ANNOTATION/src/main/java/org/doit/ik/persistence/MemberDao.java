package org.doit.ik.persistence;

import java.sql.SQLException;

import org.doit.ik.domain.MemberVO;

public interface MemberDao {
	MemberVO getMember(String id) throws ClassNotFoundException, SQLException;
	int insert(MemberVO member) throws ClassNotFoundException, SQLException;
}
