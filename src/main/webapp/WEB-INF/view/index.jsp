<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp" />

    <c:forEach var="wykopalisko" items="${wykopaliska}">
    <div class="row" style="margin: 0px;padding: 20px;height: 230px;">
        <div class="col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4" style="padding:0px;">
            <div style="background-image: url('${pageContext.request.contextPath}/resources/img/mac.jpeg');height: 100%;background-repeat: no-repeat;background-size: cover;background-position: center;"></div>
        </div>
        <div class="w-100 d-sm-block d-md-none d-lg-none d-xl-none"></div>
        <div class="col" style="padding: 0px;">
            <div class="card" style="height: 100%;">
                <div class="card-body">
                    <h4 class="card-title">${wykopalisko.title}</h4>
                    <p class="card-text">${wykopalisko.description}</p>
                    <a class="card-link" href="${wykopalisko.sourceUrl}">Źródło</a>
                    <a class="card-link" href="#">Wykop(${wykopalisko.ratingPlus})</a>
                    <a class="card-link" href="#">Zakop(${wykopalisko.ratingMinus})</a>
                    <h6 class="text-muted card-text mb-2">Dodano: ${wykopalisko.timestamp}</h6>
                </div>
            </div>
        </div>
    </div>
    </c:forEach>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />
