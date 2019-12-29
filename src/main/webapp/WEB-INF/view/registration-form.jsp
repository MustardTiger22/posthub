<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp" />

<div class="d-flex justify-content-center">
    <div id="loginbox" style="margin-top: 50px;"
         class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

        <div class="panel panel-primary">

            <div class="panel-heading">
                <div class="panel-title"><h2>Rejestracja</h2></div>
            </div>

            <div style="padding-top: 30px" class="panel-body">

                <!-- Registration Form -->
                <form:form action="${pageContext.request.contextPath}/register/processForm"
                           modelAttribute="crmUser"
                           class="form-horizontal">

                    <!-- Place for messages: error, alert etc ... -->
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>
                                <!-- Check for registration error -->
                                <c:if test="${registrationError != null}">

                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                            ${registrationError}
                                    </div>

                                </c:if>
                            </div>
                        </div>
                    </div>

                    <!-- User name -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <form:errors path="username" cssClass="error" />
                        <form:input path="username" placeholder="Nazwa użytkownika (*)" class="form-control" />
                    </div>

                    <!-- Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <form:errors path="password" cssClass="error" />
                        <form:password path="password" placeholder="Hasło (*)" class="form-control" />
                    </div>

                    <!-- Confirm Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <form:errors path="matchingPassword" cssClass="error" />
                        <form:password path="matchingPassword" placeholder="Powtórz hasło (*)" class="form-control" />
                    </div>

                    <!-- First name -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <form:errors path="firstName" cssClass="error" />
                        <form:input path="firstName" placeholder="Imię (*)" class="form-control" />
                    </div>

                    <!-- Last name -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <form:errors path="lastName" cssClass="error" />
                        <form:input path="lastName" placeholder="Nazwisko (*)" class="form-control" />
                    </div>

                    <!-- Email -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <form:errors path="email" cssClass="error" />
                        <form:input path="email" placeholder="Email (*)" class="form-control" />
                    </div>

                    <!-- Email -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <form:errors path="gender" cssClass="error" />
                        <label class="radio-inline">
                            <form:radiobutton path="gender" value="M" />Mężczyzna
                        </label>
                        <label class="radio-inline">
                            <form:radiobutton path="gender" value="K" />Kobieta
                        </label>
                    </div>

                    <!-- Register Button -->
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-6 controls">
                            <button type="submit" class="btn btn-primary">Register</button>
                        </div>
                    </div>

                </form:form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />