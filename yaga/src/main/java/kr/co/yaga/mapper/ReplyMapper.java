package kr.co.yaga.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.co.yaga.domain.Criteria;
import kr.co.yaga.domain.ReplyVO;

public interface ReplyMapper {

	public int insert(ReplyVO vo);									// 댓글 등록
	public ReplyVO read(int rno);									// 댓글 조회
	public int delete(int rno);											// 댓글 삭제
	public int update(ReplyVO vo);									// 댓글 수정
	
	public List<ReplyVO> getListWithPaging(					// 댓글 페이지네이션
								@Param("cri") Criteria cri, 
								@Param("bno") int bno);	 
	
	
	
}
