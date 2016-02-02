package ws;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application{

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new java.util.HashSet();
		addRestResourceClasses(resources);
		return resources;
	}
	
	private void addRestResourceClasses(Set <Class<?>> resources){
		resources.add(ws.PatientRestful.class);
		resources.add(ws.GeneRestful.class);
		resources.add(ws.MatrixRestful.class);
		resources.add(ws.ComptageRestful.class);
	}
}