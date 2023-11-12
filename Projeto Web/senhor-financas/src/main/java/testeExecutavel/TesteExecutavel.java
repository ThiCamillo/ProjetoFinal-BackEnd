package testeExecutavel;

import java.util.ArrayList;
import java.util.Scanner;

import model.bo.UsuarioBo;
import model.vo.UsuarioVo;

public class TesteExecutavel {

	
public static void main(String[] args) {
	//Scanner teclado= new Scanner(System.in);

	//consultar um usuario
//	UsuarioVo u1 = new UsuarioVo(1,"","","",null, "", null);
//	u1 = UsuarioBo.consultarUsuarioBo(u1);
//	
	//consultar todos usuarios
	ArrayList<UsuarioVo> lista = UsuarioBo.consultarTodosUsuariosBo();
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
