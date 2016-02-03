package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class JSONMatrix {

	private String patient_id;
	private List<JSONComptage> genes = new ArrayList<JSONComptage>();
	
	public JSONMatrix(){
		
	}

	public String getPatientId() {
		return patient_id;
	}

	public void setPatientId(String patient_id) {
		this.patient_id = patient_id;
	}

	public List<JSONComptage> getComptages() {
		return genes;
	}

	public void setComptages(List<JSONComptage> genes) {
		this.genes = genes;
	}
}
