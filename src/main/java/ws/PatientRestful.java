package ws;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.PatientModel;
import domain.Comptage;
import domain.Patient;


@Path("patients/{patient_id}")
public class PatientRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientById(@PathParam("patient_id") String patient_id) throws Exception {
		PatientModel pm = new PatientModel();
		Patient p = pm.get(patient_id);
		
		return Response.ok().entity(new GenericEntity<Patient>(p){})
				.build();
	}
	
}
