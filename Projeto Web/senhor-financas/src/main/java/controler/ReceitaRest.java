package controler;

import java.util.List;

import org.eclipse.persistence.oxm.MediaType;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import model.bo.ReceitaBo;
import model.vo.ReceitaVo;

@Path("/receita")
public class ReceitaRest {
	
	@POST //algo que nao existe insert
	@Path("/cadastrar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReceitaVo cadastarReceitaController(ReceitaVo receitaVo) {
		ReceitaBo receitaBo = new ReceitaBo();
		return receitaBo.cadastrarReceitaBo(receitaVo);
	}
	
	@GET
	@Path("/listar/{idusuario}")
	//@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<ReceitaVo> consultarTodasReceitasController(@PathParam("idusuario") int idUsuario) {
		ReceitaBo receitaBo = new ReceitaBo();
		return receitaBo.consultarTodasReceitasBo(idUsuario);
	}

	@GET
	@Path("/pesquisar/{idreceita}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ReceitaVo consultarReceitaController(@PathParam("idreceita") int idReceita) {
		ReceitaBo receitaBo = new ReceitaBo();
		return receitaBo.consultarReceitaBo(idReceita);

	}

	@PUT
	@Path("/atualizar")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean atualizarReceitaController(ReceitaVo receitaVo) {
		ReceitaBo receitaBo = new ReceitaBo();
		return receitaBo.atualizarReceitaBo(receitaVo);
	}

	@DELETE
	@Path("/excluir")
	@Consumes(MediaType.APPLICATION_JSON)
	//@Produces(MediaType.APPLICATION_JSON)
	public Boolean excluirReceitaController(ReceitaVo receitaVo) {
		ReceitaBo receitaBo = new ReceitaBo();
		return receitaBo.excluirReceitaBo(receitaVo);
	}
	
	
}
