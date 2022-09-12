package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "pds_trckng", schema = "scm_app_epds")
public class PdsTracking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pds_trckng_ky")
	private long pdsTrackingKey;

	@Column(name = "pds_trckng_rvsn_nb")
	private String pdsTrackingRevisionNumber;

	@Column(name = "pds_trckng_nb")
	private String pdsTrackingNumber;

	@Column(name = "pds_trckng_itm_nb")
	private String pdsTrackingItemNumber;

	@Column(name = "pds_trckng_fclty_id")
	private String pdsTrackingFacilityId;

	@Column(name = "pds_trckng_parnt_pds_nb")
	private String pdsTrackingParentPdsNumber;

	@Column(name = "pds_trckng_added_dt")
	private Date pdsTrackingAddedDate;

	@Column(name = "pds_trckng_dmstc_in")
	private String pdsTrackingDomesticInd;

	@Column(name = "pds_trckng_lanch_dt")
	private Date pdsTrackingLaunchDate;

	@Column(name = "pds_trckng_stg_nm")
	private String pdsTrackingStageName;

	@Column(name = "pds_trckng_sts_nm")
	private String pdsTrackingStatusName;

	@Column(name = "pds_trckng_lst_chngd_dt")
	private Date pdsTrackingLastChangeDate;

	@Column(name = "pds_trckng_lst_acs_dt")
	private Date pdsTrackingLastAccessDate;

	@Column(name = "pds_trckng_read_in")
	private String pdsTrackingReadInd;

	@Column(name = "pds_trckng_prgrm_cd")
	private String pdsTrackingProgramCode;

	@Column(name = "pds_trckng_mdl_atrbt_nm")
	private String pdsTrackingModelAttributeName;

	@Column(name = "pds_trckng_mdl_nm")
	private String pdsTrackingModelName;

	@Column(name = "pds_trckng_pqe_engnr_usr_id")
	private String pdsTrackingPqeEngineerUserId;

	@Column(name = "pds_trckng_dcc_anlyst_usr_id")
	private String pdsTrackingDccAnalystUserId;

	@Column(name = "pds_trckng_lccn_nb")
	private Short pdsTrackingLccnNumber;

	@Column(name = "pds_trckng_lccn_ver_nb")
	private Short pdsTrackingLccnVersionNumber;

	@Column(name = "pds_trckng_cmn_mdl_nb")
	private double pdsTrackingCommonModelNumber;

	@Column(name = "pds_trckng_nna_pckg_engnr_usr")
	private String pdsTrackingNnaPackageEngineerUser;

	@Column(name = "pds_trckng_splr_nb")
	private String pdsTrackingSupplierNumber;

	@Column(name = "pds_trckng_splr_nm")
	private String pdsTrackingSupplierName;

	@Column(name = "pds_trckng_crte_usr_id")
	private String pdsTrackingCreatedUserId;

	@Column(name = "pds_trckng_crte_ts")
	private LocalDateTime pdsTrackingCreatedTs;

	@Column(name = "pds_trckng_updt_usr_id")
	private String pdsTrackingUpdatedUserId;

	@Column(name = "pds_trckng_updt_ts")
	private LocalDateTime pdsTrackingUpdatedTs;

	@Column(name = "pds_trckng_cncrned_prt_in")
	private String pdsTrackingConcernedPartIndicator;

	@Column(name = "pds_trckng_sts_chng_dt")
	private Date pdsTrackingStatusChangeDate;

	public long getPdsTrackingKey() {
		return pdsTrackingKey;
	}

	public void setPdsTrackingKey(long pdsTrackingKey) {
		this.pdsTrackingKey = pdsTrackingKey;
	}

	public String getPdsTrackingRevisionNumber() {
		return pdsTrackingRevisionNumber;
	}

	public void setPdsTrackingRevisionNumber(String pdsTrackingRevisionNumber) {
		this.pdsTrackingRevisionNumber = pdsTrackingRevisionNumber;
	}

	public String getPdsTrackingNumber() {
		return pdsTrackingNumber;
	}

	public void setPdsTrackingNumber(String pdsTrackingNumber) {
		this.pdsTrackingNumber = pdsTrackingNumber;
	}

	public String getPdsTrackingItemNumber() {
		return pdsTrackingItemNumber;
	}

	public void setPdsTrackingItemNumber(String pdsTrackingItemNumber) {
		this.pdsTrackingItemNumber = pdsTrackingItemNumber;
	}

	public String getPdsTrackingFacilityId() {
		return pdsTrackingFacilityId;
	}

	public void setPdsTrackingFacilityId(String pdsTrackingFacilityId) {
		this.pdsTrackingFacilityId = pdsTrackingFacilityId;
	}

	public String getPdsTrackingParentPdsNumber() {
		return pdsTrackingParentPdsNumber;
	}

	public void setPdsTrackingParentPdsNumber(String pdsTrackingParentPdsNumber) {
		this.pdsTrackingParentPdsNumber = pdsTrackingParentPdsNumber;
	}

	public Date getPdsTrackingAddedDate() {
		return pdsTrackingAddedDate;
	}

	public void setPdsTrackingAddedDate(Date pdsTrackingAddedDate) {
		this.pdsTrackingAddedDate = pdsTrackingAddedDate;
	}

	public String getPdsTrackingDomesticInd() {
		return pdsTrackingDomesticInd;
	}

	public void setPdsTrackingDomesticInd(String pdsTrackingDomesticInd) {
		this.pdsTrackingDomesticInd = pdsTrackingDomesticInd;
	}

	public Date getPdsTrackingLaunchDate() {
		return pdsTrackingLaunchDate;
	}

	public void setPdsTrackingLaunchDate(Date pdsTrackingLaunchDate) {
		this.pdsTrackingLaunchDate = pdsTrackingLaunchDate;
	}

	public String getPdsTrackingStageName() {
		return pdsTrackingStageName;
	}

	public void setPdsTrackingStageName(String pdsTrackingStageName) {
		this.pdsTrackingStageName = pdsTrackingStageName;
	}

	public String getPdsTrackingStatusName() {
		return pdsTrackingStatusName;
	}

	public void setPdsTrackingStatusName(String pdsTrackingStatusName) {
		this.pdsTrackingStatusName = pdsTrackingStatusName;
	}

	public Date getPdsTrackingLastChangeDate() {
		return pdsTrackingLastChangeDate;
	}

	public void setPdsTrackingLastChangeDate(Date pdsTrackingLastChangeDate) {
		this.pdsTrackingLastChangeDate = pdsTrackingLastChangeDate;
	}

	public Date getPdsTrackingLastAccessDate() {
		return pdsTrackingLastAccessDate;
	}

	public void setPdsTrackingLastAccessDate(Date pdsTrackingLastAccessDate) {
		this.pdsTrackingLastAccessDate = pdsTrackingLastAccessDate;
	}

	public String getPdsTrackingReadInd() {
		return pdsTrackingReadInd;
	}

	public void setPdsTrackingReadInd(String pdsTrackingReadInd) {
		this.pdsTrackingReadInd = pdsTrackingReadInd;
	}

	public String getPdsTrackingProgramCode() {
		return pdsTrackingProgramCode;
	}

	public void setPdsTrackingProgramCode(String pdsTrackingProgramCode) {
		this.pdsTrackingProgramCode = pdsTrackingProgramCode;
	}

	public String getPdsTrackingModelAttributeName() {
		return pdsTrackingModelAttributeName;
	}

	public void setPdsTrackingModelAttributeName(String pdsTrackingModelAttributeName) {
		this.pdsTrackingModelAttributeName = pdsTrackingModelAttributeName;
	}

	public String getPdsTrackingModelName() {
		return pdsTrackingModelName;
	}

	public void setPdsTrackingModelName(String pdsTrackingModelName) {
		this.pdsTrackingModelName = pdsTrackingModelName;
	}

	public String getPdsTrackingPqeEngineerUserId() {
		return pdsTrackingPqeEngineerUserId;
	}

	public void setPdsTrackingPqeEngineerUserId(String pdsTrackingPqeEngineerUserId) {
		this.pdsTrackingPqeEngineerUserId = pdsTrackingPqeEngineerUserId;
	}

	public String getPdsTrackingDccAnalystUserId() {
		return pdsTrackingDccAnalystUserId;
	}

	public void setPdsTrackingDccAnalystUserId(String pdsTrackingDccAnalystUserId) {
		this.pdsTrackingDccAnalystUserId = pdsTrackingDccAnalystUserId;
	}

	public Short getPdsTrackingLccnNumber() {
		return pdsTrackingLccnNumber;
	}

	public void setPdsTrackingLccnNumber(Short pdsTrackingLccnNumber) {
		this.pdsTrackingLccnNumber = pdsTrackingLccnNumber;
	}

	public Short getPdsTrackingLccnVersionNumber() {
		return pdsTrackingLccnVersionNumber;
	}

	public void setPdsTrackingLccnVersionNumber(Short pdsTrackingLccnVersionNumber) {
		this.pdsTrackingLccnVersionNumber = pdsTrackingLccnVersionNumber;
	}

	public double getPdsTrackingCommonModelNumber() {
		return pdsTrackingCommonModelNumber;
	}

	public void setPdsTrackingCommonModelNumber(double pdsTrackingCommonModelNumber) {
		this.pdsTrackingCommonModelNumber = pdsTrackingCommonModelNumber;
	}

	public String getPdsTrackingNnaPackageEngineerUser() {
		return pdsTrackingNnaPackageEngineerUser;
	}

	public void setPdsTrackingNnaPackageEngineerUser(String pdsTrackingNnaPackageEngineerUser) {
		this.pdsTrackingNnaPackageEngineerUser = pdsTrackingNnaPackageEngineerUser;
	}

	public String getPdsTrackingSupplierNumber() {
		return pdsTrackingSupplierNumber;
	}

	public void setPdsTrackingSupplierNumber(String pdsTrackingSupplierNumber) {
		this.pdsTrackingSupplierNumber = pdsTrackingSupplierNumber;
	}

	public String getPdsTrackingSupplierName() {
		return pdsTrackingSupplierName;
	}

	public void setPdsTrackingSupplierName(String pdsTrackingSupplierName) {
		this.pdsTrackingSupplierName = pdsTrackingSupplierName;
	}

	public String getPdsTrackingCreatedUserId() {
		return pdsTrackingCreatedUserId;
	}

	public void setPdsTrackingCreatedUserId(String pdsTrackingCreatedUserId) {
		this.pdsTrackingCreatedUserId = pdsTrackingCreatedUserId;
	}

	public LocalDateTime getPdsTrackingCreatedTs() {
		return pdsTrackingCreatedTs;
	}

	public void setPdsTrackingCreatedTs(LocalDateTime pdsTrackingCreatedTs) {
		this.pdsTrackingCreatedTs = pdsTrackingCreatedTs;
	}

	public String getPdsTrackingUpdatedUserId() {
		return pdsTrackingUpdatedUserId;
	}

	public void setPdsTrackingUpdatedUserId(String pdsTrackingUpdatedUserId) {
		this.pdsTrackingUpdatedUserId = pdsTrackingUpdatedUserId;
	}

	public LocalDateTime getPdsTrackingUpdatedTs() {
		return pdsTrackingUpdatedTs;
	}

	public void setPdsTrackingUpdatedTs(LocalDateTime pdsTrackingUpdatedTs) {
		this.pdsTrackingUpdatedTs = pdsTrackingUpdatedTs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPdsTrackingConcernedPartIndicator() {
		return pdsTrackingConcernedPartIndicator;
	}

	public void setPdsTrackingConcernedPartIndicator(String pdsTrackingConcernedPartIndicator) {
		this.pdsTrackingConcernedPartIndicator = pdsTrackingConcernedPartIndicator;
	}

	public Date getPdsTrackingStatusChangeDate() {
		return pdsTrackingStatusChangeDate;
	}

	public void setPdsTrackingStatusChangeDate(Date pdsTrackingStatusChangeDate) {
		this.pdsTrackingStatusChangeDate = pdsTrackingStatusChangeDate;
	}

}
