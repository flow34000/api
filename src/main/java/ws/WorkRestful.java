package ws;

import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.ComptageModel;
import model.WorkModel;
import domain.Comptage;
import domain.Gene;
import domain.JSONMatrix;
import domain.Patient;
import domain.Work;

@Path("work/{work_id}")
public class WorkRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getComptages(@PathParam("work_id") Short work_id) throws IllegalArgumentException, Exception {
		WorkModel wm = new WorkModel();
		return Response.ok().entity(new GenericEntity<Set<JSONMatrix>>(wm.getComptages(work_id)){})
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/patients")
	public Response getAllPatients(@PathParam("work_id") Short work_id) throws IllegalArgumentException, Exception {
		WorkModel wm = new WorkModel();
		return Response.ok().entity(new GenericEntity<Set<Patient>>(wm.getAllPatients(work_id)){})
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/genes")
	public Response getAllGenes(@PathParam("work_id") Short work_id) throws IllegalArgumentException, Exception {
		WorkModel wm = new WorkModel();
		return Response.ok().entity(new GenericEntity<Set<Gene>>(wm.getAllGenes(work_id)){})
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/select/col")
	public Response getComptagesFromIdPatient(@QueryParam("id") List<String> ids) throws IllegalArgumentException, Exception {
		WorkModel wm = new WorkModel();
		return Response.ok().entity(new GenericEntity<Set<JSONMatrix>>(wm.getComptagesFromIdPatient(ids)){})
			.build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/select/row")
	public Response getComptagesFromIdGene(@QueryParam("id") List<String> ids) throws IllegalArgumentException, Exception {
		WorkModel wm = new WorkModel();
		return Response.ok().entity(new GenericEntity<Set<JSONMatrix>>(wm.getComptagesFromIdGene(ids)){})
			.build();
	}
}
