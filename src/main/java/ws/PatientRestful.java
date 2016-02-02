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

import model.PatientModel;
import domain.Patient;


@Path("patients")
public class PatientRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() throws IllegalArgumentException, Exception {
		PatientModel pm = new PatientModel();
		return Response.ok().entity(new GenericEntity<List<Patient>>(pm.findAll()){})
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{patient_id}")
	public Response getPatientById(@PathParam("patient_id") String patient_id) throws Exception {
		PatientModel pm = new PatientModel();

		return Response.ok().entity(new GenericEntity<Patient>(pm.get(patient_id)){})
					.build();
	}
}
