<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp" />

<table class="table" style="margin: 10px 0 0 0">
    <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Nazwa użytkownika</th>
            <th scope="col">Email</th>
            <th scope="col">Imię</th>
            <th scope="col">Nazwisko</th>
            <th scope="col">Płeć</th>
            <th scope="col">Data założenia</th>
        </tr>
    </thead>
    <c:forEach var="user" items="${users}">
    <c:url var="profileLink" value="/profile/${user.username}" />
    <tbody>
        <tr>
            <th scope="row">${user.idUser}</th>
            <td>
                <a href="${profileLink}">${user.username}</a>
            </td>
            <td>${user.email}</td>
            <td>${user.lastName}</td>
            <td>${user.firstName}</td>
            <td>${user.gender}</td>
            <td>${user.formattedTimestamp}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />
