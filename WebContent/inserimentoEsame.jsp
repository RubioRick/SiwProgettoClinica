<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Inserimento esame</title>
<style>
html, #page {
	padding: 0;
	margin: 0;
}

body {
	margin: 0;
	padding: 0;
	width: 100%;
	color: #959595;
	font: normal 12px/2.0em Sans-Serif;
}

h1, h2, h3, h4, h5, h6 {
	color: darkred;
}

#page {
	background: #fff;
}

#header, #footer, #top-nav, #content, #content #contentbar, #content #sidebar
	{
	margin: 0;
	padding: 0;
}

/* Logo */
#logo {
	padding: 0;
	width: auto;
	float: left;
}

#logo h1 a, h1 a:hover {
	color: darkred;
	text-decoration: none;
}

#logo h1 span {
	color: #f8dbdb;
}

/* Header */
#header {
	background: #fff;
}

#header-inner {
	margin: 0 auto;
	padding: 0;
	width: 970px;
}

/* Feature */
.feature {
	background: red;
	padding: 18px;
}

.feature-inner {
	margin: auto;
	width: 970px;
}

.feature-inner h1 {
	color: #f8dbdb;
	font-size: 32px;
}

/* Menu */
#top-nav {
	margin: 0 auto;
	padding: 0px 0 0;
	height: 37px;
	float: right;
}

#top-nav ul {
	list-style: none;
	padding: 0;
	height: 37px;
	float: left;
}

#top-nav ul li {
	margin: 0;
	padding: 0 0 0 8px;
	float: left;
}

#top-nav ul li a {
	display: block;
	margin: 0;
	padding: 8px 20px;
	color: red;
	text-decoration: none;
}

#top-nav ul li.active a, #top-nav ul li a:hover {
	color: #f8dbdb;
}

/* Content */
#content-inner {
	margin: 0 auto;
	padding: 10px 0;
	width: 970px;
	background: #fff;
}

#content #contentbar {
	margin: 0;
	padding: 0;
	float: right;
	width: 760px;
}

#content #contentbar .article {
	margin: 0 0 24px;
	padding: 0 20px 0 15px;
}

#content #sidebar {
	padding: 0;
	float: left;
	width: 200px;
}

#content #sidebar .widget {
	margin: 0 0 12px;
	padding: 8px 8px 8px 13px;
	line-height: 1.4em;
}

#content #sidebar .widget h3 a {
	text-decoration: none;
}

#content #sidebar .widget ul {
	margin: 0;
	padding: 0;
	list-style: none;
	color: #959595;
}

#content #sidebar .widget ul li {
	margin: 0;
}

#content #sidebar .widget ul li {
	padding: 4px 0;
	width: 185px;
}

#content #sidebar .widget ul li a {
	color: red;
	text-decoration: none;
	margin-left: -16px;
	padding: 4px 8px 4px 16px;
}

#content #sidebar .widget ul li a:hover {
	color: #f8dbdb;
	font-weight: bold;
	text-decoration: none;
}

/* Footerblurb */
#footerblurb {
	background: #f8dbdb;
	color: red;
}

#footerblurb-inner {
	margin: 0 auto;
	width: 922px;
	padding: 24px;
}

#footerblurb .column {
	margin: 0;
	text-align: justify;
	float: left;
	width: 250px;
	padding: 0 24px;
}

/* Footer */
#footer {
	background: #fff;
}

#footer-inner {
	margin: auto;
	text-align: center;
	padding: 12px;
	width: 922px;
}

#footer a {
	color: red;
	text-decoration: none;
}

/* Clear both sides to assist with div alignment  */
.clr {
	clear: both;
	padding: 0;
	margin: 0;
	width: 100%;
	font-size: 0px;
	line-height: 0px;
}
</style>
</head>
<body>
	<div id="page">
		<header id="header">
			<div id="header-inner">
				<div id="logo">
					<h1>
						<a href="#">Clinica<span> GSG</span></a>
					</h1>
				</div>
				<div id="top-nav">
					<ul>
						<%
							if (session.getAttribute("user") == null) {
								out.print("<a href='Login.jsp'>Login</a>");
							} else {
								out.print(session.getAttribute("user"));
							}
						%>
					</ul>
				</div>
				<div class="clr"></div>
			</div>
		</header>
		<div class="feature">
			<div class="feature-inner">
				<h1>Inserimento esame</h1>
			</div>
		</div>
		<div id="content">
			<div id="content-inner">

				<main id="contentbar">
				<div class="article">
					<h2>
						<span></span>
					</h2>


					<form class="form-horizontal">
						<fieldset>

							<!-- Form Name -->
							<legend>Inserimento esame</legend>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="codice fiscale">Codice
									fiscale Paziente</label>
								<div class="col-md-4">
									<h:inputText value="#{esameController.paziente.codiceFiscale}" required="true"
										requiredMessage="cf is mandatory" id="cf" />
									<h:message for="name" />
									<span class="help-block">help</span>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="medico">ID
									medico</label>
								<div class="col-md-4">
									<h:inputText value="#{esameController.medico.id}" required="true"
										requiredMessage="id is mandatory" id="idMedico" />
									<h:message for="name" /> <span
										class="help-block">help</span>
								</div>
							</div>

							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="tipologiaEsame">ID
									Tipologia esame</label>
								<div class="col-md-4">
									<h:inputText value="#{esameController.tipologia}" required="true"
										requiredMessage="cf is mandatory" id="cf" />
									<h:message for="name" />
									<span class="help-block">help</span>
								</div>
							</div>

							<!-- Button -->
							<div class="form-group">
								<label class="col-md-4 control-label" for="conferma">Conferma</label>
								<div class="col-md-4">
									<h:commandButton value="Submit"  action="#{esameController.CreaEsame}"/>
								</div>
							</div>

						</fieldset>
					</form>


					</p>

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
					<p>Questo sito è stato sviluppato da Riccardo Grasselli ,
						Federico Giulianelli , Simone Sanò.</p>
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