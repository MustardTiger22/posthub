<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp" />

    <div class="container profile profile-view">
            <div class="form-row profile-row">
                <div class="col-md-4 relative">
                    <div class="avatar">
                        <div class="avatar-bg center"></div>
                    </div>
                </div>
                <div class="col-md-8">
                    <h1>Profil</h1>
                    <hr>
                    <form:form action="${pageContext.request.contextPath}/profile/edit/update"
                               modelAttribute="crmProfile"
                               method="post">
                    <div class="form-row">
                        <div class="col-sm-12 col-md-6">
                            <div class="form-group"><label>Imię </label>
                                <form:input  class="form-control" value="${user.firstName}"  path="firstName" />
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6">
                            <div class="form-group"><label>Nazwisko </label>
                                <form:input class="form-control" value="${user.lastName}" type="text" path="lastName"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group"><label>Email </label>
                        <form:input class="form-control" value="${user.email}" type="email" autocomplete="off" path="email"/>
                    </div>
                    <form:button type="submit" class="btn btn-primary">
                        Zapisz zmiany
                    </form:button>
                    </form:form>
                </div>
            </div>
    </div>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />
