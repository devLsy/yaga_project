package kr.co.yaga.domain;

import java.util.Date;

import lombok.Data;

// 댓글관련 vo(table : tbl_reply)
@Data
public class ReplyVO {

	private int rno;							// 댓글번호
	private int bno;							// 게시글번호
	private String reply;						// 댓글 내용
	private String replyer;					// 댓글작성자
	private Date replyDate;				// 댓글 작성일
	private Date updateDate;				// 댓글 수정일
}
