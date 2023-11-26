package controller;

import java.time.LocalDate;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.bo.ReceitaBO;
import model.vo.ReceitaVO;

@Path("/relatorio")
public class RelatorioRest {

//	@GET
//	@Path("/listar/{datareceita}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<ReceitaVO> consultarTodasReceitasController(@PathParam("datareceita") LocalDate dataReceita) {
//		ReceitaBO receitaBO = new ReceitaBO();
//		return receitaBO.consultarTodasReceitasBO(dataReceita);
//
//	}

}
