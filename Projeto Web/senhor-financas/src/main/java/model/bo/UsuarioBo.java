package model.bo;

import model.dao.UsuarioDao;
import model.vo.UsuarioVo;

public class UsuarioBo {

	public UsuarioVo realizarLoginBo(UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		return usuarioDao.realizarLoginDao(usuarioVo);
	}
	
	public UsuarioVo cadastrarUsuarioBo (UsuarioVo usuarioVo) {
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroUsuarioBaseDadosDao(usuarioVo)) {
			System.out.println("Usuário ja cadastrado!");
		}else {
			usuarioVo = usuarioDao.cadastrarUsuarioDao(usuarioVo);
		}
		return usuarioVo;
	}
	
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
	
	
	public boolean excluirUsuarioBo(UsuarioVo usuarioVo) {
		boolean resultado = false;
		UsuarioDao usuarioDao = new UsuarioDao();
		if(usuarioDao.verificarCadastroPorCpfDao(usuarioVo)))) {
			System.out.println("Usuario se encontra desligado do banco de dados");
		}else {
			resultado = usuarioDao.excluirUsuarioDao(usuarioVo);
		}
	}else {
		System.out.println("usuario nao existe no banco de dados");
	}
	
}
