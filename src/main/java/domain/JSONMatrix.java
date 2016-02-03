package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class JSONMatrix {

	private String patient_id;
	private Set<JSONComptage> genes = new HashSet<JSONComptage>();
	
	public JSONMatrix(){
		
	}

	public String getPatientId() {
		return patient_id;
	}

	public void setPatientId(String patient_id) {
		this.patient_id = patient_id;
	}

	public Set<JSONComptage> getComptages() {
		return genes;
	}

	public void setComptages(Set<JSONComptage> genes) {
		this.genes = genes;
	}
}
