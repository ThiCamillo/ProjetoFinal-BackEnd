package model.bo;

import java.util.ArrayList;

import model.dao.DespesaDAO;
import model.dao.ReceitaDAO;
import model.vo.DespesaVO;
import model.vo.ReceitaVO;

public class DespesaBO {

	// Create -- CADASTRAR
	public DespesaVO cadastrarDespesaBO(DespesaVO despesaVO) {
		DespesaDAO despesaDAO = new DespesaDAO();
		if (despesaDAO.verificarCadastroDespesaBaseDadosDAO(despesaVO)) {
			System.out.println("Despesa ja cadastrado!");
		} else {
			despesaVO = despesaDAO.cadastrarDespesaDAO(despesaVO);
		}
		return despesaVO;
	}

	// Read all - LISTAR TODOS USUARIOS
	public ArrayList<DespesaVO> consultarTodasDespesasBO(int idUsuario) {
		DespesaDAO despesaDAO = new DespesaDAO();
		ArrayList<DespesaVO> listaDespesasVO = despesaDAO.consultarTodasDespesasDAO(idUsuario);
		if (listaDespesasVO.isEmpty()) {
			System.out.println("Lista de Despesa está vazia!");
		}
		return listaDespesasVO;
	}

	// Read one -- PESQUISAR
	public DespesaVO consultarDespesaBO(int idDespesa) {
		DespesaDAO despesaDAO = new DespesaDAO();
		DespesaVO despesa = despesaDAO.consultarDespesaDAO(idDespesa);
		if (despesa == null) {
			System.out.println("\nDespesa não localizada!");
		}
		return despesa;
	}

	// Update
	public boolean atualizarDespesaBO(DespesaVO despesaVO) {
		boolean resultado = false;
		DespesaDAO despesaDAO = new DespesaDAO();
		if (despesaDAO.verificarCadastroDespesaBaseDadosDAO(despesaVO)) {
			resultado = despesaDAO.atualizarDespesaDAO(despesaVO);
		} else {
			System.out.println("Despesa não existe");
		}
		return resultado;
	}

	// Delete
	public boolean excluirDespesaBO(DespesaVO despesaVO) {
		boolean resultado = false;
		DespesaDAO despesaDAO = new DespesaDAO();
		if (despesaDAO.verificarCadastroDespesaBaseDadosDAO(despesaVO)) {
			resultado = despesaDAO.excluirDespesaDAO(despesaVO);
		} else {
			System.out.println("Despesa não existe na base de dados");
		}
		return resultado;

	}
}
