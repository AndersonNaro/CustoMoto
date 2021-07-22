package net.sytes.scarranaro.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.sytes.scarranaro.vo.Usuario;

public class DAUsuario {
	
	private Connection connection;
	public DAUsuario() {
 		this.connection = ConnectionFactory.getConnection();
 	}

	public void adiciona(Usuario usuario) throws SQLException{
		//create table USUARIO(i_id_usr integer auto_increment primary key, c_usr varchar(50), c_pss varchar(12));

 		PreparedStatement stmt = this.connection
 				.prepareStatement("insert into USUARIO(c_usr, c_pss)values(?,?)");
 		
 		stmt.setString(1, usuario.getNome());
 		stmt.setString(2, usuario.getPass()); 		
 		stmt.execute();
 		stmt.close();
 		this.connection.close();
 	}
	
	public Usuario consulta(String nome, String pass) {
		
		Usuario u = new Usuario();
		try {
			PreparedStatement stmt = this.connection
				.prepareStatement("select i_id_usr, c_usr, c_pss from USUARIO where c_usr =? and c_pss = ?");
			stmt.setString(1, nome); 		
			stmt.setString(2, pass);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {;
				u.setId(rs.getInt("i_id_usr"));
				u.setNome(rs.getString("c_usr"));
				u.setPass(rs.getString("c_pss"));	
			}
		
		} catch (SQLException e) {			
			e.printStackTrace();
		} 	
				
		return u;
	}
	
}
