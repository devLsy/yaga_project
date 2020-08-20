package kr.co.yaga.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.co.yaga.domain.Criteria;
import kr.co.yaga.domain.ReplyVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyMapperTests {

	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
//	@Test
//	public void testCreate() {
//		
//		ReplyVO vo = new ReplyVO();
//			
//		for(int i = 970; i <= 1005; i++) {
//			vo.setBno(i);
//			vo.setReply(i + "번 째 테스트 댓글내용");
//			vo.setReplyer(i + "번 째 테스트 댓글작성자");
//			mapper.insert(vo);	
//		}
//	}
	
//	@Test
//	public void testRead() {
//		int rno = 1;
//		ReplyVO vo = mapper.read(rno);
//		log.info("vo : " + vo);
//	}
	
//	@Test
//	public void testDel() {
//		
//		for(int i = 1; i <= 1009; i++) {
//			mapper.delete(i);
//		}
//	}
	
//	@Test
//	public void testUpdate() {
//		int rno = 1064;
//		
//		ReplyVO vo = mapper.read(rno);
//		vo.setReply("수정했음");
//		
//		int cnt = mapper.update(vo);
//		log.info("update cnt: " + cnt);
//	}
	
	@Test
	public void testList() {
		
		Criteria cri = new Criteria();
		List<ReplyVO> replyList = mapper.getListWithPaging(cri, 1065);
		replyList.forEach(reply -> log.info("reply: " + reply));	
	}
	
		
	
	
	
}
