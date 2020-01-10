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
                <h6 class="text-muted card-text mb-2">Dodano: ${post.timestamp}</h6>
                <h7 class="text-muted card-text mb-2">
                    Przez:
                    <a href="${pageContext.request.contextPath}/profile/${post.user.username}">
                        ${post.user.username}
                    </a>
                </h7>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="col"><div class="container">
        <h2 class="text-center">Komentarze</h2>
        <c:forEach var="comment" items="${comments}">
            <c:url var="deleteLink" value="/admin/deleteComment">
                <c:param name="idPost" value="${post.idPost}" />
                <c:param name="idComment" value="${comment.idComment}" />
            </c:url>
        <div class="card" style="margin: 5px;">
            <div class="card-body">
                <div class="row">
                    <div class="col-md-2">
                        <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
                        <p class="text-secondary text-center">${comment.formattedTimestamp}</p>
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
                        <security:authorize access="hasRole('ADMIN')">
                        <p>
                            <a href="${deleteLink}" class="btn btn-danger action-button" role="button">
                                Usuń
                            </a>
                        </p>
                        </security:authorize>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
        <security:authorize access="isAuthenticated()">
            <form:form action="${pageContext.request.contextPath}/post/processComment"
                       modelAttribute="postComment" method="post" style="margin: 20px;">
                <textarea minlength="5" name="content" class="form-control" required></textarea>
                <button class="btn btn-danger" style="border: none;width: 151px;height: 58px;background-color: #e86767;margin: 10px;" type="submit">Wyślij</button>
            </form:form>
        </security:authorize>
    </div>
</div>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />