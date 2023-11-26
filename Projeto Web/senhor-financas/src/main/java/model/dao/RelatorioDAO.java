package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.vo.ReceitaVO;

public class RelatorioDAO {

//	// READ ALL -- LISTAR TODAS RECEITAS E DESPESAS POR ANO
//		public ArrayList<ReceitaVO> consultarTodasReceitasDAO(int idUsuario) {
//			Connection conn = Banco.getConnection();
//			Statement stmt = Banco.getStatement(conn);
//			ResultSet resultado = null;
//			ArrayList<ReceitaVO> listaReceitas = new ArrayList<ReceitaVO>();
//			String query = "SELECT idreceita, idusuario, descricao, valor, datareceita FROM receita WHERE idusuario = "
//					+ idUsuario;
//			try {
//				resultado = stmt.executeQuery(query);
//				while (resultado.next()) {
//					ReceitaVO receita = new ReceitaVO();
//					receita.setIdReceita(Integer.parseInt(resultado.getString(1)));
//					receita.setIdUsuario(Integer.parseInt(resultado.getString(2)));
//					receita.setDescricao(resultado.getString(3));
//					receita.setValor(Double.parseDouble(resultado.getString(4)));
//					receita.setDataReceita(LocalDate.parse(resultado.getString(5)));
//					listaReceitas.add(receita);
//				}
//			} catch (SQLException erro) {
//				System.out.println("\nErro ao executar a query do metodo consultarTodasReceitasDao!");
//				System.out.println("Erro: " + erro.getMessage());
//			} finally {
//				Banco.closeResultSet(resultado);
//				Banco.closeStatement(stmt);
//				Banco.closeConnection(conn);
//			}
//			return listaReceitas;
//		}

}
