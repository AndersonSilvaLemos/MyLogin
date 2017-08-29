<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detalhes do Cliente</title>
</head>
<body>
<h>Detalhes do Cliente</h>
<br>
Id:<input type="text" value="${Cliente.id}" disable="disable"/>
Nome:<input type="text" value="${Cliente.nome }"/>
Cpf:<input type="text" value="${Cliente.cpf}"/>
Email:<input type="text" value="${Cliente.email }"/>

</body>
</html>