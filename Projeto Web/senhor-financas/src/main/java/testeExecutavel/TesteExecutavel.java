package testeExecutavel;

import model.bo.UsuarioBo;
import model.vo.UsuarioVo;

public class TesteExecutavel {

	
public static void main(String[] args) {
		
		UsuarioBo usuarioBo = new UsuarioBo();
		
		UsuarioVo u1 = new UsuarioVo();
		u1 = usuarioBo.consultarUsuarioBo(u1);
		if(u1.getCpf() != null) {
			System.out.println(u1);
		}else {
			System.out.println("\nUsuário não localizado!");
		}
		
	}

}
