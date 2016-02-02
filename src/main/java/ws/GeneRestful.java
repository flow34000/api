package ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.GeneModel;
import domain.Gene;

@Path("genes")
public class GeneRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() throws IllegalArgumentException, Exception {
		GeneModel gm = new GeneModel();
		return Response.ok().entity(new GenericEntity<List<Gene>>(gm.findAll()){})
			.build();
	}
}
