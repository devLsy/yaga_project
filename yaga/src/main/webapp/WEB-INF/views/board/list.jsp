<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- header -->
<%@include file="../inc/header.jsp"%>
<!-------------->

<div class="center" style="margin-top: 40px;">
                <h2>List of enquiries</h2>
                <p class="lead">Please inquire.</p>
</div>

			
<div class="row">
	<div class="col-lg-12">
		<div class="panel-heading">
				
				<button id='regBtn' type="button" class="btn btn-xs pull-right">Register
					New Board</button>
				</div>
		<div class="panel panel-default">
				
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>

					<c:forEach items="${list}" var="board">
						<tr>
							<td><c:out value="${board.bno}" /></td>

							<td>	
								<a class="move" href='<c:out value="${board.bno}"/>'>
									<c:out value="${board.title}" />
								</a>	
							</td>

							<td><c:out value="${board.writer}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.regdate}" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${board.updatedate}" /></td>
						</tr>
					</c:forEach>
				</table>

				<div class='row'>
					<div class="col-lg-12">

						<form id='searchForm' action="/board/list" method='get'>
							<select name='type' id="type">
									<option value="" <c:out value="${pageMaker.criteria.type == null ? 'selected' : ''}" />>Please choose</option>
									<option value="T" <c:out value="${pageMaker.criteria.type eq 'T' ? 'selected' : ''}" />>title</option>
									<option value="C" <c:out value="${pageMaker.criteria.type eq 'C' ? 'selected' : ''}" />>content</option>
									<option value="W" <c:out value="${pageMaker.criteria.type eq 'W' ? 'selected' : ''}" />>writer</option>
									<option value="TC" <c:out value="${pageMaker.criteria.type eq 'TC' ? 'selected' : ''}" />>title or content</option>
									<option value="TW" <c:out value="${pageMaker.criteria.type eq 'TW' ? 'selected' : ''}" />>title or writer</option>
									<option value="TCW" <c:out value="${pageMaker.criteria.type eq 'TCW'?'selected':''}"/>>title or content or writer</option>
							</select> 	
							<input id="keyword" type='text' name='keyword' value='<c:out value='${pageMaker.criteria.keyword}' />'> 
							<input type='hidden' name='page' value='<c:out value="${pageMaker.criteria.page}"/>' /> 
							<input type='hidden' name='perPageNum' value='<c:out value="${pageMaker.criteria.perPageNum}"/>' />
							<button class='btn btn-default'>Search</button>
						</form>
					</div>	
				</div>

				<!-- 페이지네이션 영역 -->
				<div class='pull-right'>
					<ul class="pagination">	
						  <c:if test="${pageMaker.prev}">
			              		<li class="paginate_button previous">
			              			<a href="${pageMaker.startPage -1}">Previous</a>
			              		</li>
			              </c:if>
		
			             <c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			              		<li class="paginate_button  ${pageMaker.criteria.page == num ? "active" : ""} ">
									<a href="${num}">${num}</a>	
			             </c:forEach>
		
	            		<c:if test="${pageMaker.next}">
	              				<li class="paginate_button next">
	              					<a href="${pageMaker.endPage + 1}">Next</a>
	              				</li>
	            		</c:if>
					</ul>
				</div>		
				<!--  end Pagination -->		
			</div>

			<form id='actionForm' action="/board/list" method='get'>
				<input type='hidden' name='page' value='${pageMaker.criteria.page}'>	
				<input type='hidden' name='perPageNum' value='${pageMaker.criteria.perPageNum}'>
				<input type="hidden" name="type" value="<c:out value='${pageMaker.criteria.type}' />">
				<input type="hidden" name="keyword" value="<c:out value='${pageMaker.criteria.keyword}' />">
			</form>
				
	
			<!-- Modal  추가 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">	
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">Modal title</h4>
						</div>
						<div class="modal-body">처리가 완료되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>	
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->


		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
</div>
<!-- /.row -->	

<script>
$(document).ready(function() {
	
	var result = '<c:out value="${result}"/>';
	console.log("게시글 번호: " + result);
	
	// modal 창
	checkModal(result);

	history.replaceState({}, null, null);

	function checkModal(result) {
			
			if(result == "" || history.state) {
				return;
			}	

		if (parseInt(result) > 0) {
			$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
		}

		$("#myModal").modal("show");
	}	
	
	// 게시글 등록 버튼
	$("#regBtn").on("click", function(e) {
		e.preventDefault();
		self.location = "/board/register";
	});
	
	// 페이지네이션 영역 a태그 클릭 시 링크 처리
	var actionForm = $("#actionForm");		
	
	$(".paginate_button a").on("click", function(e) {	
		e.preventDefault();	
		actionForm.find("input[name='page']").val($(this).attr("href"));
		actionForm.submit();	
		
	});
	
	// 조회 시 기본 동작 멈추고 해당 제목 클릭 시 href에 hidden으로 bno 추가 후 submit
		$(".move").on("click", function(e) {
		
		e.preventDefault();	
		actionForm	
		.append("<input type='hidden' name='bno' value='"
				+ $(this).attr("href")+ "'>");
		actionForm.attr("action", "/board/get");
		actionForm.submit();
	}); 	
	
	// 검색 처리
	var searchForm = $("#searchForm");
			
		$("#searchForm button").on("click", function(e) {
			
			if( !searchForm.find("option:selected").val()) {	
				alert("Select a search type.");
				return false;
			}
			
			if( !searchForm.find("input[name='keyword']").val()) {
				alert("Please select a keyword.");
				$("#keyword").focus();	
				return false;	
			}	
			searchForm.find("input[name= 'page']").val("1");
			e.preventDefault();
			
			searchForm.submit();
		});
		
	
		










});
// end of $(document).ready
</script>





























<!-- footer -------->
<%@include file="../inc/footer.jsp"%>
<!--- // footer----->

