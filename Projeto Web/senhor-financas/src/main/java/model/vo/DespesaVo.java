package model.vo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DespesaVo {
	
	private int idDespesa;
	private int idUsuario;
	private String descricao;
	private double valor;
	private LocalDate dataVencimento;
	private LocalDate dataPagamento;
	public DespesaVo(int idDespesa, int idUsuario, String descricao, double valor, LocalDate dataVencimento,
			LocalDate dataPagamento) {
		super();
		this.idDespesa = idDespesa;
		this.idUsuario = idUsuario;
		this.descricao = descricao;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}
	public DespesaVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdDespesa() {
		return idDespesa;
	}
	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
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
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	@Override
	public String toString() {
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return "Código da Despesa: " + this.getIdDespesa()
		+ "\nCódigo do Usuário: " + this.getIdUsuario()
		+ "\nDescrição: " + this.getDescricao()
		+ "\nValor: " + this.getValor()
		+ "\nData de Vencimento: " + this.getDataVencimento().format(formataData)
		+ "\nData de Pagamento: " + this.getDataPagamento().format(formataData);
	}
	
}
