package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.ReceitaVo;

public class ReceitaDao {

	// INSERT
	public ReceitaVo cadastrarReceitaDao1(ReceitaVo receitaVo) {
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
	public boolean atualizarUsuarioDao(UsuarioVo usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "UPDATE usuario SET nome = '" + usuarioVo.getNome() + "', cpf = '" + usuarioVo.getCpf()
				+ "', email = '" + usuarioVo.getEmail() + "', datanascimento = '" + usuarioVo.getDataNascimento()
				+ "', login = '" + usuarioVo.getLogin() + "', senha = '" + usuarioVo.getSenha() + "WHERE idusuario = "
				+ usuarioVo.getIdUsuario();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo atualizarUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	// DELETE
	public boolean excluirUsuarioDao(UsuarioVo usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean retorno = false;
		String query = "DELETE FROM usuario WHERE idusuario = " + usuarioVo.getIdUsuario();
		try {
			if (stmt.executeUpdate(query) == 1) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo excluirUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	// READ ALL
	
	
	public ArrayList<UsuarioVo> consultarTodosUsuariosDao() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<UsuarioVo> listaUsuarios = new ArrayList<UsuarioVo>();
		String query = "SELECT idusuario, nome, cpf, email, datanascimento FROM usuario";
		try {
			resultado = stmt.executeQuery(query);
			while (resultado.next()) {
				UsuarioVo usuario = new UsuarioVo();
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setEmail(resultado.getString(4));
				usuario.setDataNascimento(LocalDate.parse(resultado.getString(5)));
				listaUsuarios.add(usuario);
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarTodosUsuariosDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaUsuarios;
	}

	// READ ONE
	public UsuarioVo consultarUsuarioDao(UsuarioVo usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		UsuarioVo usuario = new UsuarioVo();
		String query = "SELECT idusuario, nome, cpf, email, datanascimento FROM usuario" + " WHERE idusuario = "
				+ usuarioVo.getIdUsuario();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setEmail(resultado.getString(4));
				usuario.setDataNascimento(LocalDate.parse(resultado.getString(5)));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo consultarUsuarioDao!");
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

	public ReceitaVo cadastrarReceitaDao(ReceitaVo receitaVo) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<ReceitaVo> consultarTodasReceitasDao() {
		// TODO Auto-generated method stub
		return null;
	}

	public ReceitaVo consultarReceitaDao(ReceitaVo receitaVo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean atualizarReceitaDao(ReceitaVo receitaVo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean excluirReceitaDao(ReceitaVo receitaVo) {
		// TODO Auto-generated method stub
		return false;
	}

}
