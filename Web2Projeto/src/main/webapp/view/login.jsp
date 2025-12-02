<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Extensão UFRRJ</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container col-4 mt-5">
    <h2 class="text-center mb-4">Login</h2>

    <form action="${pageContext.request.contextPath}/login" method="post">

        <div class="mb-3">
            <label>Email</label>
            <input type="text" name="email" class="form-control" required>
        </div>

        <div class="mb-3">
            <label>Senha</label>
            <input type="password" name="senha" class="form-control" required>
        </div>

        <% if (request.getAttribute("erro") != null) { %>
            <div class="alert alert-danger">
                <%= request.getAttribute("erro") %>
            </div>
        <% } %>

        <button class="btn btn-primary w-100">Entrar</button>
    </form>
</div>

</body>
</html>
