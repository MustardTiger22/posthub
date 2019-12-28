<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp" />

    <div class="login-clean">
        <form:form action="${pageContext.request.contextPath}/perform_login" method="POST">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration"><i class="icon ion-ios-navigate"></i></div>
            <c:if test="${param.error != null}">
                <i>Błędny login lub hasło!</i>
            </c:if>
            <div class="form-group"><input class="form-control" type="username" name="username" placeholder="Username"></div>
            <div class="form-group"><input class="form-control" type="password" name="password" placeholder="Password"></div>
            <div class="form-group">
                <button class="btn btn-primary btn-block" type="submit">Log In</button>
            </div>
            <div>
                <a href="${pageContext.request.contextPath}/register"
                   class="btn btn-primary"
                   role="button" aria-pressed="true">
                    Register New User
                </a>
            </div>
        </form:form>
    </div>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />