package ws;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.ComptageModel;
import model.PatientModel;
import domain.Comptage;
import domain.JSONMatrix;
import domain.Patient;

@Path("comptages")
public class ComptageRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() throws IllegalArgumentException, Exception {
		ComptageModel gm = new ComptageModel();
		return Response.ok().entity(new GenericEntity<List<Comptage>>(gm.findAll()){})
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}")
	public Response getComptagesFromPatient(@PathParam("patient_id") String patient_id) throws IllegalArgumentException, Exception {
		ComptageModel gm = new ComptageModel();
		return Response.ok().entity(new GenericEntity<JSONMatrix>(gm.getComptagesFromPatient(patient_id)){})
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/multi")
	public Response getComptagesFromMultiPatient(@QueryParam("id") List<String> ids) throws IllegalArgumentException, Exception {
		ComptageModel gm = new ComptageModel();
		return Response.ok().entity(new GenericEntity<Set<JSONMatrix>>(gm.getComptagesFromMultiPatient(ids)){})
			.build();
	}
}
