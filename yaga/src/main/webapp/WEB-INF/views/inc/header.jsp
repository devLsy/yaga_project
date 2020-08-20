<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>	
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="yaga_project">
    <meta name="author" content="devLsy">
    <title>Welcome to Yaga</title>
			
	<!-- core CSS -->	
    <link href="<c:url value='/resources/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/font-awesome.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/animate.min.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/prettyPhoto.css" rel="stylesheet' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/main.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/css/responsive.css' />" rel="stylesheet">
    
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="<c:url value='/resources/images/ico/favicon.ico' />">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/resources/images/ico/apple-touch-icon-144-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<c:url value='/resources/images/ico/apple-touch-icon-114-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<c:url value='/resources/images/ico/apple-touch-icon-72-precomposed.png' />">
    <link rel="apple-touch-icon-precomposed" href="<c:url value='/resources/images/ico/apple-touch-icon-57-precomposed.png' />">
    
    <!-- fullcalendar -->
    <link href="<c:url value='/resources/vendor/fullcalendar-4.2.0/packages/core/main.css' />" rel="stylesheet">
    <link href="<c:url value='/resources/vendor/fullcalendar-4.2.0/packages/daygrid/main.css' />" rel="stylesheet">
    
</head>	
<!--/head-->		
		
<body class="homepage" oncontextmenu='return false' onselectstart='return false' ondragstart='return false'>

<header id="header">
        <div class="top-bar">
            <div class="container">	
                <div class="row">
                    <div class="col-sm-6 col-xs-4">	
                        <div class="top-number"><p><i class="fa fa-anchor"></i></p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                       <div class="social">
                            <ul class="social-share">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li> 
                                <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                                <li><a href="#"><i class="fa fa-skype"></i></a></li>
                            </ul>
                            
                            <!-- <div class="search">	
                                <form role="form">
                                    <input type="text" class="search-form" autocomplete="off" placeholder="Search">
                                    <i class="fa fa-search"></i>
                                </form>
                           </div> -->
                       </div>
                    </div>
                </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.top-bar-->

        <nav class="navbar navbar-inverse" role="banner">	
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <%-- <a class="navbar-brand" href="index.html"><img src="<c:url value='/resources/img/.png' />" alt="logo"></a> --%>
                </div>
					
                <div class="collapse navbar-collapse navbar-right">
                    <ul class="nav navbar-nav">	
                        <li><a href="/">Home</a></li>
                        <li><a href="/board/introduction">Introduction to Yaga</a></li>
                        <li><a href="/board/reserve">rental cottage Reservation</a></li>
                        <li><a href="/board/list">Inquiry</a></li>
                        <li><button id='signUp' type="button" class="btn btn-info pull-left">sign Up</button></li>
                        <!-- <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pages <i class="fa fa-angle-down"></i></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Blog Single</a></li>
                                <li><a href="#">Pricing</a></li>
                                <li><a href="#">404</a></li>
                                <li><a href="#">Shortcodes</a></li>
                            </ul>
                        </li>	 -->
                        <!-- <li><a href="blog.html">Blog</a></li> 
                        <li><a href="contact-us.html">Contact</a></li> -->                        
                    </ul>
                </div>
            </div>
            <!--/.container-->
        </nav>
        <!--/nav-->	
		
    </header>
    <!--/header-->
	
	<!-- jquery  -->
	<script src="<c:url value='/resources/js/jquery.min.js' />"></script>

<script>
	$(document).ready(function(e) {
		
		// 우클릭 방지
		document.onmousedown = disableclick;
		status = "right click prevention";
		
		function disableclick(e) {
				if(e.button == 2) {
					alert(status);
					return false;		
				}
		}
		
		// 현재 페이지에 해당되는 gnv 영역 addClass('active')
		var loc = location.pathname;
			
		$(".nav li").each(function() {
			// addClass active, 현재 페이지의 li의 a태그의 값이 loc와 같은것만
			$(this).toggleClass("active", $(this).find("a").attr("href") == loc);
		});
		
		$("#signUp").on("click", function(e) {
			e.preventDefault();
			alert("In ready.");	
		});
		
		
			
			
		
		
		
				
		
	});	





</script>	
	