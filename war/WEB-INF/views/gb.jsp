<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
  <link rel="stylesheet" href="/static/css/blueprint/screen.css" type="text/css" media="screen, projection">
  <link rel="stylesheet" href="/static/css/blueprint/print.css" type="text/css" media="print">
  <!--[if lt IE 8]><link rel="stylesheet" href="css/blueprint/ie.css" type="text/css" media="screen, projection"><![endif]-->
</head>
<body>

<c:choose>
  <c:when test="${!empty user}">
    <p>Hello, ${user.nickname}! (You can <a href="${logoutHref}">sign
    out</a>.)</p>
  </c:when>
  <c:otherwise>
    <p>Hello! <a href="${loginHref}">Sign in</a> to include your
    name with greetings you post.</p>
  </c:otherwise>
</c:choose>

<c:if test="${empty greetings}">
  <p>The guestbook has no messages.</p>
</c:if>

<c:forEach var="greeting" items="${greetings}">

  <c:choose>
    <c:when test="${!empty greeting.author}">
      <p><b>${greeting.author.nickname}</b> wrote:</p>
    </c:when>
    <c:otherwise>
      <p>An anonymous person wrote:</p>
    </c:otherwise>
  </c:choose>

  <blockquote>${greeting.content}</blockquote>

</c:forEach>

<form action="/gb/new" method="post">
<div><textarea name="content" rows="3" cols="60"></textarea></div>
<div><input type="submit" value="Post Greeting" /></div>
</form>

</body>
</html>