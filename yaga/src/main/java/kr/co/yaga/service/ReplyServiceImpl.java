package kr.co.yaga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.yaga.domain.Criteria;
import kr.co.yaga.domain.ReplyVO;
import kr.co.yaga.mapper.ReplyMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService{
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper mapper;
	
	// 댓글 등록
	@Override
	public int register(ReplyVO vo) {
		log.info("register~!!: " + vo);
		return mapper.insert(vo);
	}
	
	// 댓글 조회
	@Override
	public ReplyVO get(int rno) {
		log.info("get... : " + rno);
		return mapper.read(rno);
	}
	
	// 댓글 수정
	@Override
	public int modify(ReplyVO vo) {
		log.info("modify.... : " + vo);
		return mapper.update(vo);
	}
	
	// 댓글 삭제
	@Override
	public int remove(int rno) {
		log.info("remove.... : " + rno);
		return mapper.delete(rno);
	}

	// 댓글 리스트 조회
	@Override
	public List<ReplyVO> getList(Criteria cri, int bno) {
		log.info("get reply List: " + bno);
		return mapper.getListWithPaging(cri, bno);
	}
	

}
