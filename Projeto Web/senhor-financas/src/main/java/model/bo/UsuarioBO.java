package model.bo;

import java.util.ArrayList;

import model.dao.UsuarioDAO;
import model.vo.UsuarioVO;

public class UsuarioBO {

	public UsuarioVO realizarLoginBo(UsuarioVO usuarioVo) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		return usuarioDao.realizarLoginDAO(usuarioVo);
	}
	
	//Create
	public UsuarioVO cadastrarUsuarioBo (UsuarioVO usuarioVo) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDAO(usuarioVo)) {
			System.out.println("Usuário ja cadastrado!");
		}else {
			usuarioVo = usuarioDao.cadastrarUsuarioDAO(usuarioVo);
		}
		return usuarioVo;
	}
	
	//Read all
	public ArrayList<UsuarioVO> consultarTodosUsuariosBo () {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		ArrayList<UsuarioVO> listaUsuariosVo = usuarioDao.consultarTodosUsuariosDAO();
		if(listaUsuariosVo.isEmpty()) {
			System.out.println("Lista de Usuários está vazia!");
		}
		return listaUsuariosVo;
	}
	
	//Read one
	public UsuarioVO consultarUsuarioBo (UsuarioVO usuarioVo) {
		UsuarioDAO usuarioDao = new UsuarioDAO();
		UsuarioVO usuario = usuarioDao.consultarUsuarioDAO(usuarioVo);
		if(usuario == null) {
			System.out.println("\nUsuário não localizado!");
		}
		return usuario;
	}
	
	//Update
	public boolean atualizarUsuarioBo (UsuarioVO usuarioVo) {
		boolean resultado = false;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDAO(usuarioVo)) {
			resultado = usuarioDao.atualizarUsuarioDAO(usuarioVo);
		}else {
			System.out.println("usuario não existe");
		}
		return resultado;
	}
	
	//Delete
	public boolean excluirUsuarioBo(UsuarioVO usuarioVo) {
		boolean resultado = false;
		UsuarioDAO usuarioDao = new UsuarioDAO();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDAO(usuarioVo)) {
			resultado = usuarioDao.excluirUsuarioDAO(usuarioVo);
		}else {
			System.out.println("Usuario não existe na base de dados");
		}
		return resultado;

	}
}