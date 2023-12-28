package org.doit.ik;

import org.doit.ik.domain.Criteria;
import org.doit.ik.domain.ReplyPageDTO;
import org.doit.ik.domain.ReplyVO;
import org.doit.ik.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies/*")
@AllArgsConstructor
@Log4j
public class ReplyController {
	private ReplyService replyService;
	
	@PostMapping(value = "/new"
			, consumes = "application/json"
			, produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("ReplyVO:" + vo);
		int insertCount  = this.replyService.register(vo);
		log.info("Reply INSERT COUNT:" + insertCount);
		
		return insertCount == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
	}
	
	@GetMapping(value = "/pages/{bno}/{page}"
			, produces = {
					MediaType.APPLICATION_XML_VALUE
					, MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public ResponseEntity<ReplyPageDTO> getList(
			@PathVariable int page
			, @PathVariable Long bno) {
		Criteria cri = new Criteria(page, 5);
		
		log.info("get Reply List bno:" + bno);
		log.info("cri:" + cri);
		
		return new ResponseEntity<>(this.replyService.getListPage(cri, bno), HttpStatus.OK);
						
	}
	
	@GetMapping(value = "/{rno}"
			, produces = {
					MediaType.APPLICATION_XML_VALUE
					, MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public ResponseEntity<ReplyVO> get(
			@PathVariable Long rno) {
		log.info("get :" + rno);
		
		return new ResponseEntity<>(this.replyService.get(rno), HttpStatus.OK);
						
	}
	
	@DeleteMapping(value = "/{rno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> remove(
			@PathVariable Long rno) {
		log.info("remove : " + rno);
		
		return this.replyService.remove(rno) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping(value = "/{rno}")
	public ResponseEntity<String> update(
			@RequestBody ReplyVO vo
			, @PathVariable Long rno
			) {
		// vo.setRno(rno);
		
		log.info("rno:" + rno);
		log.info("ReplyVO:" + vo);
		
		return this.replyService.modify(vo) == 1
				? new ResponseEntity<>("success", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
