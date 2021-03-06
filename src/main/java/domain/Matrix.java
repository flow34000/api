package domain;

// Generated 3 f�vr. 2016 19:16:46 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Matrix generated by hbm2java
 */
@Entity
@Table(name = "matrix")
@XmlRootElement	(name ="matrix")
public class Matrix implements java.io.Serializable {

	private short matrixId;
	private String description;
	private Set<Work> works = new HashSet<Work>(0);

	public Matrix() {
	}

	public Matrix(short matrixId, String description) {
		this.matrixId = matrixId;
		this.description = description;
	}

	public Matrix(short matrixId, String description, Set<Work> works) {
		this.matrixId = matrixId;
		this.description = description;
		this.works = works;
	}

	@Id
	@Column(name = "matrix_id", unique = true, nullable = false)
	public short getMatrixId() {
		return this.matrixId;
	}

	public void setMatrixId(short matrixId) {
		this.matrixId = matrixId;
	}

	@Column(name = "description", nullable = false, length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "matrix")
	@JoinColumn(name = "matrix_id", nullable = false, insertable = false, updatable = false)
	@XmlTransient
	public Set<Work> getWorks() {
		return this.works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}

}
