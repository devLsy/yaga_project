package kr.co.yaga.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yaga.domain.BoardVO;
import kr.co.yaga.domain.Criteria;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Setter(onMethod_ = { @Autowired })
	private BoardService service;	
	
//	@Test			
//	public void testExist() {	
//		log.info("service: " + service);
//		assertNotNull(service);
//	}
	
//	@Test
//	public void testRegister() {
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 제목");
//		board.setContent("새로 작성하는 내용");
//		board.setWriter("devLsy");
//		
//		service.register(board);
//		
//		log.info("생성된 게시글 번호: " + board.getBno());	
//	
//	}
	
//	@Test
//	public void testGetList() {
//		
//		service.getList().forEach(bd -> log.info("board: " + bd));
//	}
	
//	@Test
//	public void get() {
//		log.info("get: " + service.get(1));
//	}
	
//	@Test
//	public void testDel() {
//		log.info("remove result: " + service.remove(7));
//	}
	
//	@Test
//	public void testUpdate() {
//		BoardVO board = service.get(6);
//		
//		if(board == null) {
//			return;
//		}
//			
//		board.setTitle("제목 수정~!");
//		log.info("modify result: " + service.modify(board));
//	}
	
	
	
	
		
}
	