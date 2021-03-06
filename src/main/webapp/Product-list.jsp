<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Products 1</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
	<!-- bootstrap -->
	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
	<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
	<link href="themes/css/bootstrappage.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="themes/css/font-awesome.min.css">
	<!-- <link rel="stylesheet" type="text/css" href="themes/css/font-awesome.min2.css"> -->
	<link rel="stylesheet" type="text/css" href="themes/css/font-awesome.min3.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
	<!-- global styles -->
	<link href="themes/css/flexslider.css" rel="stylesheet"/>
	<link href="themes/css/main.css" rel="stylesheet"/>
	<link rel="stylesheet" type="text/css" href="themes/css/jquery-ui.min.css">
	<!-- scripts -->
	<script src="themes/js/jquery-1.7.2.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>				
	<script src="themes/js/superfish.js"></script>	
	<script src="themes/js/jquery.scrolltotop.js"></script>
	<script type="text/javascript" src="themes/js/jquery-ui.min.js"></script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>		
		<div id="top-bar" class="container">
			<div class="row">
				<div class="span4">
					<form class="search_form" action="displayproduct" method = "post">
						<div class="input-group">
							<input type="text" class="search-query form-control input-group" Placeholder="T??m s??ch theo t??n"
							name = "namesearch">
							<input type="hidden" name = "action" value = "searchname">
							<span class="input-group-btn">
								<button class="btn btn-primary rounded-circle btnpro" type="submit" id="btn-search">
									<span class="fa fa-search"></span>
								</button>
							</span>
						</div>
					</form>
				</div>
				<div class="span8">
					<div class="account pull-right">
						<ul class="user-menu">
						<c:if test="${User == null}">
							<li><a href="register.html">T??i kho???n</a></li>
						</c:if>
							<li><a href="cart.html">Gi??? h??ng</a></li>
							<li><a href="checkout.html">Thanh to??n</a></li>					
						<c:if test="${User == null}">		
							<li><a href="#">????ng nh???p</a></li>
						</c:if>
						<c:if test="${User != null}">		
							<li><a href="#">g???i h??m User.getName()</a></li>
						</c:if>		
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.html" class="logo pull-left"><h4 class="title">KBOOK </h4></a>
					<nav id="menu" class="pull-right">
						<ul>
							<!--														
							<li><a >Th??? lo???i s??ch</a>
								<ul>
								
								<c:forEach var="Category" items="${categorys}">			
									
								<li><a href="/PBL_Product/displayproduct" value="${Category.getCategory_name()}"
					name ="categorysearch" method="post">${Category.getCategory_name()}</a></li>
								</c:forEach>
								</ul>
							</li>			
							    <li><a href="./products.html">Man</a></li>						
								<li><a href="./products.html">Hangbag</a></li> -->
							</ul>
						</nav>
					</div>
				</section>
				<section  class="homepage-slider" id="home-slider">
					<div class="flexslider">
						<ul class="slides">
							<li>
								<img src="themes/images/carousel/slider_1.jpg" alt="anh bia 1" />
								<div class="intro">
							<!--<h1>Laptop mua online</h1>
							<p><span>Gi???m th??m ?????n 1.000.000??</span></p>
							<p><span>??p d???ng k??m theo khuy???n m??i tr??? th???ng kh??c</span></p> -->
						</div>
					</li>
					<li>
						<img src="themes/images/carousel/slider_4.png" alt="anh bia 2" />
						
					</li>
					<li>
						<img src="themes/images/carousel/slider_5.png" alt="anh bia 3" />
						
					</li>
					<li>
						<img src="themes/images/carousel/slider_6.png" alt="anh bia 4" />
						
					</li>
					<li>
						<img src="themes/images/carousel/slider_7.png" alt="anh bia 5" />
						
					</li>
				</ul>
			</div>			
		</section>
		<section class="header_text">
			Website ch??ng t??i chuy??n cung c???p c??c s???n ph???m ch???t l?????ng c?? uy t??n v?? m???i nh???t tr??n th??? tr?????ng hi???n nay
			<br/>H??y gh?? th??m trang web c???a ch??ng t??i v?? ?????ng b??? l??? c??c s???n ph???m m???i nh??!
		</section>
		<hr>
		<h4><span>M???t s??? s??ch ph??? bi???n:</span></h4>
	</section>
	<section class="main-content">
		
		<div class="row">						
			<div class="span9">								
				<ul class="thumbnails listing-products">
					
				<c:forEach var="ProductShow" items="${listProductShow}">
					<li class="span3">
						<div class="product-box">
							<span class="sale_tag"></span>												
							<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"> 
							<img alt="" src="themes/images/cloth/thebook ${ProductShow.getID_Product()}.jpg"></a><br/>
							<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">Ti??u ????? : ${ProductShow.getBook_title()}</a><br/>
							<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">Th??? lo???i : ${ProductShow.getCategory_name()}</a><br/>
							<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">T??c gi???: ${ProductShow.getAuthorname()}</a><br/>
							<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">??i???m ????nh gi?? : ${ProductShow.getAvarage_rating()}</a><br/>
							<p class="price" id="price" value = "${ProductShow.getPrice()}">Gi?? ti???n: ${ProductShow.getPrice()}</p>
						</div>
					</li>
					</c:forEach>
				</ul>								
				<hr>
	</div>
	<div class="span3 col">
		<div id="menu-filter">
			<h3>M???c Gi??</h3>
			<form name = "action" action="displayproduct" method="post">
			<div>
				<div class="checkbox checkbox-primary">
					<input id="checkbox1" type="checkbox" class="input-lg"
					name="pricesearch" value = "0">
					<label for="checkbox1">
						T???t c???
					</label>
				</div>
				<div class="checkbox checkbox-primary">
					<input id="checkbox2" type="checkbox" class="input-lg"
					name="pricesearch" value = "1">
					<label for="checkbox2">
						D?????i 100.000 VND
					</label>
				</div>
				<div class="checkbox checkbox-primary">
					<input id="checkbox3" type="checkbox" class="input-lg"
					name="pricesearch" value = "2">
					<label for="checkbox3">
						T??? 100.000 - 500.000 VND
					</label>
				</div>
				<div class="checkbox checkbox-primary">
					<input id="checkbox4" type="checkbox" class="input-lg"
					name="pricesearch" value = "3">
					<label for="checkbox4">
						T??? 500.000 - 1.000.000 VND
					</label>
				</div>
				<div class="checkbox checkbox-primary">
					<input id="checkbox6" type="checkbox" class="input-lg"
					name="pricesearch" value = "4">
					<label for="checkbox6">
						Tr??n 1.000.000 VND
					</label>
				</div>
				<input type = "hidden" name = "action" value = "searchprice"> 
				<div>
				<button type="submit" class="btn btn-success">L???c s??ch</button>
				</div>
			</div>
			</form>
			<h3>Th??? lo???i s??ch</h3>
			<form name = "action" action="displayproduct" method="post">
			<div>
				<div class="checkbox checkbox-primary">
					<input id="checkbox11" type="checkbox" class="input-lg" value = "All"
					name ="categorysearch">
					<label for="checkbox11">
						T???t c???
					</label>
				</div>
				
				<c:forEach var="Category" items="${categorys}">			
				<div class="checkbox checkbox-primary">
					<input id="checkbox11" type="checkbox" class="input-lg" value="${Category.getCategory_name()}"
					name ="categorysearch">
					<label for="checkbox11"> ${Category.getCategory_name()} </label>
				</div>
				</c:forEach>
					
				<input type = "hidden" name = "action" value = "searchbook"> 
				<div></div>
				<div>
				<button type="submit" class="btn btn-success">L???c s??ch</button>
				</div>
			</div>
			</form>
		</div>
		<div class="block">
			<h4 class="title">
				<span class="pull-left"><span class="text">Ng???u nhi??n</span></span>
				<span class="pull-right">
					<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
				</span>
			</h4>
			<div id="myCarousel" class="carousel slide">
				<div class="carousel-inner">
				
					<c:forEach var="ProductShow" items="${listProductShow}" begin = "0" end = "1">
					<div class="active item">
						<ul class="thumbnails listing-products">
							<li class="span3">
								<div class="product-box">
									<span class="sale_tag"></span>												
									<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/laptop2.jpg"></a><br/>
									<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
									<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
									<p class="price">${ProductShow.getPrice()}</p>
								</div>
							</li>
						</ul>
					</div>
					</c:forEach>
					<c:forEach var="ProductShow" items="${listProductShow}" begin = "1" >
					<div class="item">
						<ul class="thumbnails listing-products">
							<li class="span3">
								<div class="product-box">												
									<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/laptop4.png"></a><br/>
									<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
									<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
									<p class="price">${ProductShow.getPrice()}</p>
								</div>
							</li>
						</ul>
					</div>
					</c:forEach>
					
				</div>
			</div>
		</div>

	</div>
	
	<script type="text/javascript">
		$("#menu-filter").accordion();
	</script>

