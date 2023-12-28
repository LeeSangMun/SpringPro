package org.doit.ik.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.doit.ik.domain.MemberVO;

public interface MemberMapper {
	// 회원정보 반환
	MemberVO getMember(String id) throws ClassNotFoundException, SQLException;
	
	// 회원가입
	int insert(MemberVO member) throws ClassNotFoundException, SQLException;
	
	// 회원 정보 + 권한 정보를 얻어오는 메서드
	MemberVO read(@Param("userid") String userid);
}
