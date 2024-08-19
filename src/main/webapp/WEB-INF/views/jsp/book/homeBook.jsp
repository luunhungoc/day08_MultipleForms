<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book management demo | Home</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<%@ include file="headerBook.jsp" %>
<body>


<div class="row">
   <form action="search" class="form-inline my-2 my-lg-0">
        <input name="searchInput" type="text" class="form-control mr-sm-2" placeholder="Search by name or author..." >
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
</div>
<c:if test="${not empty bookList}">
<table class="table">

  <thead>
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Author</th>
      <th scope="col">ISBN</th>
      <th scope="col">Price</th>
      <th scope="col">Publish Date</th>
      <th scope="col">Category</th>

    </tr>
  </thead>
  <tbody>
  <c:forEach var="book" items="${bookList}">
    <tr>
      <th scope="row">${book.id}</th>
      <td>${book.name}</td>
      <td>${book.author}</td>
      <td>${book.bookDetails.isbn}</td>
      <td>${book.bookDetails.price}</td>
      <td>${book.bookDetails.publishDate}</td>
      <td>${book.category.name}</td>
      <td>
      <button type="button" class="btn btn-primary">Edit</button>
      <button type="button" class="btn btn-danger">Delete</button>
      </td>
    </tr>
    </c:forEach>

  </tbody>
</table>
</c:if>

</body>
</html>