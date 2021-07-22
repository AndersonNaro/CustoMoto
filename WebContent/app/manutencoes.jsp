<%@ page import="java.util.List" %>
<%@ page import="net.sytes.scarranaro.vo.Moto" %>
<%@ page import="net.sytes.scarranaro.vo.Manutencao" %>
<%@ page import="net.sytes.scarranaro.da.DAManutencao" %>

<%@ include file="../templates/head.html" %> 
<section class="fundo">
	
	<%
	int id = (Integer) session.getAttribute("i_id_usr");
	DAManutencao da = new DAManutencao();
	Moto moto = (Moto) session.getAttribute("moto");
	List<Manutencao> manutencoes = da.ultimas(id, moto.getId()); 
	String marca;	
	
	%>
	
	<form action="MotoServlet" method="post">	
		<input type="hidden" name="acao" id="acao" value="consultar">	
		<div class="card" >
		  <div class="card-header">
		    <%=moto.getModelo() %>
		  </div>
		  <div class="card-body" >
		  		<div class="input-group input-group-sm mb-3">  
					<table class="table">						 
						  <thead>
						    <tr>
						      <th scope="col"></th>
						      <th scope="col">Odometro</th>
						      <th scope="col">Data</th>
						      <th scope="col">valor</th>
						      <th scope="col"></th>
						    </tr>
						  </thead>
						  <tbody>
						   
					  <%
					  for (Manutencao man : manutencoes) {
						  
						%>
						
							 <tr>
						      <th scope="row">*</th>
						      <td><%=man.getKm()%></td>
						      <td><%=man.getData()%></td>
						      <td><%=man.getValor()%></td>
						      <td>ver detalhes</td>
						    </tr>
						  
												 
						 <%  
						}
					  %>
					 </tbody>
					</table>
					
				</div>
				<button type="submit" class="btn btn-primary">Ok</button>				
				<a href="peças" class="btn btn-secondary" align="right">procurar por peça</a>				
		  </div>
		</div>		
	</form>	  
	

</section>	
<%@ include file="../templates/footer.jsp"%>