package kr.co.yaga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.yaga.domain.Criteria;
import kr.co.yaga.domain.ReplyVO;
import kr.co.yaga.service.ReplyService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/replies/")
@Log4j
public class ReplyController {
	
	@Setter(onMethod_ = @Autowired)
	private ReplyService service;
	
	
	// 댓글 등록
	@PostMapping(value = "/new",
					consumes = "application/json",
					produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		
		log.info("ReplyVO: " + vo);
		
		int insertCnt = service.register(vo);
		
		log.info("Reply INSERT CNT: " + insertCnt);
		
		// insertCnt값이 1이면 성공, 아니면 서버 에러 return
		return insertCnt == 1 
				? new ResponseEntity<String>("insert success!!", HttpStatus.OK) 
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 특정 게시물의 댓글 목록 확인
	@GetMapping(value = "/pages/{bno}/{page}", 
					produces = { MediaType.APPLICATION_XML_VALUE, 
							           MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("page") int page, @PathVariable("bno") int bno) {
		log.info("get Reply List......");
		Criteria cri = new Criteria(page, 1005);
		
		log.info("cri: " + cri);
		return new ResponseEntity<>( service.getList(cri, bno), HttpStatus.OK);
	}
	
	// 댓글 조회
	@GetMapping(value = "/{rno}",
				produces = { MediaType.APPLICATION_ATOM_XML_VALUE,
								  MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno) {
		
		log.info("reply get.....");
		return new ResponseEntity<>(service.get(rno), HttpStatus.OK);
	}
	
	// 댓글 삭제
	@DeleteMapping(value = "/{rno}",
				produces = {  MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
		
		log.info("reply remove......");
		
		// 삭제 결과가 1이면 header에 성공 전달, 아니면 서버에러 전달	
		return service.remove(rno) == 1 
				? new ResponseEntity<>("delete success", HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글 수정
	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.PATCH },
			value = "/{rno}",
			consumes = "application/json",
			produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo,
														  @PathVariable("rno") int rno) {
		
		vo.setRno(rno);
		log.info("rno: " + rno);
		log.info("modify...: " + vo);
		
		// 수정 결과가 1이면 성공, 아니면 서버 에러 return
		return service.modify(vo) == 1 	
				    ? new ResponseEntity<>("update success", HttpStatus.OK)
				    : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
		
		
	
		
}
