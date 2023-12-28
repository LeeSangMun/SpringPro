package org.doit.ik.domain;

import java.util.Date;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticeVO {
	private String seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int hit;
	private String filesrc;		// 수정
	
	// 첨부된 파일이 많으면 배열로 잡으면 된다.
	private CommonsMultipartFile file;
	
}
