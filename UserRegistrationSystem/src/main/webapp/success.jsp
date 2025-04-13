<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Successful</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="registration-container" style="text-align: center;">
    <div class="registration-header">
        <h2>Registration Successful!</h2>
    </div>

    <p>Welcome, ${user.fullName}!</p>
    <p>Your username: ${user.username}</p>
    <p>Your email: ${user.email}</p>

    <div class="login-link">
        <a href="${pageContext.request.contextPath}/register">Back to registration</a>
    </div>
</div>
</body>
</html>