<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Spring MVC Form Handling</title>
	</head>
	<body>
		<h2>Add Product Data</h2>
		<form:form method="POST" action="save.html" enctype="multipart/form-data" >
	   		<table>
			    <tr>
			        <td><form:label path="id">Product ID:</form:label></td>
			        <td><form:input path="id" value="${product.id}" readonly="true"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="name">Product Name:</form:label></td>
			        <td><form:input path="name" value="${product.name}" placeholder="Enter Name" required="required"/></td>
			    </tr>
			    <tr>
			        <td><form:label path="price">Product Price:</form:label></td>
			          <c:if test="${!empty product}">
			       		 <td><form:input path="price" value="${product.price}" placeholder="Enter Price"/></td>
			        </c:if>
			        <c:if test="${empty product}">
			        	<td><form:input path="price" onfocus="this.value=''" placeholder="Enter Price"/></td>
			        </c:if>
			    </tr>
			    <tr>
			        <td><form:label path="quantity">Product Quantity:</form:label></td>
			        <c:if test="${!empty product}">
			        <td><form:input path="quantity" onfocus="this.value=''" value="${product.quantity}" placeholder="Enter Quantity"/></td>
			        </c:if>
			        <c:if test="${empty product}">
			        	<td><form:input path="quantity" onfocus="this.value=''" placeholder="Enter Quantity"/></td>
			        </c:if>
			    </tr>
			    <tr>
			    	<td><form:label path="fileData">Product Image:</form:label></td>
			    	<td><form:input type="file" path="fileData" value="${product.fileData}"/></td>
			    </tr>
			    <tr>
			      <td colspan="2"><input type="submit" value="Submit"/></td>
		      </tr>
			</table> 
		</form:form>
		<br>
		<br>
		
  <c:if test="${!empty products}">
	<table align="left" border="1">
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
				<td align="center"><a href="edit.html?id=${product.id}">Edit</a> | <a href="delete.html?id=${product.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
	</body>
</html>