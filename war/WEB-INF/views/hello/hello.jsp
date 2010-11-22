<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>Count to 10 Example (using JSTL)</title>
</head>

<body>


<p>
1) Hello, <%= request.getAttribute("name") %>! this is spring talking. ${2 +2}
</p>

<p>
2) Hello, ${requestScope.name}! this is spring talking.
</p>

<p>
2) Hello, ${name}! this is spring talking.
</p>

<p>
3) Hello, <c:out value="${requestScope.name}" />! this is spring talking.
</p>


<p><c:forEach var="i" begin="1" end="10" step="1">
  <c:out value="${i}" />

  <br />
</c:forEach></p>

</body>
</html>




