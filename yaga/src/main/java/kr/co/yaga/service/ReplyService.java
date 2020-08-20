package kr.co.yaga.service;

import java.util.List;

import kr.co.yaga.domain.Criteria;
import kr.co.yaga.domain.ReplyVO;

// 댓글관련 비지니스 로직
public interface ReplyService {
	
	public int register(ReplyVO vo);		// 댓글 등록
	public ReplyVO get(int rno);						// 댓글 조회
	public int modify(ReplyVO vo);	// 댓글 수정
	public int remove(int rno);				// 댓글  삭제
	public List<ReplyVO> getList(Criteria cri, int bno); 				// 댓글 리스트 조회
//	public List<ReplyVO> getListWithPaging(Criteria criteria, int bno) throws Exception; 	// 댓글 리스트 조회(with 페이지네이션)
	
	
	
}
