package domain;

// Generated 2 f�vr. 2016 10:59:52 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ComptageId generated by hbm2java
 */
@Embeddable
public class ComptageId implements java.io.Serializable {

	private String patientId;
	private String geneId;

	public ComptageId() {
	}

	public ComptageId(String patientId, String geneId) {
		this.patientId = patientId;
		this.geneId = geneId;
	}

	@Column(name = "patient_id", nullable = false, length = 25)
	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	@Column(name = "gene_id", nullable = false, length = 25)
	public String getGeneId() {
		return this.geneId;
	}

	public void setGeneId(String geneId) {
		this.geneId = geneId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ComptageId))
			return false;
		ComptageId castOther = (ComptageId) other;

		return ((this.getPatientId() == castOther.getPatientId()) || (this
				.getPatientId() != null && castOther.getPatientId() != null && this
				.getPatientId().equals(castOther.getPatientId())))
				&& ((this.getGeneId() == castOther.getGeneId()) || (this
						.getGeneId() != null && castOther.getGeneId() != null && this
						.getGeneId().equals(castOther.getGeneId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPatientId() == null ? 0 : this.getPatientId().hashCode());
		result = 37 * result
				+ (getGeneId() == null ? 0 : this.getGeneId().hashCode());
		return result;
	}

}
