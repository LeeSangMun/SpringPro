package org.doit.ik;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

// Ajax 처리를 하는 컨트롤러
@RestController
@Log4j
@RequestMapping("/scott/dept/*")
public class ScottRestController {
	@Autowired
	private DeptMapper deptMapper;
	
	@PostMapping("new")
	public ResponseEntity<String>  insertDept(@RequestBody DeptDTO dto) {
		log.info("> scott/dept/now POST...");
		int insertResult = this.deptMapper.insertDept(dto);
		
		return insertResult==1 ?  
	            new ResponseEntity<>("SUCCESS", HttpStatus.OK) 
	            :   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 게시글 글 보기
	// board/10 + GET
	// board/10 + DELETE // 둘의 호출방법이 다름
	
	
	@DeleteMapping(value="{deptno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String>  deleteDept(@PathVariable("deptno") int deptno) {
		log.info("> scott/dept/" + "deptno" + "DELETE...");
		int deleteResult = this.deptMapper.deleteDept(deptno);
		
		return deleteResult==1 ?  
	            new ResponseEntity<>("SUCCESS", HttpStatus.OK) 
	            :   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
