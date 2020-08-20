package kr.co.yaga.service;

import java.util.List;

import kr.co.yaga.domain.BoardVO;
import kr.co.yaga.domain.Criteria;

public interface BoardService {
	
	public void register(BoardVO boardVO);		// 게시글 등록
	public BoardVO get(int bno);						// 게시글 상세조회
	public boolean modify(BoardVO boardVO);	// 게시글 수정
	public boolean remove(int bno);				// 게시글 삭제
//	public List<BoardVO> getList(); 	// 게시글 리스트 조회
	public List<BoardVO> getListWithPaging(Criteria criteria) throws Exception; 	// 게시글 리스트 조회(with 페이지네이션)
	public int getTotal(Criteria criteria);			// 전체 게시글 갯수 조회
	
	
}
