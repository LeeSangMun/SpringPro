package org.doit.ik.domain;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	private int mgr;
	
	private Date hiredate;
	private int sal;
	private int comm;
	private int deptno;
}
