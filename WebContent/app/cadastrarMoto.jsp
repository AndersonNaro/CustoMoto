<%@ page import="java.util.List" %>
<%@ page import="net.sytes.scarranaro.vo.Moto" %>
<%@ page import="net.sytes.scarranaro.da.DAMoto" %>

<%@ include file="../templates/head.html" %> 
<section class="fundo">
	
	<%
	int id = (Integer) session.getAttribute("i_id_usr");
	DAMoto da = new DAMoto();
	List<Moto> motos = da.doUsuario(id); 
	String marca;
	%>
	
	<form action="CadastrarMoto" method="post">	
		<input type="hidden" name="acao" id="acao" value="cadastrar">	
		<div class="card" >
		  <div class="card-header">
		    Escolha a Moto
		  </div>
		  <div class="card-body" >
		  		
		  		<h5 class="card-text small">Fabricante da moto:</h5>
				<div class="input-group input-group-sm mb-3">
					<input type="text" class="form-control" name="marca">
				</div>
				
				<h5 class="card-text small">Modelo:</h5>
				<div class="input-group input-group-sm mb-3">
					<input type="text" class="form-control" name="modelo">
				</div>
				
				<h5 class="card-text small">Quilometragem:</h5>
				<div class="input-group input-group-sm mb-3">
					<input type="text" class="form-control" name="km">
				</div>
		  		
				<button type="submit" class="btn btn-primary">Ok</button>
				
				<a href="MotoServlet" class="btn btn-secondary" align="right">Voltar</a>
		  </div>
		</div>		
	</form>	  
	

</section>	
<%@ include file="../templates/footer.jsp"%>tml>