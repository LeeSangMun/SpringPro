package org.doit.ik;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.doit.ik.domain.SampleVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	// 1. 단순 문자열 반환
	// 해당 메서드가 생산하는 MIME 타입 
	// produces = "text/plain; charset=UTF-8"
	@GetMapping(value = "/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		log.info("MIME TYPE : " + MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	// MediaType.APPLICATION_JSON_UTF8_VALUE
	// 스프링 5.2 부터 MediaType.APPLICATION_JSON_VALUE 변경
	@GetMapping(value = "/getSample"
			, produces = {
					MediaType.APPLICATION_JSON_UTF8_VALUE
					, MediaType.APPLICATION_XML_VALUE
			})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	@GetMapping(value = "/getSample2")
	public SampleVO getSample2() {
		return new SampleVO(113, "스타", "로드");
	}
	
	// 컬렉션 타입의 객체 반환
	@GetMapping(value = "/getList")
	public List<SampleVO> getList() {
		List<SampleVO> list = new ArrayList<>();
		list.add(new SampleVO(1, "FIRST1", "LAST1"));
		list.add(new SampleVO(2, "FIRST2", "LAST2"));
		list.add(new SampleVO(3, "FIRST3", "LAST3"));
		list.add(new SampleVO(4, "FIRST4", "LAST4"));
		
		return list;
	}
	
	@GetMapping(value = "/getList2")
	public List<SampleVO> getList2() {
		return IntStream
				.range(1, 10)
				.mapToObj(i->new SampleVO(i, "FIRST"+i, "LAST"+i))
				.collect(Collectors.toList());
	}
	
	// 맵 계열
	@GetMapping(value = "/getMap")
	public Map<String, SampleVO> getMap() {
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		
		map.put("first", new SampleVO(1, "FIRST1", "LAST1"));
		map.put("second", new SampleVO(2, "FIRST2", "LAST2"));
		
		return map;
	}
	
	// [ResponseEntity 타입을 응답]
	// REST 방식은 순수한 문자열, [JSON], XML 데이터 송, 수신
	// 정상적 데이터인지, 비정상 데이터인지 구분할 필요.
	// ResponseEntity 타입 = 응답 JSON 데이터 + HTTP의 상태코드 200
	// 예)
	//  height 파라미터값이 150 기준으로 미만일 때 502 상태코드 + 값 전달
	@GetMapping(value = "/check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check(Double height, Double weight) {
		ResponseEntity<SampleVO> result = null;
		
		SampleVO vo = new SampleVO(1, height+"", weight+"");
		
		if(height >= 150) {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}
		
		return result;
	}
	
	// @PathVariable
	// REST 방식 : URL 내에 최대한 많은 정보를 담으려고 합니다.
	// 			? 파라미터=값&...
	@GetMapping(value = "/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable String cat
			, @PathVariable String pid
			) {
		return new String[] {"category:"+cat, "productid:"+pid};
		
	}
	
	// {"mno":1, "firstName":"FN", "lastName":"LN"}
	@PostMapping("/samplevo")
	public SampleVO convert(@RequestBody SampleVO vo) {
		log.info("convert..." + vo);
		
		return vo;
	}
}

