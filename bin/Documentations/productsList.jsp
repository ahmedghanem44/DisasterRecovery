<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Products</title>
</head>
<body>
<h1>List of Products</h1>
<h3><a href="new.html">Add New Product</a></h3>

<c:if test="${!empty products}">
	<table align="center" border="1">
		<tr>
			<th>Product ID</th>
			<th>Product Name</th>
			<th>Product Price</th>
			<th>Product Quantity</th>
			<th>Product Image</th>
		</tr>

		<c:forEach items="${products}" var="product">
			<tr>
				<td><c:out value="${product.id}"/></td>
				<td><c:out value="${product.name}"/></td>
				<td><c:out value="${product.price}"/></td>
				<td><c:out value="${product.quantity}"/></td>
				<td><img src="productImage.html?id=${product.id}" width="200" height="200"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>