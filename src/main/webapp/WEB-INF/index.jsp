<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products Filter</title>

    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>Products Filter</h3>

    <c:url var="filterAction" value="/"/>
    <form:form action="${filterAction}" modelAttribute="filter">
        <div class="row">
            <div class="form-group col-md-3">
                <form:label path="categoryName">
                    <spring:message text="Category"/>
                </form:label>
                <form:input cssClass="form-control" path="categoryName"/>
                <form:errors path="categoryName" cssClass="text-danger field-validation-error"/>
            </div>
            <div class="form-group col-md-3">
                <form:label path="productName">
                    <spring:message text="Product"/>
                </form:label>
                <form:input cssClass="form-control" path="productName"/>
                <form:errors path="productName" cssClass="text-danger field-validation-error"/>
            </div>
            <div class="form-group col-md-2">
                <form:label path="downPrice">
                    <spring:message text="Price down"/>
                </form:label>
                <form:input cssClass="form-control" path="downPrice"/>
                <form:errors path="downPrice" cssClass="text-danger field-validation-error"/>
            </div>
            <div class="form-group col-md-2">
                <form:label path="upPrice">
                    <spring:message text="Price up"/>
                </form:label>
                <form:input cssClass="form-control" path="upPrice"/>
                <form:errors path="upPrice" cssClass="text-danger field-validation-error"/>
            </div>
            <div class="form-group col-md-2">
                <br>
                <input class="btn btn-primary" type="submit" value="Find"/>
            </div>
        </div>
    </form:form>


    <table class="table">
        <tr>
            <th>Category</th>
            <th>Product name</th>
            <th>Price</th>
        </tr>
        <c:if test="${!empty productList}">
            <c:forEach items="${productList}" var="product">
                <tr>
                    <td>${product.category.name}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                </tr>
            </c:forEach>
        </c:if>
    </table>


</div>
</body>
</html>