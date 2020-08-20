package kr.co.yaga.domain;

import java.util.Date;

import lombok.Data;

//댓글관련 vo(table : tbl_board)
@Data
public class BoardVO {

	private int bno;				// 게시글 번호
	private String title;			// 제목
	private String content;		// 내용
	private String writer;		// 작성자
	private Date regdate;		// 작성날짜
	private Date updatedate;	// 수정날짜
}
