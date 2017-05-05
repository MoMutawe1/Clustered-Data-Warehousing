<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head><h2>Search records by file name</h2>
<body>
<form action="search/result">
<table>
<tr><td>File Name:<input type="text" name="name"/></td>
<td><input type="submit" value="search" /></td>
</tr>
</table>

</form>

FileName:<c:out value="${csvFile.name}" />

<c:forEach items="${csvFile.validRecords}" var="record">     
    <c:out value="${record.fromCurrencyCode}"/>
     <c:out value="${record.toCurrencyCode}"/>
       <c:out value="${record.amount}"/>
</c:forEach>
</body>
</html>