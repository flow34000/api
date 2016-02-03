package ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.MatrixModel;
import model.PatientModel;
import domain.Matrix;
import domain.Patient;

@Path("matrices/{matrix_id}")
public class MatrixRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientById(@PathParam("matrix_id") Short matrix_id) throws Exception {
		MatrixModel mm = new MatrixModel();
		Matrix m = mm.get(matrix_id);
		Response rep = Response.ok().entity(
					new GenericEntity<Matrix>(m){}
				)
					.build();
		return rep;
	}
}
