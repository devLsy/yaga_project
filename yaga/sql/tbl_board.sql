-- 게시글 관련 sql
SELECT 
				bno, 
				title, 
				content, 
				writer,		
				regdate,	
				updatedate
FROM 
 			tbl_board
WHERE bno > 0
ORDER BY bno DESC, regdate DESC;
-- LIMIT 0, 10;


-- DELETE FROM tbl_board;
-- ALTER TABLE tbl_board AUTO_INCREMENT=1;
-- COMMIT;

-- SELECT count(*) FROM tbl_board
-- 	WHERE bno > 0;