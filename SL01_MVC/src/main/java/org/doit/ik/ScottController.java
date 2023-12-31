package org.doit.ik;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.mapper.scott.DeptMapper;
import org.doit.ik.mapper.scott.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/scott/*")
public class ScottController {
	@Autowired
	@Setter(onMethod =@__({@Autowired}) )
	private DeptMapper deptMapper;
	
	@Autowired
	private EmpMapper empMapper;
	
	// localhost/scott/dept 요청 -> 컨트롤러메서드
	// @RequestMapping(value = "/scott/dept", method = RequestMethod.GET)
	// 리턴타입이 void일 때는 요청 url에 접미사와 접두사가 붙는다.
	@GetMapping("/dept")
	public void dept(Locale locale, Model model) {
		log.info("> /scott/dept get...");
		List<DeptDTO> list = this.deptMapper.selectDept();
		model.addAttribute("list", list);
	}
	
	@PostMapping("/dept")
	public void dept(Model model) {
		dept(null, model);
	}
	
	// ArrayList
	// int[]
	@PostMapping("/emp")
	public String emp(
			@RequestParam(value="deptno") ArrayList<Integer> deptnos
			, Model model) {
		log.info("> /scott/emp post...");
		
		List<EmpDTO> list = this.empMapper.selectEmp(deptnos);
		model.addAttribute("list", list);
		
		return "/scott/emp";
	}
}
