<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp" />

<div class="row" style="margin: 0px;padding: 20px;height: 300px;">
    <div class="col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4" style="padding:0px;">
        <div style="background-image: url('${post.imageSrc}');height: 100%;background-repeat: no-repeat;background-size: cover;background-position: center;"></div>
    </div>
    <div class="w-100 d-sm-block d-md-none d-lg-none d-xl-none"></div>
    <div class="col" style="padding: 0px;">
        <div class="card" style="height: 100%;">
            <div class="card-body">
                <h4 class="card-title">${post.title}</h4>
                <p class="card-text">${post.description}</p>
                <a class="card-link" href="${post.sourceUrl}">Źródło</a>
                <a class="card-link" href="#">Wykop(${post.ratingPlus})</a>
                <a class="card-link" href="#">Zakop(${post.ratingMinus})</a>
                <h6 class="text-muted card-text mb-2">Dodano: ${post.timestamp}</h6>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="col"><div class="container">
        <h2 class="text-center">Komentarze</h2>
        <c:forEach var="comment" items="${comments}">
        <div class="card">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-2">
                        <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
                        <p class="text-secondary text-center">${comment.timestamp}</p>
                    </div>
                    <div class="col-md-10">
                        <p>
                            <a class="float-left"
                               href="${pageContext.request.contextPath}/profile/${comment.user.username}">
                                <strong>${comment.user.username}</strong>
                            </a>
                            <span class="float-right"><i class="text-warning fa fa-star"></i></span>
                            <span class="float-right"><i class="text-warning fa fa-star"></i></span>
                            <span class="float-right"><i class="text-warning fa fa-star"></i></span>
                            <span class="float-right"><i class="text-warning fa fa-star"></i></span>

                        </p>
                        <div class="clearfix"></div>
                        <p>${comment.content}</p>
                        <p>
                            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
        <security:authorize access="isAuthenticated()">
            <form:form action="${pageContext.request.contextPath}/post/processComment"
                       modelAttribute="postComment" method="post" style="margin: 20px;">
                <textarea name="content" class="form-control"></textarea>
                <button class="btn btn-danger" style="border: none;width: 151px;height: 58px;background-color: #e86767;margin: 10px;" type="submit">Wyślij</button>
            </form:form>
        </security:authorize>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />