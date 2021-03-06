package domain;

// Generated 3 f�vr. 2016 19:16:46 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * WorkId generated by hbm2java
 */
@Embeddable
public class WorkId implements java.io.Serializable {

	private String id;
	private short matrixId;

	public WorkId() {
	}

	public WorkId(String id, short matrixId) {
		this.id = id;
		this.matrixId = matrixId;
	}

	@Column(name = "id", nullable = false, length = 25)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "matrix_id", nullable = false)
	public short getMatrixId() {
		return this.matrixId;
	}

	public void setMatrixId(short matrixId) {
		this.matrixId = matrixId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof WorkId))
			return false;
		WorkId castOther = (WorkId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& (this.getMatrixId() == castOther.getMatrixId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result + this.getMatrixId();
		return result;
	}

}
