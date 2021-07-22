package net.sytes.scarranaro.vo;

public class Usuario {

	//create table USUARIO(i_id_usr integer auto_increment primary key, c_usr varchar(50), c_pss varchar(12));

	
	private int id;
	private String nome;
	private String pass;
	
	
	public Usuario() {		
		
	}
	
	public Usuario(String nome, String pass) {
		super();
		this.nome = nome;
		this.pass = pass;
	}
	
	
	


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	
}
