package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import model.vo.UsuarioVo;

public class UsuarioDao {

	public UsuarioVo realizarLoginDao(UsuarioVo usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;

		String query = "SELECT idusuario, nome, cpf, email, " + "datanascimento" + "FROM usuario"
				+ " WHERE login like '" + usuarioVo.getLogin() + "'" + " AND senha like '" + usuarioVo.getSenha() + "'";

		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				usuarioVo.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuarioVo.setNome(resultado.getString(2));
				usuarioVo.setCpf(resultado.getString(3));
				usuarioVo.setEmail(resultado.getString(4));
				usuarioVo.setDataNascimento(LocalDateTime.parse(resultado.getString(5), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao executar a query no método realizarLoginDAO!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return usuarioVo;
	}

	// INSERT
	public boolean verificarCadastroUsuarioBaseDadosDao(UsuarioVo usuarioVo) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT cpf FROM usuario WHERE cpf = ' " + usuarioVo.getCpf() + " ' ";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				retorno = true;
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo verificarCadastroUsuarioBaseDadosDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;
	}

	public UsuarioVo cadastrarUsuarioDao(UsuarioVo usuarioVo) {
		String query = "INSERT INTO usuario (nome, cpf, email, datanascimento, login, senha) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setString(1, usuarioVo.getNome());
			pstmt.setString(2, usuarioVo.getCpf());
			pstmt.setString(3, usuarioVo.getEmail());
			pstmt.setObject(4, usuarioVo.getDataNascimento());
			pstmt.setString(5, usuarioVo.getLogin());
			pstmt.setString(6, usuarioVo.getSenha());
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			if (resultado.next()) {
				usuarioVo.setIdUsuario(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("\nErro ao executar a query do metodo cadastrarUsuarioDao!");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return usuarioVo;
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
				usuario.setDataNascimento(LocalDateTime.parse(resultado.getString(5),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
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
		String query = "SELECT idusuario, nome, cpf, email, datanascimento FROM usuario" + "WHERE idusuario = "
				+ usuarioVo.getIdUsuario();
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				usuario.setIdUsuario(Integer.parseInt(resultado.getString(1)));
				usuario.setNome(resultado.getString(2));
				usuario.setCpf(resultado.getString(3));
				usuario.setEmail(resultado.getString(4));
				usuario.setDataNascimento(LocalDateTime.parse(resultado.getString(5), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
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

}
