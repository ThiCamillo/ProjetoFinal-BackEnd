package model.bo;

import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

public class UsuarioBo {

	public UsuarioVo realizarLoginBo(UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.realizarLoginDao(usuarioVo);
	}
	
	//Create
	public UsuarioVo cadastrarUsuarioBo (UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuarioVo)) {
			System.out.println("Usuário ja cadastrado!");
		}else {
			usuarioVo = usuarioDao.cadastrarUsuarioDao(usuarioVo);
		}
		return usuarioVo;
	}
	
	//Read
	
	
	//Read
	
	
	//Update
	public boolean atualizarUsuarioBo (UsuarioVo usuarioVo) {
		boolean resultado = false;
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuarioVo)) {
			resultado = usuarioDao.atualizarUsuarioDao(usuarioVo);
		}else {
			System.out.println("usuario não existe");
		}
		return resultado;
	}
	
	//Delete
	public boolean excluirUsuarioBo(UsuarioVo usuarioVo) {
		boolean resultado = false;
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuarioVo)) {
			resultado = usuarioDao.excluirUsuarioDao(usuarioVo);
		}else {
			System.out.println("Usuario não existe na base de dados");
		}
		return resultado;

	}
}