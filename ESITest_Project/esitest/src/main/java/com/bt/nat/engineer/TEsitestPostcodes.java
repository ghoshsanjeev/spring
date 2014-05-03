package com.bt.nat.engineer;
// default package
// Generated 18-Feb-2014 11:13:07 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TEsitestPostcodesId generated by hbm2java
 */
@Entity
@Table(name = "t_esitest_postcodes")
public class TEsitestPostcodes implements java.io.Serializable {

	private long epoId;
	private String epoPostCode;
	private Integer epoServicePointRef;
	private Integer epoTesterEin;
	private String epoTown;

	public TEsitestPostcodes() {
	}

	public TEsitestPostcodes(long epoId) {
		this.epoId = epoId;
	}

	public TEsitestPostcodes(long epoId, String epoPostCode,
			Integer epoServicePointRef, Integer epoTesterEin, String epoTown) {
		this.epoId = epoId;
		this.epoPostCode = epoPostCode;
		this.epoServicePointRef = epoServicePointRef;
		this.epoTesterEin = epoTesterEin;
		this.epoTown = epoTown;
	}

	@Id
	@Column(name = "epo_id", nullable = false)
	public long getEpoId() {
		return this.epoId;
	}

	public void setEpoId(long epoId) {
		this.epoId = epoId;
	}

	@Column(name = "epo_post_code", length = 10)
	public String getEpoPostCode() {
		return this.epoPostCode;
	}

	public void setEpoPostCode(String epoPostCode) {
		this.epoPostCode = epoPostCode;
	}

	@Column(name = "epo_service_point_ref")
	public Integer getEpoServicePointRef() {
		return this.epoServicePointRef;
	}

	public void setEpoServicePointRef(Integer epoServicePointRef) {
		this.epoServicePointRef = epoServicePointRef;
	}

	@Column(name = "epo_tester_ein")
	public Integer getEpoTesterEin() {
		return this.epoTesterEin;
	}

	public void setEpoTesterEin(Integer epoTesterEin) {
		this.epoTesterEin = epoTesterEin;
	}

	@Column(name = "epo_town", length = 100)
	public String getEpoTown() {
		return this.epoTown;
	}

	public void setEpoTown(String epoTown) {
		this.epoTown = epoTown;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TEsitestPostcodes))
			return false;
		TEsitestPostcodes castOther = (TEsitestPostcodes) other;

		return (this.getEpoId() == castOther.getEpoId())
				&& ((this.getEpoPostCode() == castOther.getEpoPostCode()) || (this
						.getEpoPostCode() != null
						&& castOther.getEpoPostCode() != null && this
						.getEpoPostCode().equals(castOther.getEpoPostCode())))
				&& ((this.getEpoServicePointRef() == castOther
						.getEpoServicePointRef()) || (this
						.getEpoServicePointRef() != null
						&& castOther.getEpoServicePointRef() != null && this
						.getEpoServicePointRef().equals(
								castOther.getEpoServicePointRef())))
				&& ((this.getEpoTesterEin() == castOther.getEpoTesterEin()) || (this
						.getEpoTesterEin() != null
						&& castOther.getEpoTesterEin() != null && this
						.getEpoTesterEin().equals(castOther.getEpoTesterEin())))
				&& ((this.getEpoTown() == castOther.getEpoTown()) || (this
						.getEpoTown() != null && castOther.getEpoTown() != null && this
						.getEpoTown().equals(castOther.getEpoTown())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getEpoId();
		result = 37
				* result
				+ (getEpoPostCode() == null ? 0 : this.getEpoPostCode()
						.hashCode());
		result = 37
				* result
				+ (getEpoServicePointRef() == null ? 0 : this
						.getEpoServicePointRef().hashCode());
		result = 37
				* result
				+ (getEpoTesterEin() == null ? 0 : this.getEpoTesterEin()
						.hashCode());
		result = 37 * result
				+ (getEpoTown() == null ? 0 : this.getEpoTown().hashCode());
		return result;
	}

}
