package domain;

// Generated 2 f�vr. 2016 10:59:52 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Comptage generated by hbm2java
 */
@Entity
@Table(name = "comptage", schema = "public")
@XmlRootElement	(name ="comptage")
public class Comptage implements java.io.Serializable {

	private ComptageId id;
	private Patient patient;
	private Matrix matrix;
	private Gene gene;
	private double log2ratio;

	public Comptage() {
	}

	public Comptage(ComptageId id, Patient patient, Matrix matrix, Gene gene,
			double log2ratio) {
		this.id = id;
		this.patient = patient;
		this.matrix = matrix;
		this.gene = gene;
		this.log2ratio = log2ratio;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "patientId", column = @Column(name = "patient_id", nullable = false, length = 25)),
			@AttributeOverride(name = "geneId", column = @Column(name = "gene_id", nullable = false, length = 25)) })
	public ComptageId getId() {
		return this.id;
	}

	public void setId(ComptageId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", nullable = false, insertable = false, updatable = false)
	public Patient getPatient() {
		return this.patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "matrix_id", nullable = false)
	public Matrix getMatrix() {
		return this.matrix;
	}

	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "gene_id", nullable = false, insertable = false, updatable = false)
	public Gene getGene() {
		return this.gene;
	}

	public void setGene(Gene gene) {
		this.gene = gene;
	}

	@Column(name = "log2ratio", nullable = false, precision = 17, scale = 17)
	public double getLog2ratio() {
		return this.log2ratio;
	}

	public void setLog2ratio(double log2ratio) {
		this.log2ratio = log2ratio;
	}

}
