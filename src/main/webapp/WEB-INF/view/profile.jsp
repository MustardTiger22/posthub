<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/header.jsp" />

    <div class="container profile profile-view" id="profile">
        <div class="row">
            <div class="col-md-12 alert-col relative">
                <div class="alert alert-info absolue center" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button><span>Profile save with success</span></div>
            </div>
        </div>
        <form>
            <div class="form-row profile-row">
                <div class="col-md-4 relative">
                    <div class="avatar">
                        <div class="avatar-bg center"></div>
                    </div>
                </div>
                <div class="col-md-8">
                    <h1>Profil</h1>
                    <hr>
                    <div class="form-row">
                        <div class="col-sm-12 col-md-6">
                            <div class="form-group"><label>Imię </label>
                                <input class="form-control" value="${user.firstName}" type="text" name="firstname" disabled>
                            </div>
                        </div>
                        <div class="col-sm-12 col-md-6">
                            <div class="form-group"><label>Nazwisko </label>
                                <input class="form-control" value="${user.lastName}" type="text" name="lastname" disabled>
                            </div>
                        </div>
                    </div>
                    <div class="form-group"><label>Email </label>
                        <input class="form-control" value="${user.email}" type="email" autocomplete="off" name="email"  disabled>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <div class="container">
        <div class="row">
            <div class="col">
                <h1>Dodane znaleziska:</h1>
                <hr>
                <c:forEach var="post" items="${user.posts}">
                    <div class="row" style="margin: 30px 0 0 0; padding: 20px;height: 230px;">
                        <div class="col-12 col-sm-12 col-md-6 col-lg-4 col-xl-4" style="padding:0px;">
                            <div style="background-image: url('${post.imageSrc}');height: 100%;background-repeat: no-repeat;background-size: cover;background-position: center;"></div>
                        </div>
                        <div class="w-100 d-sm-block d-md-none d-lg-none d-xl-none"></div>
                        <div class="col" style="padding: 0px;">
                            <div class="card" style="height: 100%;">
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="${pageContext.request.contextPath}/post/${post.idPost}">
                                                ${post.title}
                                        </a>
                                    </h4>
                                    <p class="card-text">${post.description}</p>
                                    <a class="card-link" href="${post.sourceUrl}">Źródło</a>
                                    <a class="card-link" href="#">Wykop(${post.ratingPlus})</a>
                                    <a class="card-link" href="#">Zakop(${post.ratingMinus})</a>
                                    <h6 class="text-muted card-text mb-2">Dodano: ${post.formattedTimestamp}</h6>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>

<jsp:include page="${pageContext.request.contextPath}/resources/layout/footer.jsp" />
