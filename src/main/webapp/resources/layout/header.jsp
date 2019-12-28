<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<meta charset="utf-8">
<title>vikop</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/fonts/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Contact-Form-Clean.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Footer-Clean.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Navigation-with-Button.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Pretty-Registration-Form.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Profile-Edit-Form-1.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/Profile-Edit-Form.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>

<body>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button">
        <div class="container"><a class="navbar-brand" href="#">vikop.ru</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mr-auto">
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" href="${pageContext.request.contextPath}/">Wykopalisko</a>
                    </li>
                    <li class="nav-item" role="presentation">
                        <a class="nav-link" href="${pageContext.request.contextPath}/mikroblog">Mikroblog</a>
                    </li>
                </ul>
                    <security:authorize access="isAnonymous()">
                        <span class="navbar-text">
                            <a class="login" href="${pageContext.request.contextPath}/login">Log In</a>
                            <a class="btn btn-light action-button" role="button" href="${pageContext.request.contextPath}/register">Sign Up</a>
                        </span>
                    </security:authorize>
                    <security:authorize access="isAuthenticated()">
                        <security:authorize access="hasRole('ADMIN')">
                            <span class="navbar-text">
                                <a class="btn btn-light action-button" role="button" href="#">Panel Administracyjny</a>
                            </span>
                        </security:authorize>
                        <span class="navbar-text">
                            <a class="btn btn-light action-button" role="button" href="${pageContext.request.contextPath}/profile">Profil</a>
                        </span>
                        <form:form action="${pageContext.request.contextPath}/logout" method="post">
                            <input type="submit" value="Log Out" class="btn btn-light action-button">
                        </form:form>
                    </security:authorize>
            </div>
        </div>
    </nav>