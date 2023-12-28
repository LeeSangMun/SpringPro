package org.doit.ik.di4;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component("record2") // 이름을 주지 않으면 클래스의 소문자 이름이 된다.
public class RecordImple4 implements Record4 {
	private int kor;
	private int eng;
	private int mat;
	
	@Override
	public int total() {
		return kor + eng + mat;
	}
	@Override
	public double avg() {
		return total() / 3.0;
	}
}
