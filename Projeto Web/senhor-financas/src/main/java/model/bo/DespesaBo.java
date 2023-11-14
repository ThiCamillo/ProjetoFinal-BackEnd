package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDao;
import model.dao.ReceitaDao;
import model.vo.DespesaVo;
import model.vo.ReceitaVo;

public class DespesaBo {

	//Create
			public DespesaVo cadastrarDespesaBo (DespesaVo despesaVo) {
				DespesaDao despesaDao = new DespesaDao();
				if(despesaDao.verificarCadastroDespesaBaseDadosDao(despesaVo)) {
					System.out.println("Despesa ja cadastrado!");
				}else {
					despesaVo = despesaDao.cadastrarDespesaDao(despesaVo);
				}
				return despesaVo;
			}
			
			//Read all
			public ArrayList<DespesaVo> consultarTodasDespesasBo () {
				DespesaDao despesaDao = new DespesaDao();
				ArrayList<DespesaVo> listaDespesasVo = despesaDao.consultarTodasDespesasDao();
				if(listaDespesasVo.isEmpty()) {
					System.out.println("Lista de Despesa está vazia!");
				}
				return listaDespesasVo;
			}
			
			//Read one
			public DespesaVo consultarDespesaBo (DespesaVo despesaVo) {
				DespesaDao despesaDao = new DespesaDao();
				DespesaVo despesa = despesaDao.consultarDespesaDao(despesaVo);
				if(despesa == null) {
					System.out.println("\nDespesa não localizada!");
				}
				return despesa;
			}
			
			//Update
			public boolean atualizarDespesaBo (DespesaVo despesaVo) {
				boolean resultado = false;
				DespesaDao despesaDao = new DespesaDao();
				if(despesaDao.verificarCadastroDespesaBaseDadosDao(despesaVo)) {
					resultado = despesaDao.atualizarDespesaDao(despesaVo);
				}else {
					System.out.println("Despesa não existe");
				}
				return resultado;
			}
			
			//Delete
			public boolean excluirDespesaBo(DespesaVo despesaVo) {
				boolean resultado = false;
				DespesaDao despesaDao = new DespesaDao();
				if(despesaDao.verificarCadastroDespesaBaseDadosDao(despesaVo)) {
					resultado = despesaDao.excluirDespesaDao(despesaVo);
				}else {
					System.out.println("Despesa não existe na base de dados");
				}
				return resultado;

			}

}
