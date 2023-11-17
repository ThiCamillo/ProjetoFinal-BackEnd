package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsuarioVo {

	private int idUsuario;
	private String nome;
	private String cpf;
	private String email;
	private LocalDate dataNascimento;
	private String login;
	private String senha;
	
	public UsuarioVo(int idUsuario, String nome, String cpf, String email, LocalDate dataNascimento, String login,
			String senha) {
		super();
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.login = login;
		this.senha = senha;
	}

	public UsuarioVo() {
		super();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Código do Usuario: " + this.getIdUsuario() 
		+ "\nNome: " + this.getNome() 
		+ "\nCPF: " + this.getCpf() 
		+ "\nEmail: " + this.getEmail()
		+ "\nData Nascimento: " + this.getDataNascimento().format(formataData)
		+ "\nLogin: " + this.getLogin()
		+ "\nSenha: " + this.getSenha();
	}
	
//	private String validarData(LocalDate data) {
//		String resultado = "";
//		if(data != null) {
//			resultado = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		}
//		return resultado;
//	}
	
}
