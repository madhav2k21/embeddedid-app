package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "pds_cmnt_trckng", schema = "scm_app_epds")
public class PdsCommentTracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PdsCommentTrackingKey pdsCommentTrackingKey;

	@Column(name = "pds_cmnt_typ_nm")
	private String pdsCommentTypeName;

	@Column(name = "pds_cmnt_crter_id")
	private String pdsCommentCreaterIdentifier;

	@Column(name = "pds_cmnt_crtertyp_nm")
	private String pdsCommentCreaterTypeName;

	@Column(name = "pds_cmnt_splr_nb")
	private String pdsCommentSupplierNumber;

	@Column(name = "pds_cmnt_rcvr_nm")
	private String pdsCommentReceiverName;

	@Column(name = "pds_cmnt_tx")
	private String pdsCommentText;

	@Column(name = "pds_cmnt_vsblty_lvl_cd")
	private String pdsCommentVisiblityLevelCode;

	@Column(name = "pds_cmnt_rvsn_nb")
	private String pdsCommentRevisionNumber;

	@Column(name = "pds_cmnt_crte_usr_id")
	private String pdsCommentCreateUserId;

	@Column(name = "pds_cmnt_crte_ts")
	private LocalDateTime pdsCommentCreatedTs;

	@Column(name = "pds_cmnt_updt_usr_id")
	private String pdsCommentUpdatedUserId;

	@Column(name = "pds_cmnt_updt_ts")
	private LocalDateTime pdsCommentUpdatedTs;

	public PdsCommentTrackingKey getPdsCommentTrackingKey() {
		return pdsCommentTrackingKey;
	}

	public void setPdsCommentTrackingKey(PdsCommentTrackingKey pdsCommentTrackingKey) {
		this.pdsCommentTrackingKey = pdsCommentTrackingKey;
	}

	public String getPdsCommentTypeName() {
		return pdsCommentTypeName;
	}

	public void setPdsCommentTypeName(String pdsCommentTypeName) {
		this.pdsCommentTypeName = pdsCommentTypeName;
	}

	public String getPdsCommentCreaterIdentifier() {
		return pdsCommentCreaterIdentifier;
	}

	public void setPdsCommentCreaterIdentifier(String pdsCommentCreaterIdentifier) {
		this.pdsCommentCreaterIdentifier = pdsCommentCreaterIdentifier;
	}

	public String getPdsCommentCreaterTypeName() {
		return pdsCommentCreaterTypeName;
	}

	public void setPdsCommentCreaterTypeName(String pdsCommentCreaterTypeName) {
		this.pdsCommentCreaterTypeName = pdsCommentCreaterTypeName;
	}

	public String getPdsCommentSupplierNumber() {
		return pdsCommentSupplierNumber;
	}

	public void setPdsCommentSupplierNumber(String pdsCommentSupplierNumber) {
		this.pdsCommentSupplierNumber = pdsCommentSupplierNumber;
	}

	public String getPdsCommentReceiverName() {
		return pdsCommentReceiverName;
	}

	public void setPdsCommentReceiverName(String pdsCommentReceiverName) {
		this.pdsCommentReceiverName = pdsCommentReceiverName;
	}

	public String getPdsCommentText() {
		return pdsCommentText;
	}

	public void setPdsCommentText(String pdsCommentText) {
		this.pdsCommentText = pdsCommentText;
	}

	public String getPdsCommentVisiblityLevelCode() {
		return pdsCommentVisiblityLevelCode;
	}

	public void setPdsCommentVisiblityLevelCode(String pdsCommentVisiblityLevelCode) {
		this.pdsCommentVisiblityLevelCode = pdsCommentVisiblityLevelCode;
	}

	public String getPdsCommentCreateUserId() {
		return pdsCommentCreateUserId;
	}

	public void setPdsCommentCreateUserId(String pdsCommentCreateUserId) {
		this.pdsCommentCreateUserId = pdsCommentCreateUserId;
	}

	public LocalDateTime getPdsCommentCreatedTs() {
		return pdsCommentCreatedTs;
	}

	public void setPdsCommentCreatedTs(LocalDateTime pdsCommentCreatedTs) {
		this.pdsCommentCreatedTs = pdsCommentCreatedTs;
	}

	public String getPdsCommentUpdatedUserId() {
		return pdsCommentUpdatedUserId;
	}

	public void setPdsCommentUpdatedUserId(String pdsCommentUpdatedUserId) {
		this.pdsCommentUpdatedUserId = pdsCommentUpdatedUserId;
	}

	public LocalDateTime getPdsCommentUpdatedTs() {
		return pdsCommentUpdatedTs;
	}

	public void setPdsCommentUpdatedTs(LocalDateTime pdsCommentUpdatedTs) {
		this.pdsCommentUpdatedTs = pdsCommentUpdatedTs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPdsCommentRevisionNumber() {
		return pdsCommentRevisionNumber;
	}

	public void setPdsCommentRevisionNumber(String pdsCommentRevisionNumber) {
		this.pdsCommentRevisionNumber = pdsCommentRevisionNumber;
	}

}
