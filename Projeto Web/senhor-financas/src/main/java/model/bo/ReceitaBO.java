package model.bo;

import java.util.ArrayList;

import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;


public class ReceitaBO {

	//Create - CADASTRAR
		public ReceitaVO cadastrarReceitaBO (ReceitaVO receitaVO) {
			ReceitaDAO receitaDAO = new ReceitaDAO();
			if(receitaDAO.verificarCadastroReceitaBaseDadosDAO(receitaVO)) {
				System.out.println("receita ja cadastrada!");
			}else {
				receitaVO = receitaDAO.cadastrarReceitaDAO(receitaVO);
			}
			return receitaVO;
		}
		
		//Read all - LISTAR TODOS USUARIOS
		public ArrayList<ReceitaVO> consultarTodasReceitasBO (int idUsuario) {
			ReceitaDAO receitaDAO = new ReceitaDAO();
			ArrayList<ReceitaVO> listaReceitasVO = receitaDAO.consultarTodasReceitasDAO(idUsuario);
			if(listaReceitasVO.isEmpty()) {
				System.out.println("Lista de Receita está vazia!");
			}
			return listaReceitasVO;
		}
		
		//Read one - PESQUISAR POR RECEITA
		public ReceitaVO consultarReceitaBO (int idReceita) {
			ReceitaDAO receitaDAO = new ReceitaDAO();
			ReceitaVO receita = receitaDAO.consultarReceitaDAO(idReceita);
			if(receita == null) {
				System.out.println("\nReceita não localizada!");
			}
			return receita;
		}
		
		//Update
		public boolean atualizarReceitaBO (ReceitaVO receitaVO) {
			boolean resultado = false;
			ReceitaDAO receitaDAO = new ReceitaDAO();
			if(receitaDAO.verificarCadastroReceitaBaseDadosDAO(receitaVO)) {
				resultado = receitaDAO.atualizarReceitaDAO(receitaVO);
			}else {
				System.out.println("Receita não existe");
			}
			return resultado;
		}
		
		//Delete
		public boolean excluirReceitaBO(ReceitaVO receitaVo) {
			boolean resultado = false;
			ReceitaDAO receitaDao = new ReceitaDAO();
			if(receitaDao.verificarCadastroReceitaBaseDadosDAO(receitaVo)) {
				resultado = receitaDao.excluirReceitaDAO(receitaVo);
			}else {
				System.out.println("Receita não existe na base de dados");
			}
			return resultado;

		}

}
