package org.doit.ik.di;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordViewImple implements RecordView {
	private RecordImple record = null;
	// private RecordImple record = new RecordImple();

	@Override
	public void input() {
		try(Scanner scanner = new Scanner(System.in)) {
			System.out.print("> kor, eng, mat input ? ");
			int kor =scanner.nextInt();
			int eng =scanner.nextInt();
			int mat =scanner.nextInt();
			
			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void output() {
		System.out.printf("> kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n"
				, this.record.getKor()
				, this.record.getEng()
				, this.record.getMat()
				, this.record.total()
				, this.record.avg());
	}
	
}
