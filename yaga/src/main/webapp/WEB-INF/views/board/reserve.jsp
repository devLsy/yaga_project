<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!-- header -->
<%@include file="../inc/header.jsp"%>
<!-------------->

  <!-- <div class="col-lg-12">
    <h1 class="page-header">rental cottage Reservation</h1>
  </div> -->
  <!-- /.col-lg-12 -->
<style>
body{margin:0;padding:0;max-height:800px}	
	.wrap	{position:absolute;top:50%;left:50%;width:200px;height:100px;margin-top:-50px;margin-left:-100px;}
	
	table {width:100%;border-collapse:collapse; border:0; empty-cells:show; border-spacing:0; padding:0;}
	table th {height:24px; padding:4px 10px; border:1px solid #DDD; font-weight:bold; text-align:left; background:#ecf5fc;}
	table td {height:22px; padding:5px 10px; border:1px solid #DDD;}
	#btn_close{float:right}

	/*레이어 팝업 영역*/
	.Pstyle {
	 opacity: 0;
	 display: none;
	 position: relative;
	 width: auto;
	 border: 5px solid #fff;
	 padding: 20px;
	 background-color: #fff;
	 }
</style>
<div id="calendar"></div>	

<!-- <div class="wrap">
	<input type="button" id="btn_open" value="레이어 팝업 열기">
	</div> -->
	
	<!--팝업 영역 시작 -->	
	<!-- <div id="popup" class="Pstyle">		
			
		<table>
			<tr>
				<th>bPopup를 이용한 레이어 팝업입니다</th>
			</tr>				
			<tr>
				<td style="height:100px">jquery bPopup 팝업 플러그인은<br><br> https://plugins.jquery.com/bpopup/에서 버젼별로 다운로드 받으실 수 있습니다</td>
			</tr>						
		</table>	
		<br>
		<input type="button" id="btn_close" value="닫 기">
		
	</div> -->
	
	

<script>
	$(document).ready(function() {
		//console.log('read');
		
		$("#introBtn").on("click", function(e) {
			e.preventDefault()
				if(confirm("정말 메인으로 돌아가시겠습니까?ㅠㅠ")) {
					self.location = "/";
			} else {
				return false;
			}		
		});
		
		$("#btn_open").click(function(){ //레이어 팝업 열기 버튼 클릭 시
			$('#popup').bPopup(); //  
		});
		
		$("#btn_close").click(function(){ //닫기
			$('#popup').bPopup().close();  
		});	
		
		
			
			
			
			
		
		
		
	
			
	
			
			
					
			
		
			
			
			
		
			
	});
	// end $(document).ready
	
	/* function bpopup(element) {
		var $target = element;
		console.log($target);
		$target.bpopup();		
	} */	
</script>
	
<script>
// $(document).ready()와 같음
// fullcalendar 호출
document.addEventListener('DOMContentLoaded', function() {
	var calendarEl = document.getElementById('calendar');
	var calendar = new FullCalendar.Calendar(calendarEl, {
	  plugins: [ 'interaction', 'dayGrid', 'timeGrid' ],
	  defaultView: 'dayGridMonth', 
	  defaultDate: '2019-06-07',
	  header: {
	    left: 'prev,next today',	
	    center: 'title',
	    right: 'dayGridMonth,timeGridWeek,timeGridDay'
	  },
	  events: [
	    {	
	      title: 'All Day Event',
	      start: '2019-06-01'
	    },
	    {
	      title: 'Long Event',
	      start: '2019-06-07',
	      end: '2019-06-10'
	    },
	    {
	      groupId: '999',
	      title: 'Repeating Event',
	      start: '2019-06-09T16:00:00'
	    },
	    {
	      groupId: '999',
	      title: 'Repeating Event',
	      start: '2019-06-16T16:00:00'
	    },
	    {
	      title: 'Conference',
	      start: '2019-06-11',
	      end: '2019-06-13'	
	    },
	    {
	      title: 'Meeting',
	      start: '2019-06-12T10:30:00',
	      end: '2019-06-12T12:30:00'
	    },
	    {
	      title: 'Lunch',
	      start: '2019-06-12T12:00:00'	
	    },
	    {
	      title: 'Meeting',
	      start: '2019-06-12T14:30:00'
	    },
	    {
	      title: 'Birthday Party',
	      start: '2019-06-13T07:00:00'
	    },
	    {
	      title: 'Click for Google',
	      url: 'http://google.com/',
	      start: '2019-06-28'
	    }
	  ]
	});

	calendar.render();
	});		
	// end fullcalendar	
</script>







<!-- footer -------->
<%@include file="../inc/footer.jsp"%>
<!--- // footer----->
