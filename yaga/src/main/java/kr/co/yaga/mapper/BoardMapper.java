package kr.co.yaga.mapper;

import java.util.List;

import kr.co.yaga.domain.BoardVO;
import kr.co.yaga.domain.Criteria;

public interface BoardMapper {
	
	public List<BoardVO> getList();										// 게시글 전체 조회
	public List<BoardVO> getListWithPaging(Criteria criteria);		// 게시글 전체 조회(with 페이지네이션)
	public void insert(BoardVO boardVO);									// 게시글 등록
	//public void insertSelectKey(BoardVO boardVO);					// 게시글 등록 시 게시글 번호 조회
	
	public BoardVO read(int bno);											// 게시글 상세조회
	public int delete(int bno);													// 게시글 삭제
	public int update(BoardVO boardVO);									// 게시글 수정
	public int getTotalCount(Criteria criteria);							// 전체 게시글 갯수 조회
	
}		
		