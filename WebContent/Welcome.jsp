<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="it.uniroma3.db.models.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
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
								Paziente paziente = (Paziente)request.getAttribute("paziente");
								Medico medico = (Medico)request.getAttribute("medico");
								Amministratore amministratore = (Amministratore)request.getAttribute("ammistratore");
								
								if (paziente != null) {
									out.print(paziente.getNome());
								} 
								else if(amministratore != null){
									out.print(amministratore.getNome() + " (Admin)");
								} 
								else if(medico != null){
									out.print(medico.getNome() + " (Medico)");
								}
								else {
									out.print("<a href='Login.jsp'>Login</a>");
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
						<b>Benvenuto nel portale della clinica GSG.</b>
					</p>
					<p>La clinica offre le seguenti tipologie di esame:</p>
					<h1>Tipologie</h1>
					<f:view>
						<h:form>
							<h3>Nome</h3>
							<c:forEach var="tipologia" items="#{tipologiaEsameController.tipologieEsame}">
								<p>
									<h:commandLink
										action="#{tipologiaEsameController.trovaTipologiaEsame}"
										value="#{tipologia.nome}">
										<f:param name="id" value="#{tipologia.id} " />
									</h:commandLink>
								</p>
							</c:forEach>
						</h:form>
					</f:view>
				</div>
				</main>
				<nav id="sidebar">
					<div class="widget">
						<h3>Informazioni</h3>
						<ul>
							<li><a href="#">Help</a></li>
							<li><a href="#">Contatti</a></li>
							<%
							if(amministratore != null)
								out.print(
									"<li><a href='faces/inserimentoEsame.jsp'>Inserisci Prenotazione Esame</a></li>" +
									"<li><a href='faces/inserimentoTipologiaEsame.jsp'>Inserisci Tipologia Esame</a></li>" +
									"<li><a href='faces/inserimentoRisultatiEsame.jsp'>Inserisci Risultati Esame</a></li>" +
									"<li><a href='faces/visualizzaEsamiMedico.jsp'>Mostra Medico</a></li>"
								);
							%>
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