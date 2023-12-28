package org.doit.ik.di3;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecordViewImple3 implements RecordView3 {
	// 생성자, 필드, setter
	// @Setter 자동 주입(lombok)
	// @Autowired(required = false)
	// @Resource(name = "record1") java 9 부터 X
	@Inject
	@Named(value = "record2")
	private RecordImple3 record = null;
	
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
