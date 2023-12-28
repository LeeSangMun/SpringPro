package org.doit.ik.di;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordImple implements Record {
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
