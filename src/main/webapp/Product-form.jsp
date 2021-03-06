<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap E-commerce Templates</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		
		<!-- bootstrap -->
		<link rel="stylesheet" href="bootstrap/css/font-awesome.min.css">
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		
		<link href="themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link rel="stylesheet" type="text/css" href="themes/css/font-awesome.min.css">
		<link href="themes/css/main.css" rel="stylesheet"/>
		<link href="themes/css/jquery.fancybox.css" rel="stylesheet"/>
		<link rel="stylesheet" type="text/css" href="themes/css/font-awesome.min.css">
	<!-- <link rel="stylesheet" type="text/css" href="themes/css/font-awesome.min2.css"> -->
	<link rel="stylesheet" type="text/css" href="themes/css/font-awesome.min3.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.10/css/all.css" integrity="sha384-+d0P83n9kaQMCwj8F4RJB66tzIwOKmrdb46+porD/OvrJ+37WqIM7UoBtwHO6Nlg" crossorigin="anonymous">
		<!-- scripts -->
		<script src="themes/js/jquery-1.7.2.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>				
		<script src="themes/js/superfish.js"></script>	
		<script src="themes/js/jquery.scrolltotop.js"></script>
		<script src="themes/js/jquery.fancybox.js"></script>
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
						<li><a href="./displayproduct">Quay v??? c???a h??ng</a>		
						</ul>
						</nav>
					</div>
			</section>				
			<section class="header_text sub">
			<img class="pageBanner" src="themes/images/carousel/slider_2.jpg" alt="New products" >
				<h4><span>Chi ti???t s???n ph???m</span></h4>
			</section>	
			<section class="main-content">				
				<div class="row">						
					<div class="span9">
						<div class="row">
							<div class="span4">
								<a href="themes/images/cloth/thebook ${ProductShow.getID_Product()}.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 1"><img alt="" src="themes/images/cloth/thebook ${ProductShowdetail.getID_Product()}.jpg"></a>												
								
							</div>
							<div class="span5">
								<address>
									<strong>T??n s??ch:</strong> <span>${ProductShowdetail.getBook_title()}</span><br>
									<strong>??i???m ????nh gi??:</strong> <span>${ProductShowdetail.getAvarage_rating()}</span><br>
									<strong>S??? l?????ng h??ng c??n l???i:</strong> <span>${ProductShowdetail.getQuantity()}</span><br>
									<strong>Th??? Lo???i:</strong> <span>${ProductShowdetail.getCategory_name()}</span><br>	
									<strong>L?????t xem:</strong> <span>21932</span><br>						
								</address>									
								<h4><strong>Gi??: ${ProductShowdetail.getPrice()}</strong></h4>
							</div>
							<div class="span5">
								<form class="form-inline">
									<p>&nbsp;</p>
									<label>SL:</label>
									<input type="text" class="span1" placeholder="1"> 
									<div>
									<button class="btn btn-inverse" type="submit">Th??m v??o gi???</button>
									</div>
									
								</form>
									<div>
									<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal"> Vi???t ????nh gi?? </button>
									</div>
							</div>							
						</div>
						<div class="row">
							<div class="span9">
								<ul class="nav nav-tabs" id="myTab">
									<li class="active"><a href="#home">Mi??u t???</a></li>
									<li class=""><a href="#profile">Th??ng tin s???n ph???m</a></li>
								</ul>							 
								<div class="tab-content">
									<div class="tab-pane active" id="home">${ProductShowdetail.getProduct_description()}</div>
									<div class="tab-pane" id="profile">
										<table class="table table-striped shop_attributes">	
											<tbody>
												<tr class="">
													<th>Nh?? xu???t b???n</th>
													<td>${ProductShowdetail.getPublisher()}</td>
												</tr>		
												<tr class="alt">
													<th>T??n t??c gi???</th>
													<td>${ProductShowdetail.getAuthorname()}</td>
												</tr>
												<tr class="">
													<th>Ng??y xu???t b???n</th>
													<td>${ProductShowdetail.getPublish_date()}</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>							
							</div>		

							<div class="span9">	
								<br>
								<h4 class="title">
									<span class="pull-left"><span class="text"><strong>S??ch</strong> c??ng th??? lo???i</span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-1" data-slide="prev"></a><a class="right button" href="#myCarousel-1" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-1" class="carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails listing-products">
											<c:forEach var="ProductShow" items="${listPSsameCategory}" begin = "0" end = "2">
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>												
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/thebook ${ProductShowdetail.getID_Product()}.jpg"></a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
														<p class="price">${ProductShow.getPrice()}</p>
													</div>
												</li>
												</c:forEach>											
											</ul>
										</div>
										<div class="item">
											<ul class="thumbnails listing-products">	
											<c:forEach var="ProductShow" items="${listPSsameCategory}" begin = "3" >
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>												
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/thebook ${ProductShowdetail.getID_Product()}.jpg"></a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
														<p class="price">${ProductShow.getPrice()}</p>
													</div>
												</li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div>

							<div class="span9">	
								<br>
								<h4 class="title">
									<span class="pull-left"><span class="text"><strong>S??ch</strong> c??ng t??c gi???</span></span>
									<span class="pull-right">
										<a class="left button" href="#myCarousel-2" data-slide="prev"></a><a class="right button" href="#myCarousel-2" data-slide="next"></a>
									</span>
								</h4>
								<div id="myCarousel-2" class="carousel slide">
									<div class="carousel-inner">
										<div class="active item">
											<ul class="thumbnails listing-products">
											<c:forEach var="ProductShow" items="${listPSsameAuthor}" begin = "0" end = "2">
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>												
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/thebook ${ProductShowdetail.getID_Product()}.jpg"></a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
														<p class="price">${ProductShow.getPrice()}</p>
													</div>
												</li>
												</c:forEach>												
											</ul>
										</div>
										<div class="item">
											<ul class="thumbnails listing-products">
											<c:forEach var="ProductShow" items="${listPSsameAuthor}" begin = "3">
												<li class="span3">
													<div class="product-box">
														<span class="sale_tag"></span>												
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/thebook ${ProductShowdetail.getID_Product()}.jpg"></a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
														<p class="price">${ProductShow.getPrice()}</p>
													</div>
												</li>
												</c:forEach>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="span3 col">
						<div class="block">
							<h4 class="title">
								<span class="pull-left"><span class="text">Ng???u nhi??n</span></span>
								<span class="pull-right">
									<a class="left button" href="#myCarousel" data-slide="prev"></a><a class="right button" href="#myCarousel" data-slide="next"></a>
								</span>
							</h4>
							<div id="myCarousel" class="carousel slide">
								<div class="carousel-inner">
									<div class="active item">
									
										<ul class="thumbnails listing-products">
										<c:forEach var="ProductShow" items="${listProductShow}" begin = "0" end = "0" >
											<li class="span3">
												<div class="product-box">
														<span class="sale_tag"></span>												
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/thebook ${ProductShowdetail.getID_Product()}.jpg"></a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
														<p class="price">${ProductShow.getPrice()}</p>
												</div>
											</li>
											</c:forEach>
										</ul>
									
									</div>
									<div class="item">
										<ul class="thumbnails listing-products">
										<c:forEach var="ProductShow" items="${listProductShow}" begin = "1" >
											<li class="span3">
												<div class="product-box">
														<span class="sale_tag"></span>												
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />"><img alt="" src="themes/images/cloth/thebook ${ProductShowdetail.getID_Product()}.jpg"></a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="title">${ProductShow.getBook_title()}</a><br/>
														<a href="Productdetail?ID_Product=<c:out value='${ProductShow.getID_Product()}' />" class="category">${ProductShow.getCategory_name()}</a>
														<p class="price">${ProductShow.getPrice()}</p>
												</div>
											</li>
										</c:forEach>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
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
			
			<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Vi???t ????nh gi?? s???n ph???m</h4>
        </div>
        <div class="modal-body">
			<form action="">
			<div class="form-group">
		      <label for="comment">????nh gi?? s???n ph???m:</label>
		      <textarea class="form-control" rows="6" id="review"></textarea>
		    </div>
			<div class="form-group">
			  <label for="loai">Ch???m ??i???m:</label>
			  <input type="number" min ="1" max ="5" class="form-control" id="star">
			</div>
			<button type="submit" class="btn btn-default">C???p nh???t</button>
			</form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
		</div>
		<script src="themes/js/common.js"></script>
		<script>
			$(function () {
				$('#myTab a:first').tab('show');
				$('#myTab a').click(function (e) {
					e.preventDefault();
					$(this).tab('show');
				})
			})
			$(document).ready(function() {
				$('.thumbnail').fancybox({
					openEffect  : 'none',
					closeEffect : 'none'
				});
				
				$('#myCarousel-2').carousel({
                    interval: 2500
                });								
			});
		</script>
    </body>
</html>