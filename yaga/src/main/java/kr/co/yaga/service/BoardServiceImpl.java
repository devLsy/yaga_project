package kr.co.yaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yaga.domain.BoardVO;
import kr.co.yaga.domain.Criteria;
import kr.co.yaga.mapper.BoardMapper;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
	
@Log4j	
@Service
@AllArgsConstructor
// BoardService 구현체
public class BoardServiceImpl implements BoardService {
	
	@Setter(onMethod_ = @Autowired)	
	private BoardMapper mapper;
	
	// 게시글 등록
	@Override
	public void register(BoardVO boardVO) {
		log.info("register: " + boardVO);
		mapper.insert(boardVO);
	}
	
	// 게시글 상세조회
	@Override
	public BoardVO get(int bno) {
		log.info("get..." + bno);
		return mapper.read(bno);
	}
	
	// 게시글 수정
	@Override
	public boolean modify(BoardVO boardVO) {
		log.info("modify~! " + boardVO);
		return mapper.update(boardVO) == 1;
	}
	
	// 게시글 삭제
	@Override
	public boolean remove(int bno) {
		log.info("remove~! " + bno);
		return mapper.delete(bno) == 1;
	}
	
	// 게시글 전체 조회(with 페이지네이션)
	@Override
	public List<BoardVO> getListWithPaging(Criteria criteria) {
		return mapper.getListWithPaging(criteria);
	}
	
	// 전체 게시글 갯수 조회 
	@Override
	public int getTotal(Criteria criteria) {
		return mapper.getTotalCount(criteria);
	}
	


	
}
