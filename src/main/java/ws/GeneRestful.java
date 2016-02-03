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

import model.GeneModel;
import model.PatientModel;
import domain.Gene;
import domain.Patient;

@Path("genes/{gene_id}")
public class GeneRestful {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPatientById(@PathParam("gene_id") String gene_id) throws Exception {
		GeneModel gm = new GeneModel();
		Gene g = gm.get(gene_id);
		Response rep = Response.ok().entity(
					new GenericEntity<Gene>(g){}
				)
					.build();
		return rep;
	}
}
