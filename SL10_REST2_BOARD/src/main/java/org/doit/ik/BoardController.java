package org.doit.ik;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.PageDTO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@Log4j
@AllArgsConstructor
public class BoardController {
	// 페이징 처리가 안된 컨트롤러 메서드
	private BoardService boardService;
	
	/*
	@GetMapping("/list")
	public void list(Model model) {
		log.info("> /board/list get...");
		model.addAttribute("list", this.boardService.getList());
	}
	*/
	
	// 페이징 처리가 안된 컨트롤러 메서드
	@GetMapping("/list")
	public void list(Criteria criteria, Model model) {
		log.info("> /board/list get...");
		model.addAttribute("list", this.boardService.getListWithPaging(criteria));
		int total = this.boardService.getTotal(criteria);
		
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
	}
	
	
	
	@GetMapping("/register")
	public void register() {
		log.info("> /board/register get...");
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("> /board/register post...");
		this.boardService.register(board);
		
		// 스프링 리다이렉트 방법
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})
	public void get(@RequestParam("bno") Long bno
			, Model model
			, @ModelAttribute("criteria") Criteria criteria) {
		log.info("> /board/register get or modify...");
		model.addAttribute("board", this.boardService.get(bno));
	}
	
	@PostMapping({"/modify"})
	public String modify(BoardVO board
			, RedirectAttributes rttr
			, @ModelAttribute("criteria") Criteria criteria) {
		log.info("> /board/modify post...");
		if(this.boardService.modify(board)) {
			rttr.addFlashAttribute("reuslt", "success");
		}
		
		rttr.addFlashAttribute("pageNum", criteria.getPageNum());
		rttr.addFlashAttribute("amount", criteria.getAmount());
		
		return "redirect:/board/list" + criteria.getListLink();
	}

	@GetMapping("/remove")
	public String remove(Long bno
			, RedirectAttributes rttr
			, @ModelAttribute("criteria") Criteria criteria) {
		log.info("> /board/remove...");
		if(this.boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
		rttr.addFlashAttribute("pageNum", criteria.getPageNum());
		rttr.addFlashAttribute("amount", criteria.getAmount());
		
		return "redirect:/board/list" + criteria.getListLink();
	}
}
