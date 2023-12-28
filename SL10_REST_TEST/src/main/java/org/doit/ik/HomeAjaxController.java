package org.doit.ik;

import java.util.List;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.domain.EmpVO;
import org.doit.ik.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class HomeAjaxController {
	//@Autowired
	@Setter(onMethod=@__({@Autowired}))
	private MemberMapper memberMapper;
	
	/*
	@GetMapping("/idCheck")
	public int idCheck(String empno) {
		log.info("> /idcheck... GET - Ajax : " + empno);
		
		return this.memberMapper.idCheck(empno);
	}
	*/
	
	@GetMapping("/idCheck")
	public EmpVO idCheck(String empno) {
		log.info("> /idcheck... GET - Ajax : " + empno);
		
		int idCheckResult = this.memberMapper.idCheck(empno);
		
		// java Object
		return new EmpVO(empno, "홍길동", idCheckResult);
	}
	
	@PostMapping("/scott/dept/new")
	public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto) {
		log.info("> /scott/dept/new POST ..");
		int insertResult = this.memberMapper.insertDept(dto);
		// 응답결과물 + http 상태코드 : ResponseEntity
		return insertResult == 1 ? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// produces = {MediaType.TEXT_PLAIN_VALUE} ? 일반 문자열을 반환한다는 뜻
	@DeleteMapping(value = "/scott/dept/{deptno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	// public ResponseEntity<String> deleteDept(@RequestBody int deptno) {
	public ResponseEntity<String> deleteDept(@PathVariable int deptno) {
		log.info("> /scott/dept/remove DELETE ..");
		int deletetResult = this.memberMapper.deleteDept(deptno);
		// 응답결과물 + http 상태코드 : ResponseEntity
		return deletetResult == 1 ? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/scott/dept/select")
	public List<DeptDTO> selectDept() {
		log.info("> /scott/dept/select select ..");
		
		return this.memberMapper.selectDept();
	}
	
	
	@GetMapping("/scott/emp/select/{deptno}")
	public List<EmpDTO> selectEmp(@PathVariable int deptno) {
		log.info("> /scott/emp/select select ..");
		
		return this.memberMapper.selectEmp(deptno);
	}
	
}
