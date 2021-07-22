package net.sytes.scarranaro.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Manutencao {

	//i_id_usr, i_id_mt , i_km_mnt ,d_dt_pr, f_vl_mnt
	int idManut;
	int idUser;
	int idMoto;
	int km;
	Date data;
	
	
	BigDecimal valor;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdMoto() {
		return idMoto;
	}
	public void setIdMoto(int idMoto) {
		this.idMoto = idMoto;
	}
	public int getKm() {
		return km;
	}
	public void setKm(int km) {
		this.km = km;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public int getIdManut() {
		return idManut;
	}
	public void setIdManut(int idManut) {
		this.idManut = idManut;
	}
	
}
