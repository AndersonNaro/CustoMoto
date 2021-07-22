package net.sytes.scarranaro.da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sytes.scarranaro.vo.Moto;




public class DAMoto {
	
	
	
	public void adicionaMoto(Moto moto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = connection
	 				.prepareStatement("insert into moto( c_mc_mt, c_mdl_mt)values(?,?)");
	 		
	 		stmt.setString(1, moto.getMarca());
	 		stmt.setString(2, moto.getModelo()); 		
	 		stmt.execute();
	 		stmt.close();
		} finally {
			
	 		connection.close();
		}	
			
	 		
 	}
	
	public List<Moto> doUsuario(int user) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		Moto moto;
		ArrayList<Moto> motos = new ArrayList<Moto>();
		try {
			
			
			PreparedStatement stmt = connection
					.prepareStatement("select * from Moto A inner join Manut B on B.i_id_usr = ? "+
								" and B.i_id_mt = A.i_id_mt");
			stmt.setInt(1, user);		
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				moto = new Moto();
				moto.setId(rs.getInt("i_id_mt"));
				moto.setMarca(rs.getString("c_mc_mt"));
				moto.setModelo(rs.getString("c_mdl_mt"));
				motos.add(moto);
			}
			
			stmt.close();
		} finally {
			connection.close();
		}
		
 		
		
		return motos;
	}
	
	
   
	public int existe(String marca, String modelo) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		int id = 0;
		try {
			PreparedStatement stmt = connection
					.prepareStatement("select i_id_mt from Moto where c_mc_mt = ? and c_mdl_mt = ?");
			stmt.setString(1, marca);
			stmt.setString(2, modelo);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				id = rs.getInt("i_id_mt");
			}
			stmt.close();
		} finally {
			connection.close();
		}
		
 		
		return id;
	}
	
	public Moto modelo(int id) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		Moto moto = new Moto();
		moto.setId(id);
		try {
			PreparedStatement stmt = connection
					.prepareStatement("select * from Moto where i_id_mt = ?");
			stmt.setInt(1, id);			
			ResultSet rs = stmt.executeQuery();			
			while (rs.next()) {				
				moto.setMarca(rs.getString("c_mc_mt"));
				moto.setModelo(rs.getString("c_mdl_mt"));
			}
			stmt.close();
		} finally {
			connection.close();
		}	
 		
		return moto;
	}
}
