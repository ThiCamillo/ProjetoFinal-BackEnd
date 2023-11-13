package testeExecutavel;

import java.util.ArrayList;
import java.util.Scanner;

import model.bo.UsuarioBo;
import model.vo.UsuarioVo;

public class TesteExecutavel {

public static void main(String[] args) {
	//Scanner teclado= new Scanner(System.in);

	//USUARIO//
	UsuarioBo usuarioBo = new UsuarioBo();
	
	//cadastrar usuario
//	UsuarioVo user1 = new UsuarioVo(0,"Maria","12312312312","email@email.com",null, "maria", null);
//	user1 = usuarioBo.cadastrarUsuarioBo(user1);
//	System.out.println(user1.getIdUsuario() > 0 ? "Usuário cadastrado com sucesso!" : "Houve um problema no cadastro");
//	
//	System.out.println("\n-----------------------\n");
//	
//	//consultar um usuario existente
//	UsuarioVo user3 = new UsuarioVo(1,"","","",null, "", null);
//	user3 = usuarioBo.consultarUsuarioBo(user3);
//	if(user3.getCpf() != null) {
//		System.out.println(user3);
//	}else {
//		System.out.println("Não Usuario não localizado");
//	}
//	
//	//consultar um usuario inexistente
//		UsuarioVo user2 = new UsuarioVo(100,"","","",null, "", null);
//		user2 = usuarioBo.consultarUsuarioBo(user2);
//		if(user2.getCpf() != null) {
//			System.out.println(user2);
//		}else {
//			System.out.println("Usuario não localizado na base de dados");
//		}
		
	//consultar todos usuarios
	ArrayList<UsuarioVo> lista = new ArrayList<UsuarioVo>();
	if(lista.isEmpty()) {
		System.out.println("tem nada");
	}else {
		System.out.println("olha ae");
		for(UsuarioVo u: lista) {
			System.out.println(u + "\n");
		}
	}
}

}
