package org.doit.ik.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// notice.htm 요청 -> 호출되는 컨트롤러
//						현재페이지  검색조건    검색어
// /customer/noticeDetail.htm?seq=${dto.seq}
public class NoticeDetailController implements Controller {
	//@Autowired
	private NoticeDao noticeDao;
	
	public NoticeDetailController() {}
	
	// 생성자 DI
	public NoticeDetailController(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("noticeDetail.jsp");
		
		String seq = request.getParameter("seq");
		NoticeVO notice =  this.noticeDao.getNotice(seq);
		
		mav.addObject("notice", notice);
		
		return mav;
	}
	
}
