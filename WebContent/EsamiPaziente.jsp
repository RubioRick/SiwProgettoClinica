<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">

<f:view>
<h1>Esami</h1>
<h:form>
<table>
	<tr>
		<th>Nome Esami Prenotati</th>
	</tr>
	<c:forEach var="esame" items="#{esameController.esamiPerPaziente(loginController.paziente)}">
		<tr><td>
		<h:commandLink action="#{esameController.trovaEsame}" value="#{esame.nome}">
			<f:param name="id" value="#{esame.id}" />
		</h:commandLink></td></tr>
	</c:forEach>
</table>
</h:form>

</f:view>

</head>
<body>

</body>
</html>