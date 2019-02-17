
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Events</title>
</head>
<body>
<h1>List Event</h1>


<c:if test="${!empty events}">
 <table align="left" border="1">
  <tr>
   <th>Event ID</th>
   <th>Event Name</th>
   <th>Event Location</th>
   <th>Event Category</th>
   <th>Employee Date</th>
  </tr>

  <c:forEach items="${events}" var="event">
   <tr>
    <td><c:out value="${event.event_Id}"/></td>
    <td><c:out value="${event.event_Name}"/></td>
    <td><c:out value="${event.location}"/></td>
    <td><c:out value="${event.event_Category}"/></td>
    <td><c:out value="${event.event_Date}"/></td>
   </tr>
  </c:forEach>
 </table>
</c:if>
</body>
</html>