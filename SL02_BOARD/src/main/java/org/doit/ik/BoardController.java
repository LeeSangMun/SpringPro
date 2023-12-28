package org.doit.ik;

import javax.servlet.http.HttpServletRequest;

import org.doit.ik.domain.BoardVO;
import org.doit.ik.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private BoardService boardService;
	
	@GetMapping("/list")
	public void list(Model model, HttpServletRequest request) {
		log.info("> /board/list get...");
		model.addAttribute("list", this.boardService.getList());
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
	public void get(@RequestParam("bno") Long bno, Model model) {
		log.info("> /board/register get or modify...");
		model.addAttribute("board", this.boardService.get(bno));
	}
	
	@PostMapping({"/modify"})
	public String modify(BoardVO board, RedirectAttributes rttr) {
		log.info("> /board/modify post...");
		if(this.boardService.modify(board)) {
			rttr.addFlashAttribute("reuslt", "success");
		}
		return "redirect:/board/list";
	}

	@GetMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		log.info("> /board/remove...");
		if(this.boardService.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
}
