package org.doit.ik.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyPageDTO {
	private List<ReplyVO> list;
	private int replyCnt;
}
