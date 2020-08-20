/**
 * 답변관련 js 공통 모듈
 */
console.log('Reply Module~!!!');

// 즉시실행 함수
var replyService = (function(){
	
	// ajax 방식 댓글 작성
	function add(reply, callback) {
		console.log("reply........");
		
		$.ajax({
			type : 'POST',
			url : '/replies/new',
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			// success
			success : function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			// error
			error : function(xhr, status, er) {
				if(error) {
					error(er);
				}
				
			}
		});
	}
	return {
			add:add
			};	



})();	