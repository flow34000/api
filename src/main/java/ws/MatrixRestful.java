package ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.MatrixModel;
import domain.Matrix;

@Path("genes")
public class MatrixRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() throws IllegalArgumentException, Exception {
		MatrixModel mm = new MatrixModel();
		return Response.ok().entity(new GenericEntity<List<Matrix>>(mm.findAll()){})
			.build();
	}
}
