package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;

public interface BoardMapper {
	List<BoardVO> getList();
	
	void insert(BoardVO boardVO);
	
	void insertSelectKey(BoardVO boardVO);
	
	// 글 보기
	BoardVO read(Long bno);
	
	int update(BoardVO boardVO);

	int remove(Long bno);
	
	List<BoardVO> getListWithPaging(Criteria criteria);
	int getTotalCount(Criteria criteria);
}
