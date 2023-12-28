package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.BookDTO;

public interface BookMapper {
	// 모든 북 가져오는 메서드
	List<BookDTO> list();

	// 북 정보
	BookDTO get(String seq);

	// 북 추가
	void add(BookDTO dto);

}