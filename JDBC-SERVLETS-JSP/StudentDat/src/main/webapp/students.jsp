<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
    <h1>Student Details</h1>
    <table border="1">
        <tr>
            <th>Sl No</th>
            <th>Name</th>
            <th>DOB</th>
            <th>Email</th>
        </tr>
        <c:if test="${empty students}">
		    <p>No student data available.</p>
		</c:if>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.sl}</td>
                <td>${student.name}</td>
                <td>${student.dob}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
        
                
    </table>
</body>
</html>
