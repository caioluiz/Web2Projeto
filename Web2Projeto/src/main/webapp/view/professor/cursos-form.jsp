<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Curso" %>

<%
    Curso curso = (Curso) request.getAttribute("curso");
    boolean editando = (curso != null);
%>

<%
    Object user = session.getAttribute("usuario");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/view/login.jsp");
        return;
    }

    model.Professor prof = (model.Professor) user;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= editando ? "Editar Curso" : "Novo Curso" %></title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet"
     href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.13.1/font/bootstrap-icons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="bg-light">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>

<nav class="navbar navbar-expand-lg navbar-dark bg-cobalto text-white">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>/view/professor/home.jsp">
      <img src="<%=request.getContextPath()%>/img/rural_logo_branco04.png" alt="Logo UFRRJ" width="250">
    </a>

    <div class="ms-auto text-end">
        <span class="me-4">Olá, <strong><%= prof.getNome() %></strong></span>
        <a href="<%=request.getContextPath()%>/logout" class="btn btn-light btn-sm">Sair</a>
    </div>
  </div>
</nav>

<div class="container mt-4">
    <h2 class="mb-4"><%= editando ? "Editar Curso" : "Novo Curso" %></h2>

    <form action="${pageContext.request.contextPath}/prof/cursos" method="post">

        <% if (editando) { %>
            <input type="hidden" name="id" value="<%= curso.getId() %>">
        <% } %>

        <div class="mb-3">
            <label>Título</label>
            <input type="text" name="titulo" class="form-control"
                   value="<%= editando ? curso.getTitulo() : "" %>" required>
        </div>

        <div class="mb-3">
            <label>Descrição</label>
            <textarea name="descricao" class="form-control" rows="3" required><%= editando ? curso.getDescricao() : "" %></textarea>
        </div>

        <div class="mb-3">
            <label>Responsável</label>
            <input type="text" name="responsavel" class="form-control"
                   value="<%= editando ? curso.getResponsavel() : "" %>">
        </div>

        <div class="mb-3">
            <label>Contato para Inscrição</label>
            <input type="text" name="contato" class="form-control"
                   value="<%= editando ? curso.getContatoInscricao() : "" %>">
        </div>

        <div class="mb-3">
            <label>Local</label>
            <input type="text" name="local" class="form-control"
                   value="<%= editando ? curso.getLocal() : "" %>">
        </div>

        <div class="mb-3">
            <label>Público-alvo</label>
            <input type="text" name="publicoAlvo" class="form-control"
                   value="<%= editando ? curso.getPublicoAlvo() : "" %>">
        </div>

        <div class="mb-3">
            <label>Status</label>
            <select name="status" class="form-select">
                <option value="Aberto" <%= editando && "Aberto".equals(curso.getStatus()) ? "selected" : "" %>>Aberto</option>
                <option value="Encerrado" <%= editando && "Encerrado".equals(curso.getStatus()) ? "selected" : "" %>>Encerrado</option>
            </select>
        </div>

        <div class="mb-3 form-check">
            <input type="checkbox" name="temTaxa" class="form-check-input"
                   <%= editando && curso.isTemTaxa() ? "checked" : "" %>>
            <label class="form-check-label">Possui taxa?</label>
        </div>

        <div class="row">
            <div class="col">
                <label>Data Início</label>
                <input type="date" name="dataInicio" class="form-control"
                       value="<%= editando ? curso.getDataInicio() : "" %>" required>
            </div>
            <div class="col">
                <label>Data Fim</label>
                <input type="date" name="dataFim" class="form-control"
                       value="<%= editando ? curso.getDataFim() : "" %>" required>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col">
                <label>Hora Início</label>
                <input type="time" name="horaInicio" class="form-control"
                       value="<%= editando && curso.getHoraDeInicio()!=null ? curso.getHoraDeInicio() : "" %>">
            </div>
            <div class="col">
                <label>Hora Fim</label>
                <input type="time" name="horaFim" class="form-control"
                       value="<%= editando && curso.getHoraDeTermino()!=null ? curso.getHoraDeTermino() : "" %>">
            </div>
        </div>

        <div class="mb-3 mt-3">
            <label>Nível</label>
            <select name="nivel" class="form-select">
                <option value="Básico" <%= editando && "Básico".equals(curso.getNivel()) ? "selected" : "" %>>Básico</option>
                <option value="Intermediário" <%= editando && "Intermediário".equals(curso.getNivel()) ? "selected" : "" %>>Intermediário</option>
                <option value="Avançado" <%= editando && "Avançado".equals(curso.getNivel()) ? "selected" : "" %>>Avançado</option>
            </select>
        </div>

        <div class="mb-3">
            <label>Modalidade</label>
            <select name="modalidade" class="form-select">
                <option value="Presencial" <%= editando && "Presencial".equals(curso.getModalidade()) ? "selected" : "" %>>Presencial</option>
                <option value="Online" <%= editando && "Online".equals(curso.getModalidade()) ? "selected" : "" %>>Online</option>
                <option value="Híbrido" <%= editando && "Híbrido".equals(curso.getModalidade()) ? "selected" : "" %>>Híbrido</option>
            </select>
        </div>

        <div class="mb-3">
            <label>Duração total</label>
            <input type="text" name="duracaoTotal" class="form-control"
                   value="<%= editando ? curso.getDuracaoTotal() : "" %>" placeholder="ex.: 3 meses">
        </div>
		
		<div class="mb-3">
		    <label>Máximo de participantes</label>
		    <input type="number" name="maxParticipantes" class="form-control"
		           value="<%= editando && curso.getMaxParticipantes()!=null ? curso.getMaxParticipantes() : "" %>" required>
		</div>
				
        <div class="mb-3">
            <label>Carga horária semanal (em horas)</label>
            <input type="number" step="0.5" name="cargaHorariaSemanal" class="form-control"
                   value="<%= editando && curso.getCargaHorariaSemanal()!=null ? curso.getCargaHorariaSemanal() : "" %>">
        </div>

        <button class="btn btn-success">Salvar</button>
        <a href="${pageContext.request.contextPath}/prof/cursos" class="btn btn-secondary">Voltar</a>

    </form>
</div>

</body>
</html>
