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
	
	<form action="MotoServlet" method="post">	
		<input type="hidden" name="acao" id="acao" value="consultar">	
		<div class="card" >
		  <div class="card-header">
		    Escolha a Moto
		  </div>
		  <div class="card-body" >
		  		<div class="input-group input-group-sm mb-3">  
					<select class="form-select" aria-label="Default select example" name="select-moto">
					  <option selected>Escolha uma de suas motos</option>
					  <%
					  for (Moto moto : motos) {
						  
						  %><option value="<%=moto.getId()%>"><%=moto.getMarca()%> - <%=moto.getModelo()%></option>
						 <%  
						}
					  %>
					  
					</select>
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>				
				<a href="CadastrarMoto" class="btn btn-secondary" align="right">Novo</a>				
		  </div>
		</div>		
	</form>	  	

</section>	
<%@ include file="../templates/footer.jsp"%>  