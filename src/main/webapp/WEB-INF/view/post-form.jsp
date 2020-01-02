<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp"/>

<div class="contact-clean">
    <form:form action="${pageContext.request.contextPath}/posts/processForm" modelAttribute="crmPost">
        <h2 class="text-center">Dodaj znalezisko</h2>
        <div class="form-group">
            <input class="form-control" type="text" name="sourceUrl" placeholder="Adres materiału źródłowego"></div>
            <%--            <small class="form-text text-danger">Please enter a correct email address.</small>--%>
        <div class="form-group">
            <input class="form-control" type="text" name="imageSrc" placeholder="Adres miniaturki">
        </div>
        <div class="form-group">
            <input class="form-control" type="text" name="title" placeholder="Tytuł"></div>
        <div class="form-group">
            <textarea class="form-control" name="description" placeholder="Opis..." rows="14"></textarea></div>
        <div class="form-group">
            <button class="btn btn-primary" type="submit">Dodaj</button>
        </div>
    </form:form>
</div>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp"/>