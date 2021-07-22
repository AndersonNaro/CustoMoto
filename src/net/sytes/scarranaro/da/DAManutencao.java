package net.sytes.scarranaro.da;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sytes.scarranaro.vo.Manutencao;


public class DAManutencao {
	
	

	public void adicionaManutencao(int id_usr, int id_mt, int km) throws SQLException{
		
		Connection connection = ConnectionFactory.getConnection();
		try {
			
			
	 		PreparedStatement stmt = connection
	 				.prepareStatement("insert into MANUT ( i_id_usr, i_id_mt , i_km_mnt ,d_dt_pr, f_vl_mnt)\r\n"
	 						+ "	values(\r\n"
	 						+ "		?,\r\n"
	 						+ "     ?,\r\n"
	 						+ "     ?,\r\n"
	 						+ "     CURDATE(),\r\n"
	 						+ "     0);");
	 		
	 		stmt.setInt(1, id_usr);
	 		stmt.setInt(2, id_mt);
	 		stmt.setInt(3, km);
	 		stmt.execute();
	 		stmt.close();
		} finally {
			connection.close();
		}
		
 		
 	}
	
	public void adicionaManutencao(int id_usr, int id_mt, int km, BigDecimal valor) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		try {
			PreparedStatement stmt = connection
	 				.prepareStatement("insert into MANUT ( i_id_usr, i_id_mt , i_km_mnt ,d_dt_pr, f_vl_mnt)\r\n"
	 						+ "	values(\r\n"
	 						+ "		?,\r\n"
	 						+ "     ?,\r\n"
	 						+ "     ?,\r\n"
	 						+ "     CURDATE(),\r\n"
	 						+ "     ?);");
	 		
	 		stmt.setInt(1, id_usr);
	 		stmt.setInt(2, id_mt);
	 		stmt.setInt(3, km);
	 		stmt.setBigDecimal(id_mt, null);
	 		stmt.execute();
	 		stmt.close();
		} finally {
			connection.close();
		}
	}
 		
	public List<Manutencao> ultimas(int user, int moto) throws SQLException{
		Connection connection = ConnectionFactory.getConnection();
		Manutencao manut;
		ArrayList<Manutencao> manutencoes = new ArrayList<Manutencao>();
		try {			
			PreparedStatement stmt = connection
					.prepareStatement("select * from Moto A inner join Manut B on B.i_id_usr = ?\r\n"
							+ "	and B.i_id_mt = A.i_id_mt and B.i_id_mt = ? "
							+ " order by d_dt_pr limit 2\r\n");
			stmt.setInt(1, user);
			stmt.setInt(2, moto);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				manut = new Manutencao();
				manut.setIdManut(rs.getInt("i_id_mnt"));
				manut.setIdUser(rs.getInt("i_id_usr"));
				manut.setIdMoto(rs.getInt("i_id_mt"));
				manut.setData(rs.getDate("d_dt_pr"));
				manut.setKm(rs.getInt("i_km_mnt"));
				manut.setValor(rs.getBigDecimal("f_vl_mnt"));
				
				manutencoes.add(manut);
			}
			
			stmt.close();
		} finally {
			connection.close();
		}		
		return manutencoes;
	}
	
	
}
