package com.bt.nat.esitest;

// default package
// Generated 21-Feb-2014 16:14:57 by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TEsitestEscalationDetails generated by hbm2java
 */
@Entity
@Table(name = "t_esitest_escalation_details")
public class TEsitestEscalationDetails implements java.io.Serializable {

	private long eedId;
	private long eedEsiId;
	private Integer eedEscalatedLevel;
	private String eedHoldEscalationEmails;
	private Integer eedEscalatedLevel0Ein;
	private Date eedEscalatedLevel0Date;
	private Integer eedEscalatedLevel1Ein;
	private Date eedEscalatedLevel1Date;
	private Integer eedEscalatedLevel2Ein;
	private Date eedEscalatedLevel2Date;
	private Integer eedEscalatedLevel3Ein;
	private Date eedEscalatedLevel3Date;
	private Character eedInitialEmailSent;

	public TEsitestEscalationDetails() {
	}

	public TEsitestEscalationDetails(long eedId, long eedEsiId) {
		this.eedId = eedId;
		this.eedEsiId = eedEsiId;
	}

	public TEsitestEscalationDetails(long eedId, long eedEsiId,
			Integer eedEscalatedLevel, String eedHoldEscalationEmails,
			Integer eedEscalatedLevel0Ein, Date eedEscalatedLevel0Date,
			Integer eedEscalatedLevel1Ein, Date eedEscalatedLevel1Date,
			Integer eedEscalatedLevel2Ein, Date eedEscalatedLevel2Date,
			Integer eedEscalatedLevel3Ein, Date eedEscalatedLevel3Date,
			Character eedInitialEmailSent) {
		this.eedId = eedId;
		this.eedEsiId = eedEsiId;
		this.eedEscalatedLevel = eedEscalatedLevel;
		this.eedHoldEscalationEmails = eedHoldEscalationEmails;
		this.eedEscalatedLevel0Ein = eedEscalatedLevel0Ein;
		this.eedEscalatedLevel0Date = eedEscalatedLevel0Date;
		this.eedEscalatedLevel1Ein = eedEscalatedLevel1Ein;
		this.eedEscalatedLevel1Date = eedEscalatedLevel1Date;
		this.eedEscalatedLevel2Ein = eedEscalatedLevel2Ein;
		this.eedEscalatedLevel2Date = eedEscalatedLevel2Date;
		this.eedEscalatedLevel3Ein = eedEscalatedLevel3Ein;
		this.eedEscalatedLevel3Date = eedEscalatedLevel3Date;
		this.eedInitialEmailSent = eedInitialEmailSent;
	}

	@Id
	@Column(name = "eed_id", unique = true, nullable = false)
	public long getEedId() {
		return this.eedId;
	}

	public void setEedId(long eedId) {
		this.eedId = eedId;
	}

	@Column(name = "eed_esi_id", nullable = false)
	public long getEedEsiId() {
		return this.eedEsiId;
	}

	public void setEedEsiId(long eedEsiId) {
		this.eedEsiId = eedEsiId;
	}

	@Column(name = "eed_escalated_level")
	public Integer getEedEscalatedLevel() {
		return this.eedEscalatedLevel;
	}

	public void setEedEscalatedLevel(Integer eedEscalatedLevel) {
		this.eedEscalatedLevel = eedEscalatedLevel;
	}

	@Column(name = "eed_hold_escalation_emails", length = 1)
	public String getEedHoldEscalationEmails() {
		return this.eedHoldEscalationEmails;
	}

	public void setEedHoldEscalationEmails(String eedHoldEscalationEmails) {
		this.eedHoldEscalationEmails = eedHoldEscalationEmails;
	}

	@Column(name = "eed_escalated_level0_ein")
	public Integer getEedEscalatedLevel0Ein() {
		return this.eedEscalatedLevel0Ein;
	}

	public void setEedEscalatedLevel0Ein(Integer eedEscalatedLevel0Ein) {
		this.eedEscalatedLevel0Ein = eedEscalatedLevel0Ein;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eed_escalated_level0_date", length = 23)
	public Date getEedEscalatedLevel0Date() {
		return this.eedEscalatedLevel0Date;
	}

	public void setEedEscalatedLevel0Date(Date eedEscalatedLevel0Date) {
		this.eedEscalatedLevel0Date = eedEscalatedLevel0Date;
	}

	@Column(name = "eed_escalated_level1_ein")
	public Integer getEedEscalatedLevel1Ein() {
		return this.eedEscalatedLevel1Ein;
	}

	public void setEedEscalatedLevel1Ein(Integer eedEscalatedLevel1Ein) {
		this.eedEscalatedLevel1Ein = eedEscalatedLevel1Ein;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eed_escalated_level1_date", length = 23)
	public Date getEedEscalatedLevel1Date() {
		return this.eedEscalatedLevel1Date;
	}

	public void setEedEscalatedLevel1Date(Date eedEscalatedLevel1Date) {
		this.eedEscalatedLevel1Date = eedEscalatedLevel1Date;
	}

	@Column(name = "eed_escalated_level2_ein")
	public Integer getEedEscalatedLevel2Ein() {
		return this.eedEscalatedLevel2Ein;
	}

	public void setEedEscalatedLevel2Ein(Integer eedEscalatedLevel2Ein) {
		this.eedEscalatedLevel2Ein = eedEscalatedLevel2Ein;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eed_escalated_level2_date", length = 23)
	public Date getEedEscalatedLevel2Date() {
		return this.eedEscalatedLevel2Date;
	}

	public void setEedEscalatedLevel2Date(Date eedEscalatedLevel2Date) {
		this.eedEscalatedLevel2Date = eedEscalatedLevel2Date;
	}

	@Column(name = "eed_escalated_level3_ein")
	public Integer getEedEscalatedLevel3Ein() {
		return this.eedEscalatedLevel3Ein;
	}

	public void setEedEscalatedLevel3Ein(Integer eedEscalatedLevel3Ein) {
		this.eedEscalatedLevel3Ein = eedEscalatedLevel3Ein;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "eed_escalated_level3_date", length = 23)
	public Date getEedEscalatedLevel3Date() {
		return this.eedEscalatedLevel3Date;
	}

	public void setEedEscalatedLevel3Date(Date eedEscalatedLevel3Date) {
		this.eedEscalatedLevel3Date = eedEscalatedLevel3Date;
	}

	@Column(name = "eed_initial_email_sent", length = 1)
	public Character getEedInitialEmailSent() {
		return this.eedInitialEmailSent;
	}

	public void setEedInitialEmailSent(Character eedInitialEmailSent) {
		this.eedInitialEmailSent = eedInitialEmailSent;
	}

}
