package domain;

public class JSONComptage {

	private String gene_id;
	private double log2ratio;
	
	public JSONComptage(){
		
	}

	public String getGeneId() {
		return gene_id;
	}

	public void setGeneId(String gene_id) {
		this.gene_id = gene_id;
	}

	public double getLog2ratio() {
		return log2ratio;
	}

	public void setLog2ratio(double log2ratio) {
		this.log2ratio = log2ratio;
	}
}
