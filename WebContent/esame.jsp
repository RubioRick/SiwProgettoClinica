<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Esame</title>
</head>
<body>
<f:view>
<h1>${esameController.esame.id}</h1>
<h2>Informazioni Esame</h2>
<div>Nome: ${productController.esame.nome}</div>
<div>Tipologia Esame: ${productController.esame.tipologiaEsame}</div>
<div>Medico: ${productController.esame.medicoResponsabile}</div>
</f:view>
</body>
</html>