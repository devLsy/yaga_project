<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- header -->
<%@include file="../inc/header.jsp"%>
<!-------------->

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header" style="color: #000000;">Board Read Page</h1>
  </div>
  <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Register</div>
      <!-- /.panel-heading -->
      <div class="panel-body">
		
		<div class="form-group">
			<label>Bno</label><input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
		</div>
		
          <div class="form-group">
            <label>Title</label> <input class="form-control" name='title' value='<c:out value="${board.title}"/>' readonly="readonly">
          </div>

          <div class="form-group">
            <label>Text area</label>
				<textarea class="form-control" rows="3" name="content" readonly="readonly">
					<c:out value="${board.content}" />
				</textarea>
          </div>	

          <div class="form-group">	
            <label>Writer</label> <input class="form-control" name='writer' value='<c:out value="${board.writer}"/>' readonly="readonly">
          </div>
          
          <button data-oper='modify' class="btn btn-default">Modify</button>
		  <button data-oper='list' class="btn btn-info">List</button>
		  
		  <form id='operForm' action="/boad/modify" method="get">
		    <input type='hidden' id='bno' name='bno' value='<c:out value="${board.bno}"/>'>
			<input type='hidden' name='page' value='<c:out value="${criteria.page}"/>'>
			<input type='hidden' name='perPageNum' value='<c:out value="${criteria.perPageNum}"/>'>
			<input type='hidden' name='keyword' value='<c:out value="${criteria.keyword}"/>'>	
			<input type='hidden' name='type' value='<c:out value="${criteria.type}"/>'>  
		</form>	
		  			
      </div>	
      <!--  end panel-body -->	
	
    </div>	
    <!--  end panel-body -->	
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->

<!-- footer -------->
<%@include file="../inc/footer.jsp"%>
<!--- // footer----->

<!-- 댓글처리하기 위한 공통모듈-->
<script src="/resources/js/reply.js"></script>
<script>	
$(document).ready(function(e) {
	
	var operForm = $("#operForm"); 
		
	// 수정 페이지로 이동
	$("button[data-oper='modify']").on("click", function(e){
		
	    operForm.attr("action","/board/modify").submit();
	 
	});
	
	// 리스트 페이지로 이동
	$("button[data-oper='list']").on("click", function(e){
	    
	    operForm.find("#bno").remove();	
	    operForm.attr("action","/board/list")	
	    operForm.submit();
	    
	  });
	
	
	
	
		
	
});





</script>

<script>
/* 댓글 관련 */
$(document).ready(function() {

	//console.log('========================');
	//console.log("JS TEST~!!!!!!!!");

	var bnoValue = '<c:out value="${board.bno}" />';
	// 댓글 등록 테스트
	/* replyService.add(
			{reply: "JS TEST", replyer: "TESTER", bno: bnoValue},
				function(result) {
					alert("RESULT: " + result);
				}
			); */
	
});
</script>