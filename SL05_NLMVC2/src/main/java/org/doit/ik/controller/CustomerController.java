package org.doit.ik.controller;

import java.sql.SQLException;
import java.util.List;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	@Autowired
	private NoticeDao noticeDao;
	
	@GetMapping("/noticeDel.htm")
	public String noticeDel(@RequestParam("seq") String seq) throws ClassNotFoundException, SQLException {
		int delCount = this.noticeDao.delete(seq);
		if(delCount == 1) {
			return "redirect:notice.htm";
		} else {	
			return "redirect:noticeDetail.htm?seq=" + seq + "&error";
		}
	}
	
	@PostMapping("/noticeEdit.htm")
	public String noticeEdit(NoticeVO notice) throws ClassNotFoundException, SQLException {
		int updateCount = this.noticeDao.update(notice);
		if(updateCount == 1) {
			return "redirect:noticeDetail.htm?seq=" + notice.getSeq();
		} else {	
			return "redirect:notice.htm";
		}
	}
	
	@GetMapping("/noticeEdit.htm")
	public String noticeEdit(
			@RequestParam("seq") String seq
			, Model model
			) throws ClassNotFoundException, SQLException {
		NoticeVO notice = this.noticeDao.getNotice(seq);
		model.addAttribute("notice", notice);
		
		return "noticeEdit.jsp";
	}
	
	@PostMapping("noticeReg.htm")
	public String noticeReg(
			NoticeVO notice
			) throws ClassNotFoundException, SQLException {
		// 작성자 X 왜? 로그인을 해야지만 글작성을 할 수 있다.
		notice.setWriter("kenik");
		
		int insertCount = this.noticeDao.insert(notice);
		if(insertCount == 1) {
			return "redirect:notice.htm";
		} else {
			return "noticeReg.jsp?error";
		}
	}
	
	@GetMapping("noticeReg.htm")
	public String noticeReg() throws ClassNotFoundException, SQLException {
		return "noticeReg.jsp";
	}
	
	@GetMapping("noticeDetail.htm")
	public String noticeDetail(
			@RequestParam("seq") String seq
			, Model model
			) throws ClassNotFoundException, SQLException {
		NoticeVO notice =  this.noticeDao.getNotice(seq);
		
		model.addAttribute("notice", notice);
		
		return "noticeDetail.jsp";
	}
	
	@GetMapping("notice.htm")
	public String notices(
			@RequestParam(value="page", defaultValue = "1") int page
			, @RequestParam(value="field", defaultValue = "title") String field
			, @RequestParam(value="query", defaultValue = "") String query
			, Model model
			) throws ClassNotFoundException, SQLException {
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		
		model.addAttribute("list", list);
		model.addAttribute("message", "Hello world");
		
		return "notice.jsp";
	}
	
	/*
	@GetMapping("notice.htm")
	public ModelAndView notices(Locale locale, Model model
			, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		ModelAndView mav = new ModelAndView();
		
		// ?page=2&field=title&query=홍길동
		String ppage = request.getParameter("page");
		String pfield = request.getParameter("field");
		String pquery = request.getParameter("query");
		
		int page = 1;	
		String field = "title";
		String query = "";
		
		if(ppage != null && !ppage.equals("")) { page = Integer.parseInt(ppage); }
		if(pfield != null && !pfield.equals("")) { field = pfield; }
		if(pquery != null && !pquery.equals("")) { query = pquery; }
		
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		
		mav.addObject("list", list);
		mav.addObject("message", "Hello world");
		mav.setViewName("notice.jsp");
		
		return mav;
	}
	*/
}
