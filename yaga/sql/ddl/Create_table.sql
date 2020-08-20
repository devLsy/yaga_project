-- 게시판 관련 테이블
CREATE TABLE `tbl_board` (
	`bno` INT(10) NOT NULL AUTO_INCREMENT COMMENT '게시글번호',
	`title` VARCHAR(200) NOT NULL COMMENT '제목',
	`content` VARCHAR(2000) NOT NULL COMMENT '내용',
	`writer` VARCHAR(50) NOT NULL COMMENT '작성자',
	`regdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '작성일',
	`updatedate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일',
	PRIMARY KEY (`bno`)
)
COMMENT='게시판 관련 테이블'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;

-- 댓글관련 테이블
CREATE TABLE `tbl_reply` (
	`rno` INT(10) NOT NULL AUTO_INCREMENT COMMENT '댓글번호',
	`bno` INT(10) NOT NULL COMMENT '게시글번호(fk))',
	`reply` VARCHAR(1000) NOT NULL COMMENT '댓글내용',
	`replyer` VARCHAR(50) NOT NULL COMMENT '댓글작성자',
	`replyDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '댓글작성일',
	`updateDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '댓글수정일',
	PRIMARY KEY (`rno`),
	INDEX `fk_reply_board` (`bno`),
	CONSTRAINT `fk_reply_board` FOREIGN KEY (`bno`) REFERENCES `tbl_board` (`bno`)
)
COMMENT='댓글관련 테이블'
COLLATE='utf8_general_ci'
ENGINE=InnoDB
;


