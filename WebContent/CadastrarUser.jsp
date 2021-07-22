<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="templates/head.html"%>


<section class="fundo">
	<form action="CadastrarUser" method="post">
		<div class="card" style="width: 15rem">
			<div class="card-header">Cadastrar novo usuário</div>
			<div class="card-body">
				<h5 class="card-text small">Digite um nome de usário:</h5>
				<div class="input-group input-group-sm mb-3">
					<input type="text" class="form-control" name="usuario">
				</div>
				<h5 class="card-text small">Defina uma senha:</h5>
				<div class="input-group input-group-sm mb-3">
					<input type="password" class="form-control" name="password">
				</div style="text-align: right;">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
				<br />
				<%
				if (session.getAttribute("status") == null) {
					session.setAttribute("status", "");
				}
				String status = (String) session.getAttribute("status");
				System.out.println((String) session.getAttribute("status"));
				if (status.equals("SUCCESS")) {
					out.print("<script>alert(\"Usuário cadastrado comk sucesso!!!\");</script>");

				} else if (status.equals("ERROR")) {
					session.removeAttribute("status"); //   setAttribute("status", null);
					out.print("<script>alert(\"Erro: Nome de usuário indisponível!\");</script>");
				}
				%>
			</div>
		</div>
	</form>
</section>

<%@ include file="templates/footer.jsp"%>