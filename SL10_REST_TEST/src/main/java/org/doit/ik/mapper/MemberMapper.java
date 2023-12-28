package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;

public interface MemberMapper {
	int idCheck(String empno);
	
	int insertDept(DeptDTO dto);
	
	int deleteDept(int deptno);

	List<DeptDTO> selectDept();

	List<EmpDTO> selectEmp(int deptno);
}