</section>
<section style="background-color: #857474;" id="footer-bar">
	<div class="row">
		<div class="span3">
			<h4>??i???u H?????ng</h4>
			<ul class="nav">
				<li><a href="./index.html">Trang ch???</a></li>  
				<li><a href="./about.html">Th??ng tin</a></li>
				<li><a href="./contact.html">Li??n h???</a></li>
				<li><a href="./cart.html">Gi??? h??ng</a></li>
				<li><a href="./register.html">????ng nh???p</a></li>							
			</ul>					
		</div>
		<div class="span4">
			<h4>My Account</h4>
			<ul class="nav">
				<li><a href="#">T??i kho???n c???a t??i</a></li>
				<li><a href="#">L???ch s??? ?????t h??ng</a></li>
				<li><a href="#">Danh s??ch y??u th??ch</a></li>
				<!-- <li><a href="#">L??m m???i</a></li> -->
			</ul>
		</div>
		<div class="span5">
			<p class="logo"><!-- <img src="themes/images/logo.png" class="site_logo" alt=""> --><h4>ILAPTOP</h4></p>
			<p style="color: white;">Website ch??ng t??i chuy??n cung c???p c??c s???n ph???m ch???t l?????ng c?? uy t??n v?? m???i nh???t tr??n th??? tr?????ng hi???n nay
				<br/>H??y gh?? th??m trang web c???a ch??ng t??i v?? ?????ng b??? l??? c??c s???n ph???m m???i nh??!</p>
				<div style="margin-left: 60px;">
					<a href="#" class="button">
						<i class="fab fa-facebook-f fa-lg"></i>
					</a>
					<a href="#" class="button">
						<i class="fab fa-twitter fa-lg"></i>
					</a>
					<a href="#" class="button">
						<i class="fab fa-instagram fa-lg"></i>
					</a>
				</div>
				
			</div>					
		</div>	
	</section>
	<section id="copyright">
		<span>Copyright 2013 bootstrappage template  All right reserved.</span>
	</section>
</div>
<script src="themes/js/common.js"></script>	
<script src="themes/js/jquery.flexslider-min.js"></script>
<script type="text/javascript">
	$(function() {
		$(document).ready(function() {
			$('.flexslider').flexslider({
				animation: "fade",
				slideshowSpeed: 4000,
				animationSpeed: 600,
				controlNav: false,
				directionNav: true,
						controlsContainer: ".flex-container" // the container that holds the flexslider
					});
		});
	});
</script>
</body>
</html>