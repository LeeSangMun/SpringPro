package org.doit.ik.persistence;

import java.sql.SQLException;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.springframework.transaction.annotation.Transactional;

// @Transactional
public interface NoticeDao {
	// 공지사항의 총 갯수를 반환
	int getCount(String field, String query) throws ClassNotFoundException, SQLException;

	List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;

	int delete(String seq) throws ClassNotFoundException, SQLException;

	int update(NoticeVO notice) throws ClassNotFoundException, SQLException;

	NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException;

	int insert(NoticeVO notice) throws ClassNotFoundException, SQLException;
	
	// 트랜잭션 처리 하기 위한 메서드 추가
	// @Transactional
	// void insertAndPointUpOfMember(NoticeVO notice, String id) throws ClassNotFoundException, SQLException;
}
