package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.ReceitaVo;
import model.vo.UsuarioVo;

public class ReceitaDao {

	// INSERT
	public ReceitaVo cadastrarReceitaDao(ReceitaVo receitaVo) {
		String query = "INSERT INTO receita (idusuario, descricao, valor, datareceita) VALUES (?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setInt(1, receitaVo.getIdUsuario());
			pstmt.setString(2, receitaVo.getDescricao());
			pstmt.setDouble(3, receitaVo.getValor());
			pstmt.setObject(4, receitaVo.getDataReceita());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if (resultado.next()) {
				receitaVo.setIdReceita(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo cadastrarReceitaDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return receitaVo;
	}


	// UPDATE
	public boolean atualizarReceitaDao(ReceitaVo receitaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "UPDATE receita SET descricao = '" + receitaVo.getDescricao() + "', valor = '" + receitaVo.getValor() + "', datareceita = '" + receitaVo.getDataReceita()
				+ "WHERE idreceita = " + receitaVo.getIdReceita();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo atualizarReceitaDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	

	// DELETE
	public boolean excluirReceitaDao(ReceitaVo receitaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "DELETE FROM receita WHERE idreceita = " + receitaVo.getIdReceita();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo excluirReceitaDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}
	

	// READ ALL
	public ArrayList<ReceitaVo> consultarTodasReceitasDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ReceitaVo> listaReceitas = new ArrayList<ReceitaVo>();
		String query = "SELECT idreceita, idusuario, descricao, valor, datareceita FROM receita";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				ReceitaVo receita = new ReceitaVo();
				receita.setIdReceita(Integer.parseInt(resultado.getString(1)));
				receita.setIdUsuario(Integer.parseInt(resultado.getString(2)));
				receita.setDescricao(resultado.getString(3));
				receita.setValor(Double.parseDouble(resultado.getString(4)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(5)));
				listaReceitas.add(receita);
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarTodasReceitasDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaReceitas;
	}
	
	// READ ONE
	public ReceitaVo consultarReceitaDao(ReceitaVo receitaVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ReceitaVo usuario = new ReceitaVo();
		String query = "SELECT idusuario, descricao, valor, datareceita FROM receita" + " WHERE idreceita = "
				+ receitaVo.getIdReceita();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				receita.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				receita.setDescricao(resultado.getString(2));
				receita.setValor(Double.parseDouble(resultado.getString(3)));
				receita.setDataReceita(LocalDate.parse(resultado.getString(4)));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarReceitaDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuario;
	}
	
	
	

	public boolean verificarCadastroReceitaBaseDadosDao(ReceitaVo receitaVo) {
		// TODO Auto-generated method stub
		return false;
	}

}
