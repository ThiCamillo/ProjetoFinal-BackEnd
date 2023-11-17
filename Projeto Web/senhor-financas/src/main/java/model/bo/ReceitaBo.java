package model.bo;

import java.util.ArrayList;
import java.util.List;

import model.dao.ReceitaDao;
import model.vo.ReceitaVo;


public class ReceitaBo {

	//Create
		public ReceitaVo cadastrarReceitaBo (ReceitaVo receitaVo) {
			ReceitaDao receitaDao = new ReceitaDao();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				System.out.println("receita ja cadastrado!");
			}else {
				receitaVo = receitaDao.cadastrarReceitaDao(receitaVo);
			}
			return receitaVo;
		}
		
		//Read all
		public ArrayList<ReceitaVo> consultarTodasReceitasBo (int receitaVo) {
			ReceitaDao receitaDao = new ReceitaDao();
			ArrayList<ReceitaVo> listaReceitasVo = receitaDao.consultarTodasReceitasDao();
			if(listaReceitasVo.isEmpty()) {
				System.out.println("Lista de Receita está vazia!");
			}
			return listaReceitasVo;
		}
		
		//Read one
		public ReceitaVo consultarReceitaBo (int receitaVo) {
			ReceitaDao receitaDao = new ReceitaDao();
			ReceitaVo receita = receitaDao.consultarReceitaDao(receitaVo);
			if(receita == null) {
				System.out.println("\nReceita não localizada!");
			}
			return receita;
		}
		
		//Update
		public boolean atualizarReceitaBo (ReceitaVo receitaVo) {
			boolean resultado = false;
			ReceitaDao receitaDao = new ReceitaDao();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				resultado = receitaDao.atualizarReceitaDao(receitaVo);
			}else {
				System.out.println("Receita não existe");
			}
			return resultado;
		}
		
		//Delete
		public boolean excluirReceitaBo(ReceitaVo receitaVo) {
			boolean resultado = false;
			ReceitaDao receitaDao = new ReceitaDao();
			if(receitaDao.verificarCadastroReceitaBaseDadosDao(receitaVo)) {
				resultado = receitaDao.excluirReceitaDao(receitaVo);
			}else {
				System.out.println("Receita não existe na base de dados");
			}
			return resultado;

		}

}
