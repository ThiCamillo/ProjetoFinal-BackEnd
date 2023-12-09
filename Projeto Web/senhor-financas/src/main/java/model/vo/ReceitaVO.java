package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ReceitaVO {

	private int idReceita;
	private int idUsuario;
	private String descricao;
	private double valor;
	private LocalDate dataReceita;
	public ReceitaVO(int idReceita, int idUsuario, String descricao, double valor, LocalDate dataReceita) {
		super();
		this.idReceita = idReceita;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.valor = valor;
		this.dataReceita = dataReceita;
	}
	public ReceitaVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdReceita() {
		return idReceita;
	}
	public void setIdReceita(int idReceita) {
		this.idReceita = idReceita;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getDataReceita() {
		return dataReceita;
	}
	public void setDataReceita(LocalDate dataReceita) {
		this.dataReceita = dataReceita;
	}
//	@Override
//	public String toString() {
//		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		return "Código da Receita: " + this.getIdReceita()
//				+ "\nCódigo do Usuário: " + this.getIdUsuario()
//				+ "\nDescrição: " + this.getDescricao()
//				+ "\nValor: " + this.getValor()
//				+ "\nData: " + this.getDataReceita().format(formataData);
//	}
	
}
