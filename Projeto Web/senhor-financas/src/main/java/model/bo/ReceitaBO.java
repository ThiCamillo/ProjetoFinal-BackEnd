package model.bo;

import java.util.ArrayList;

import model.dao.ReceitaDAO;
import model.vo.ReceitaVO;


public class ReceitaBO {

	//Create - CADASTRAR
		public ReceitaVO cadastrarReceitaBo (ReceitaVO receitaVO) {
			ReceitaDAO receitaDAO = new ReceitaDAO();
			if(receitaDAO.verificarCadastroReceitaBaseDadosDao(receitaVO)) {
				System.out.println("receita ja cadastrada!");
			}else {
				receitaVO = receitaDAO.cadastrarReceitaDao(receitaVO);
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
		public boolean atualizarReceitaBo (ReceitaVO receitaVo) {
			boolean resultado = false;
			ReceitaDAO receitaDao = new ReceitaDAO();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				resultado = receitaDao.atualizarReceitaDao(receitaVo);
			}else {
				System.out.println("Receita não existe");
			}
			return resultado;
		}
		
		//Delete
		public boolean excluirReceitaBo(ReceitaVO receitaVo) {
			boolean resultado = false;
			ReceitaDAO receitaDao = new ReceitaDAO();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				resultado = receitaDao.excluirReceitaDao(receitaVo);
			}else {
				System.out.println("Receita não existe na base de dados");
			}
			return resultado;

		}

}
