package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.DespesaVO;
import model.vo.ReceitaVO;

public class DespesaDAO {

	// VERIFICAR
	public boolean verificarCadastroDespesaBaseDadosDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT iddespesa FROM despesa WHERE iddespesa = ' " + despesaVO.getIdDespesa() + " ' ";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo verificarCadastroDespesaBaseDadosDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	// INSERT - CADASTRAR
	public DespesaVO cadastrarDespesaDAO(DespesaVO despesaVO) {
		String query = "INSERT INTO despesa (idusuario, descricao, valor, datavencimento, datapagamento) VALUES (?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, despesaVO.getIdUsuario());
			pstmt.setString(2, despesaVO.getDescricao());
			pstmt.setDouble(3, despesaVO.getValor());
			pstmt.setObject(4, despesaVO.getDataVencimento());
			pstmt.setObject(5, despesaVO.getDataPagamento());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if (resultado.next()) {
				despesaVO.setIdDespesa(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo cadastrarDespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return despesaVO;
	}

	// READ ALL -- LISTAR TODAS DESPESAS
	public ArrayList<DespesaVO> consultarTodasDespesasDAO(int idUsuario) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;

		ArrayList<DespesaVO> listaDespesas = new ArrayList<DespesaVO>();
		String query = "SELECT iddespesa, idusuario, descricao, valor, datavencimento, datapagamento FROM despesa WHERE idusuario = "
				+ idUsuario;
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				DespesaVO despesa = new DespesaVO();
				despesa.setIdDespesa(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5)));
				despesa.setDataPagamento(LocalDate.parse(resultado.getString(6)));
				listaDespesas.add(despesa);
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarTodasDespesasDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaDespesas;
	}

	// READ ONE -- PESQUISAR UMA DESPESA
	public DespesaVO consultarDespesaDAO(int idDespesa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;

		DespesaVO despesa = new DespesaVO();
		String query = "SELECT iddespesa, idusuario, descricao, valor, datavencimento, datapagamento FROM despesa WHERE iddespesa = "
				+ idDespesa;
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				despesa.setIdDespesa(Integer.parseInt(resultado.getString(1)));
				despesa.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				despesa.setDescricao(resultado.getString(3));
				despesa.setValor(Double.parseDouble(resultado.getString(4)));
				despesa.setDataVencimento(LocalDate.parse(resultado.getString(5)));
				despesa.setDataPagamento(LocalDate.parse(resultado.getString(6)));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarDespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return despesa;
	}

	// UPDATE --ATUALIZAR
	public boolean atualizarDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "UPDATE despesa SET descricao = '" + despesaVO.getDescricao() + "', valor = '"
				+ despesaVO.getValor() + "', datavencimento = '" + despesaVO.getDataVencimento()
				+ " ', dataPagamento = '" + despesaVO.getDataPagamento() + "WHERE iddespesa = "
				+ despesaVO.getIdDespesa();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo atualizarDespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	// DELETE --EXCLUIR
	public boolean excluirDespesaDAO(DespesaVO despesaVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "DELETE FROM despesa WHERE iddespesa = " + despesaVO.getIdDespesa();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo excluirDespesaDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
}
