<mvc:resources mapping="img/favicon.ico" location="img/favicon.ico" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>HOME</h1>
    <p><%= request.getAttribute("foo") %></p>
</body>
</html>