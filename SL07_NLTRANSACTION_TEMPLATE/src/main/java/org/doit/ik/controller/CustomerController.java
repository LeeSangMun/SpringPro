package org.doit.ik.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ik.domain.NoticeVO;
import org.doit.ik.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {
	@Autowired
	private NoticeDao noticeDao;
	
	// ?dir=customer/upload&file=${ notice.filesrc  }
	@RequestMapping( "/download.htm")
	public void download(
			@RequestParam("dir")   String d
			, @RequestParam("file") String fname
			, HttpServletResponse response
			, HttpServletRequest request
			) throws Exception{ 

		response.setHeader("Content-Disposition","attachment;filename="+ new String(fname.getBytes(), "ISO8859_1"));      

		String fullPath = request.getServletContext().getRealPath(   d + "/" + fname);

		FileInputStream fin = new FileInputStream(fullPath);
		ServletOutputStream sout = response.getOutputStream();  
		byte[] buf = new byte[1024];
		int size = 0;
		while((size = fin.read(buf, 0, 1024)) != -1) {
			sout.write(buf, 0, size); 
		}
		fin.close();
		sout.close();
	}
	
	@GetMapping("/noticeDel.htm")
	public String noticeDel(
			@RequestParam("seq") String seq
			, @RequestParam("filesrc") String delFilesrc
			, HttpServletRequest request
			) throws ClassNotFoundException, SQLException {
		
		// 1.
		String uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
		File delFile = new File(uploadRealPath, delFilesrc);
		if(delFile.exists()) delFile.delete();
		
		// 2. 
		
		int delCount = this.noticeDao.delete(seq);
		if(delCount == 1) {
			return "redirect:notice.htm";
		} else {	
			return "redirect:noticeDetail.htm?seq=" + seq + "&error";
		}
	}
	
	@PostMapping("/noticeEdit.htm")
	public String noticeEdit(
			NoticeVO notice // 새로 첨부된 파일이 있다면 커맨드 객체 저장.
			, @RequestParam("o_filesrc") String oFilesrc
			, HttpServletRequest request
			) throws ClassNotFoundException, SQLException, IllegalStateException, IOException {
		// 1. 첨부된 파일 유무 확인 후에 서버 파일 저장.
		CommonsMultipartFile multipartFile = notice.getFile();

		// 서버에 배포했을 경우의 실제 저장 경로
		String uploadRealPath = null;
		if(!multipartFile.isEmpty()) { // 첨부파일이 있다.
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");

			// File saveDir = new File(uploadRealPath);
			// if(!saveDir.exists()) saveDir.mkdirs();
			System.out.println("> uploadRealPath : " + uploadRealPath);
			
			File delFile = new File(uploadRealPath, oFilesrc);
			if(delFile.exists()) {
				delFile.delete();
			}

			String originalFilename = multipartFile.getOriginalFilename();
			String filesystemName = getFileNameCheck(uploadRealPath, originalFilename);

			File dest = new File(uploadRealPath, filesystemName);
			multipartFile.transferTo(dest);

			notice.setFilesrc(filesystemName);
		} else {
			notice.setFilesrc(oFilesrc);
		}
		

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
	
	// upload 폴더 안에 a.txt
	private String getFileNameCheck(String uploadRealPath, String originalFilename) {
		int index = 1;      
		while( true ) {         
			File f = new File(uploadRealPath, originalFilename);         
			if( !f.exists() ) return originalFilename;         
			// upload 폴더에 originalFilename 파일이 존재한다는 의미         a.txt (4자리)
			String fileName = originalFilename.substring(0, originalFilename.length() - 4 );  //   a
			String ext =  originalFilename.substring(originalFilename.length() - 4 );  // .txt
			// asdfasf-3.txt
			originalFilename = fileName+"-"+(index)+ext;

			index++;
		} // while 
	}
	
	@PostMapping("noticeReg.htm")
	public String noticeReg(
			NoticeVO notice
			, HttpServletRequest request
			) throws ClassNotFoundException, SQLException, IllegalStateException, IOException {
		// 1. 첨부된 파일 유무 확인 후에 서버 파일 저장.
		CommonsMultipartFile multipartFile = notice.getFile();
		
		// 서버에 배포했을 경우의 실제 저장 경로
		String uploadRealPath = null;
		if(!multipartFile.isEmpty()) { // 첨부파일이 있다.
			uploadRealPath = request.getServletContext().getRealPath("/customer/upload");
			
			// File saveDir = new File(uploadRealPath);
			// if(!saveDir.exists()) saveDir.mkdirs();
			System.out.println("> uploadRealPath : " + uploadRealPath);
			
			String originalFilename = multipartFile.getOriginalFilename();
			String filesystemName = getFileNameCheck(uploadRealPath, originalFilename);
			
			File dest = new File(uploadRealPath, filesystemName);
			multipartFile.transferTo(dest);
			
			notice.setFilesrc(filesystemName);
		} // if
		
		// 작성자 X 왜? 로그인을 해야지만 글작성을 할 수 있다.
		notice.setWriter("mun");
		
		// int insertCount = this.noticeDao.insert(notice);
		this.noticeDao.insertAndPointUpOfMember(notice, "mun");
		
		int insertCount = 1;
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
