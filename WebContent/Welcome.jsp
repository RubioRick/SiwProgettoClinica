<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Benvenuto in Clinica GSG</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="page">
		<header id="header">
			<div id="header-inner">
				<div id="logo">
					<h1>
						<a>Clinica<span> GSG</span></a>
					</h1>
				</div>
				<div id="top-nav">
					<ul>
						<li>
							<%
								if (session.getAttribute("user") == null) {
									out.print("<a href='Login.jsp'>Login</a>");
								} else {
									out.print(session.getAttribute("user"));
								}
							%>
						</li>
					</ul>
				</div>
				<div class="clr"></div>
			</div>
		</header>
		<div class="feature">
			<div class="feature-inner">
				<h1>Benvenuto</h1>
			</div>
		</div>
		<div id="content">
			<div id="content-inner">
				<main id="contentbar">
				<div class="article">
					<h2>
						<span></span>
					</h2>
					<p>
						<b>Benvenuto nel portale della clinica GSC.</b>
					</p>
					<p>La clinica offre le seguenti tipologie di esame:</p>
					<f:view>
						<h1>Tipologie esame:</h1>
						<h:form>
							<c:forEach var="tipologiaEsame" items="#{TipologiaEsameController.tipologieEsame}">
									
									    
									<a href="mostraTipologiaEsame.jsp?id=<h:commandLink>
												action='#{TipologiaEsameController.findTipologie}'
												value= '#{tipologiaEsame.id}'>
												</h:commandLink>" > ${tipologiaEsame.nome} </a>
										
									
								</c:forEach>
							
						</h:form>

					</f:view>
					<p></p>
				</div>
				</main>
				<nav id="sidebar">
					<div class="widget">
						<h3>Informazioni</h3>
						<ul>
							<li><a href="#">Help</a></li>
							<li><a href="#">Contatti</a></li>
						</ul>
					</div>
				</nav>
				<div class="clr"></div>
			</div>
		</div>
		<div id="footerblurb">
			<div id="footerblurb-inner">

				<div class="text">
					<h2>
						<span>Crediti</span>
					</h2>
					<p>Questo sito è stato sviluppato da Riccardo Grasselli,
						Federico Giulianelli, Simone Sanò.</p>
				</div>
				<div class="clr"></div>
			</div>
		</div>
		<footer id="footer">
			<div id="footer-inner">
				<p>
					&copy; Copyright <a href="#">Your Site</a> &#124; <a href="#">Terms
						of Use</a> &#124; <a href="#">Privacy Policy</a>
				</p>
				<div class="clr"></div>
			</div>
		</footer>
	</div>
</body>
</html>