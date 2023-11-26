package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.dao.ReceitaDAO;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;

public class DespesaBO {

	//Create
			public DespesaVO cadastrarDespesaBo (DespesaVO despesaVo) {
				DespesaDAO despesaDao = new DespesaDAO();
				if(despesaDao.verificarCadastroDespesaBaseDadosDAO(despesaVo)) {
					System.out.println("Despesa ja cadastrado!");
				}else {
					despesaVo = despesaDao.cadastrarDespesaDao(despesaVo);
				}
				return despesaVo;
			}
			
			//Read all
			public ArrayList<DespesaVO> consultarTodasDespesasBo () {
				DespesaDAO despesaDao = new DespesaDAO();
				ArrayList<DespesaVO> listaDespesasVo = despesaDao.consultarTodasDespesasDao();
				if(listaDespesasVo.isEmpty()) {
					System.out.println("Lista de Despesa está vazia!");
				}
				return listaDespesasVo;
			}
			
			//Read one
			public DespesaVO consultarDespesaBo (DespesaVO despesaVo) {
				DespesaDAO despesaDao = new DespesaDAO();
				DespesaVO despesa = despesaDao.consultarDespesaDao(despesaVo);
				if(despesa == null) {
					System.out.println("\nDespesa não localizada!");
				}
				return despesa;
			}
			
			//Update
			public boolean atualizarDespesaBo (DespesaVO despesaVo) {
				boolean resultado = false;
				DespesaDAO despesaDao = new DespesaDAO();
				if(despesaDao.verificarCadastroDespesaBaseDadosDAO(despesaVo)) {
					resultado = despesaDao.atualizarDespesaDao(despesaVo);
				}else {
					System.out.println("Despesa não existe");
				}
				return resultado;
			}
			
			//Delete
			public boolean excluirDespesaBo(DespesaVO despesaVo) {
				boolean resultado = false;
				DespesaDAO despesaDao = new DespesaDAO();
				if(despesaDao.verificarCadastroDespesaBaseDadosDAO(despesaVo)) {
					resultado = despesaDao.excluirDespesaDao(despesaVo);
				}else {
					System.out.println("Despesa não existe na base de dados");
				}
				return resultado;

			}

}
