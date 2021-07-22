<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="templates/head.html" %> 

<section class="fundo">	
	<form action="login" method="post">		
		<div class="card" style="width: 15rem">
		  <div class="card-header">
		    Autentificação
		  </div>
		  <div class="card-body" >
		  		<div class="input-group input-group-sm mb-3">  
					<input type="text" class="form-control" name="usuario" placeholder="Usuário">
				</div>
				<div class="input-group input-group-sm mb-3"> 
					<input type="password" class="form-control" name="password" placeholder="Password">
				</div>
				<button type="submit" class="btn btn-primary">Logar</button>				
				<a href="CadastrarUser" class="btn btn-secondary">Novo</a>				
		  </div>
		</div>		
	</form>	 		
</section>
 
<%@ include file="templates/footer.jsp" %>