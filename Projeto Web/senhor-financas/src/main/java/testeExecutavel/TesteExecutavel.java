package testeExecutavel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import model.bo.UsuarioBo;
import model.vo.UsuarioVo;

public class TesteExecutavel {

public static void main(String[] args) {
	
	//USUARIO//
	UsuarioBo usuarioBo = new UsuarioBo();
	
//	System.out.println("\n--------cadastrar usuario---------------\n");
//	UsuarioVo user1 = new UsuarioVo(0,"Clara","12312312313","email@email.com",LocalDate.of(2020,12,03), "clara", "clara");
//	user1 = usuarioBo.cadastrarUsuarioBo(user1);
//	System.out.println(user1.getIdUsuario() > 0 ? "Usuário cadastrado com sucesso!" : "Houve um problema no cadastro");
//	System.out.println("\n-----------------------\n");
//	
//	System.out.println("\n--------cadastrar CPF nulo (validado pelo banco)---------------\n");
//	UsuarioVo user1 = new UsuarioVo(0,"igor",null,"email@email.com",LocalDate.of(2019,02,02), "igor", "igor");
//	user1 = usuarioBo.cadastrarUsuarioBo(user1);
//	System.out.println(user1.getIdUsuario() > 0 ? "Usuário cadastrado com sucesso!" : "Houve um problema no cadastro");
//	System.out.println("\n-----------------------\n");
	
	
//	System.out.println("\n--------atualizar cadastro---------------\n");
//	UsuarioVo user2 = new UsuarioVo(5,"","","",null, "", "");
//	user2 = usuarioBo.consultarUsuarioBo(user2);
//	user2.setCpf("12345678999");
//	boolean resultado = usuarioBo.atualizarUsuarioBo(user2);
//	System.out.println(resultado ? "Usuário atualizado com sucesso!" : "Houve um problema na atualização");
//	System.out.println("\n-----------------------\n");
	
	System.out.println("\n--------excluir cadastro---------------\n");
	UsuarioVo user4 = new UsuarioVo(6,"","","",null, "", "");
	user4 = usuarioBo.consultarUsuarioBo(user4);
	boolean resultado = usuarioBo.excluirUsuarioBo(user4);
	System.out.println(resultado ? "Usuário excluído com sucesso!" : "Houve um problema na exclusão");
	System.out.println("\n-----------------------\n");
	
	
	System.out.println("\n--------consultar um usuario existente---------------\n");
	UsuarioVo user3 = new UsuarioVo(5, "", "", "", null, "", "");
	user3 = usuarioBo.consultarUsuarioBo(user3);
	if(user3.getCpf() != null) {
		System.out.println(user3);
	}else {
		System.out.println("Usuario não localizado");
	}
	System.out.println("\n-----------------------\n");
	
	
	System.out.println("\n----------consultar todos os usuários-------------\n");
	ArrayList<UsuarioVo> lista = usuarioBo.consultarTodosUsuariosBo();
	if(lista.isEmpty()) {
		System.out.println("Não existem usuários cadastrados");
	}else {
		System.out.println("\n Lista de usuários: \n");
		for(UsuarioVo u: lista) {
			System.out.println(u + "\n");
		}
	}
}

}
