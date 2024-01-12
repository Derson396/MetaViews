package model;

public class Usuario {
	private int idU,idade;
	private String email,senha,nome;
	public Usuario(int id, String email,int idade,String senha,String nome){
		setId(idU);
		setIdade(idade);
		setEmail(email);
		setSenha(senha);
		setNome(nome);
	}
	public int getId() {
		return idU;
	}
	public void setId(int id) {
		this.idU = id;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
