package org.doit.ik.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.ReplyVO;

public interface ReplyMapper {
	int insert(ReplyVO vo);
	
	ReplyVO read(Long rno);
	
	int delete(Long rno);
	
	int update(ReplyVO reply);
	
	// 페이징 처리가 된 댓글 목록을 반환하는 메서드
	// @Param 어노테이션 의미 ?
	// Mybatis에 넘겨줄 파라미터가 2개 이상일 때는 ? 
	// 		1) Criteria + bno 새로운 클래스를 선언
	// 		2) Map 이용해서 파라미터
	//		3) @Param 어노테이션 사용
	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno") Long bno);
	
	int getCountByBno(Long bno);
}
