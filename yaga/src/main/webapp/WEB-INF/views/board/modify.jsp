<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- header -->	
<%@include file="../inc/header.jsp"%>
<!-------------->

<div class="row">
  <div class="col-lg-12">
    <h1 class="page-header" style="color: #000000;">Board Modify</h1>
  </div>
  <!-- /.col-lg-12 -->	
</div>
<!-- /.row -->

<div class="row">
  <div class="col-lg-12">
    <div class="panel panel-default">

      <div class="panel-heading">Board Modify</div>
      <!-- /.panel-heading -->
      <div class="panel-body">

      <form role="form" action="/board/modify" method="post">		
        <input type='hidden' name='page' value='<c:out value="${criteria.page}"/>'>
		<input type='hidden' name='perPageNum' value='<c:out value="${criteria.perPageNum}"/>'>
	    <input type='hidden' name='type' value='<c:out value="${criteria.type }"/>'>		
		<input type='hidden' name='keyword' value='<c:out value="${criteria.keyword }"/>'>
      
 	
<div class="form-group">
  <label>Bno</label> 
  <input class="form-control" name='bno' 
     value='<c:out value="${board.bno }"/>' readonly="readonly">
</div>	

<div class="form-group">
  <label>Title</label> 
  <input class="form-control" name='title' 
    value='<c:out value="${board.title }"/>' >
</div>

<div class="form-group">
  <label>Text area</label>
  <textarea class="form-control" rows="3" name='content' ><c:out value="${board.content}"/></textarea>
</div>

<div class="form-group">
  <label>Writer</label> 
  <input class="form-control" name='writer'
    value='<c:out value="${board.writer}"/>' readonly="readonly">            
</div>

<div class="form-group">
  <label>RegDate</label> 
  <input class="form-control" name='regDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regdate}" />'  readonly="readonly">            
</div>

<div class="form-group">
  <label>Update Date</label> 
  <input class="form-control" name='updateDate'
    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updatedate}" />'  readonly="readonly">            
</div>

          

  <button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
  <button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
  <button type="submit" data-oper='list' class="btn btn-info">List</button>
</form>


      </div>
      <!--  end panel-body -->

    </div>
    <!--  end panel-body -->
  </div>
  <!-- end panel -->
</div>
<!-- /.row -->




<script>
$(document).ready(function(e) {
	
	var formObj = $("form");
	console.log(formObj);
	
	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);		
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/board/remove");
	      	
	    }else if(operation === 'list'){
	      //move to list
	      formObj.attr("action", "/board/list").attr("method","get");
	      
	      var pageTag = $("input[name='page']").clone();
	      var perPageNumTag = $("input[name='perPageNum']").clone();
	      var keywordTag = $("input[name='keyword']").clone();
	      var typeTag = $("input[name='type']").clone();
	      
	      formObj.empty();	
	      
	      formObj.append(pageTag);
	      formObj.append(perPageNumTag);		
	      formObj.append(keywordTag);	
	      formObj.append(typeTag);	       
	    }
	    
	    console.log(perPageNumTag);
 	    formObj.submit();	
 	    
	  });
		
	
	
	
		
	
});


	


</script>




<!-- footer -------->
<%@include file="../inc/footer.jsp"%>
<!--- // footer----->