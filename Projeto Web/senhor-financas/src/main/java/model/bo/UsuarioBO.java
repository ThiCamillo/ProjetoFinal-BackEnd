package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public UsuarioVO realizarLoginBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		return usuarioDAO.realizarLoginDAO(usuarioVO);
	}

	// Create - CADASTRAR
	public UsuarioVO cadastrarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarCadastroUsuarioBaseDadosDAO(usuarioVO)) {
			System.out.println("Usuário ja cadastrado!");
		} else {
			usuarioVO = usuarioDAO.cadastrarUsuarioDAO(usuarioVO);
		}
		return usuarioVO;
	}

	// Read all
	public ArrayList<UsuarioVO> consultarTodosUsuariosBO() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuariosVO = usuarioDAO.consultarTodosUsuariosDAO();
		if (listaUsuariosVO.isEmpty()) {
			System.out.println("Lista de Usuários está vazia!");
		}
		return listaUsuariosVO;
	}

	// Read one
	public UsuarioVO consultarUsuarioBO(UsuarioVO usuarioVO) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		UsuarioVO usuario = usuarioDAO.consultarUsuarioDAO(usuarioVO);
		if (usuario == null) {
			System.out.println("\nUsuário não localizado!");
		}
		return usuario;
	}

	// Update
	public boolean atualizarUsuarioBO(UsuarioVO usuarioVO) {
		boolean resultado = false;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarCadastroUsuarioBaseDadosDAO(usuarioVO)) {
			resultado = usuarioDAO.atualizarUsuarioDAO(usuarioVO);
		} else {
			System.out.println("usuario não existe");
		}
		return resultado;
	}

	// Delete
	public boolean excluirUsuarioBO(UsuarioVO usuarioVO) {
		boolean resultado = false;
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		if (usuarioDAO.verificarCadastroUsuarioBaseDadosDAO(usuarioVO)) {
			resultado = usuarioDAO.excluirUsuarioDAO(usuarioVO);
		} else {
			System.out.println("Usuario não existe na base de dados");
		}
		return resultado;
	}
}