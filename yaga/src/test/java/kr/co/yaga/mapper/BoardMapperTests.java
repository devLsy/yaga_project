package kr.co.yaga.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private DataSource ds;
		
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info("board: " + board));
//	}
	
	 //글 작성		
//	@Test
//	public void insertTests() {
//		
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("dev 테스트");	
//		boardVO.setContent("ㅌㅌ");
//		boardVO.setWriter("devLsy");
//		mapper.insert(boardVO);			
//				
//		log.info("board: " + boardVO);
//	}
//		
//	@Test
//	// 상세조회
//	public void testGetRead() {
//		mapper.read(1);
//	}
	
//	// 게시글 삭제 
//	@Test
//	public void deleteTests() {
//		log.info("delete count: " + mapper.delete(3));
//	}
	
//	@Test
//	public void updateTests() {
//		
//		BoardVO boardVO = new BoardVO();
//		boardVO.setBno(1);
//		boardVO.setTitle("천마대멸겁");
//		boardVO.setContent("천마신공");
//		boardVO.setWriter("devLsy");		
//		
//		int cnt = mapper.update(boardVO);	
//		
//		log.info("update cnt: " + cnt);
//	}	
		
//	@Test
//	public void testPaging() {
//		Criteria criteria = new Criteria();
//		
//		criteria.setPageNum(3);
//		criteria.setAmount(10);
//		
//		List<BoardVO> list = mapper.getListWithPagin(criteria);
//		list.forEach(board -> log.info("board: " + board));
//	}
	
//	@Test
//	public void testSearch() {
//		
//		Criteria cri = new Criteria();
//		cri.setKeyword("기사");
//		cri.setType("t");
//		
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//		list.forEach(board -> log.info(board));
//	}
		
	@Test
	public void testInsert() {
		
		String sql = "INSERT INTO tbl_board(title, content, writer) VALUES(?, ?, ?)";
		
		for(int i = 1; i < 1001; i++) {
			Connection conn = null;
			PreparedStatement pstsmt = null;
			
			try {	
					conn = ds.getConnection();		
					pstsmt = conn.prepareStatement(sql);
					
					pstsmt.setString(1, i + "번 째 제목입니다.");	
					pstsmt.setString(2, i + "번 째 내용입니다.");
					pstsmt.setString(3, i + "번 째 작성자");
					
					pstsmt.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			
			} finally {
				if(pstsmt != null) {
					try {
						pstsmt.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(conn != null) {
					try {
						conn.close();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
		
	}

	
	
	
	
}
