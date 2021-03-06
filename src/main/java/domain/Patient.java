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
 * Patient generated by hbm2java
 */
@Entity
@Table(name = "patient")
@XmlRootElement	(name ="patient")
public class Patient implements java.io.Serializable {

	private String patientId;
	private String pathology;
	private String tissue;
	private short age;
	private String platform;
	private String protocol;
	private String specie;
	private String type;
	private short class_;
	private String gender;
	private Set<Comptage> comptages = new HashSet<Comptage>(0);

	public Patient() {
	}

	public Patient(String patientId, String pathology, String tissue,
			short age, String platform, String protocol, String specie,
			String type, short class_, String gender) {
		this.patientId = patientId;
		this.pathology = pathology;
		this.tissue = tissue;
		this.age = age;
		this.platform = platform;
		this.protocol = protocol;
		this.specie = specie;
		this.type = type;
		this.class_ = class_;
		this.gender = gender;
	}

	public Patient(String patientId, String pathology, String tissue,
			short age, String platform, String protocol, String specie,
			String type, short class_, String gender, Set<Comptage> comptages) {
		this.patientId = patientId;
		this.pathology = pathology;
		this.tissue = tissue;
		this.age = age;
		this.platform = platform;
		this.protocol = protocol;
		this.specie = specie;
		this.type = type;
		this.class_ = class_;
		this.gender = gender;
		this.comptages = comptages;
	}

	@Id
	@Column(name = "patient_id", unique = true, nullable = false, length = 25)
	public String getPatientId() {
		return this.patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	@Column(name = "pathology", nullable = false, length = 25)
	public String getPathology() {
		return this.pathology;
	}

	public void setPathology(String pathology) {
		this.pathology = pathology;
	}

	@Column(name = "tissue", nullable = false, length = 25)
	public String getTissue() {
		return this.tissue;
	}

	public void setTissue(String tissue) {
		this.tissue = tissue;
	}

	@Column(name = "age", nullable = false)
	public short getAge() {
		return this.age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	@Column(name = "platform", nullable = false, length = 25)
	public String getPlatform() {
		return this.platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Column(name = "protocol", nullable = false, length = 25)
	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Column(name = "specie", nullable = false, length = 25)
	public String getSpecie() {
		return this.specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	@Column(name = "type", nullable = false, length = 25)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "class", nullable = false)
	public short getClass_() {
		return this.class_;
	}

	public void setClass_(short class_) {
		this.class_ = class_;
	}

	@Column(name = "gender", nullable = false, length = 25)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	@JoinColumn(name = "patient_id", nullable = false, insertable = false, updatable = false)
	@XmlTransient
	public Set<Comptage> getComptages() {
		return this.comptages;
	}

	public void setComptages(Set<Comptage> comptages) {
		this.comptages = comptages;
	}

}
