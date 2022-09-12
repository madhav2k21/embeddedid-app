package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "pds", schema = "scm_app_epds")
public class Pds implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PdsKey pdsKey;

	@Column(name = "pds_prgrm_cd")
	private String pdsProgramCode;

	@Column(name = "pds_splr_nb")
	private String pdsSupplierNumber;

	@Column(name = "pds_cntct_usr_id")
	private String pdsContactUserId;

	@Column(name = "pds_cntct_frst_nm")
	private String pdsContactFirstName;

	@Column(name = "pds_cntct_lst_nm")
	private String pdsContactLastName;

	@Column(name = "pds_phn_nb")
	private double pdsPhoneNumber;

	@Column(name = "pds_prt_cryovr_in")
	private String pdsPartCarryOverInd;

	@Column(name = "pds_pckg_cryovr_in")
	private String pdsPackageCarryoverInd;

	@Column(name = "pds_pckg_cary_acrs_in")
	private String pdsPackageCarryAcrossInd;

	@Column(name = "pds_typ_nm")
	private String pdsTypeName;

	@Column(name = "pds_pass_thrgh_in")
	private String pdsPassThroughInd;

	@Column(name = "pds_repck_in")
	private String pdsRepackInd;

	@Column(name = "pds_mnfctg_in")
	private String pdsManufacturingInd;

	@Column(name = "pds_othr_nm")
	private String pdsOtherName;

	@Column(name = "pds_pckg_mtrl_typ_nm")
	private String pdsPackagingMaterialTypeName;

	@Column(name = "pds_cntnr_typ_nm")
	private String pdsContainerTypeName;

	@Column(name = "pds_unt_dsplyed_us_in")
	private String pdsUnitDisplayedUsIdentifier;

	@Column(name = "pds_trnsmting_usr_id")
	private String pdsTransmittingUserIdentifier;

	@Column(name = "pds_crte_usr_id")
	private String pdsCreatedUserId;

	@Column(name = "pds_crte_ts")
	private LocalDateTime pdsCreatedTs;

	@Column(name = "pds_updt_usr_id")
	private String pdsUpdatedUserId;

	@Column(name = "pds_updt_ts")
	private LocalDateTime pdsUpdatedTs;

	@Column(name = "pds_shpng_fclty_clsftn_nm")
	private String pdsShippingFacilityClassificationName;

	public String getPdsShippingFacilityClassificationName() {
		return pdsShippingFacilityClassificationName;
	}

	public void setPdsShippingFacilityClassificationName(String pdsShippingFacilityClassificationName) {
		this.pdsShippingFacilityClassificationName = pdsShippingFacilityClassificationName;
	}

	public PdsKey getPdsKey() {
		return pdsKey;
	}

	public void setPdsKey(PdsKey pdsKey) {
		this.pdsKey = pdsKey;
	}

	public String getPdsProgramCode() {
		return pdsProgramCode;
	}

	public void setPdsProgramCode(String pdsProgramCode) {
		this.pdsProgramCode = pdsProgramCode;
	}

	public String getPdsSupplierNumber() {
		return pdsSupplierNumber;
	}

	public void setPdsSupplierNumber(String pdsSupplierNumber) {
		this.pdsSupplierNumber = pdsSupplierNumber;
	}

	public String getPdsContactUserId() {
		return pdsContactUserId;
	}

	public void setPdsContactUserId(String pdsContactUserId) {
		this.pdsContactUserId = pdsContactUserId;
	}

	public String getPdsContactFirstName() {
		return pdsContactFirstName;
	}

	public void setPdsContactFirstName(String pdsContactFirstName) {
		this.pdsContactFirstName = pdsContactFirstName;
	}

	public String getPdsContactLastName() {
		return pdsContactLastName;
	}

	public void setPdsContactLastName(String pdsContactLastName) {
		this.pdsContactLastName = pdsContactLastName;
	}

	public double getPdsPhoneNumber() {
		return pdsPhoneNumber;
	}

	public void setPdsPhoneNumber(double pdsPhoneNumber) {
		this.pdsPhoneNumber = pdsPhoneNumber;
	}

	public String getPdsPartCarryOverInd() {
		return pdsPartCarryOverInd;
	}

	public void setPdsPartCarryOverInd(String pdsPartCarryOverInd) {
		this.pdsPartCarryOverInd = pdsPartCarryOverInd;
	}

	public String getPdsPackageCarryoverInd() {
		return pdsPackageCarryoverInd;
	}

	public void setPdsPackageCarryoverInd(String pdsPackageCarryoverInd) {
		this.pdsPackageCarryoverInd = pdsPackageCarryoverInd;
	}

	public String getPdsPackageCarryAcrossInd() {
		return pdsPackageCarryAcrossInd;
	}

	public void setPdsPackageCarryAcrossInd(String pdsPackageCarryAcrossInd) {
		this.pdsPackageCarryAcrossInd = pdsPackageCarryAcrossInd;
	}

	public String getPdsTypeName() {
		return pdsTypeName;
	}

	public void setPdsTypeName(String pdsTypeName) {
		this.pdsTypeName = pdsTypeName;
	}

	public String getPdsPassThroughInd() {
		return pdsPassThroughInd;
	}

	public void setPdsPassThroughInd(String pdsPassThroughInd) {
		this.pdsPassThroughInd = pdsPassThroughInd;
	}

	public String getPdsRepackInd() {
		return pdsRepackInd;
	}

	public void setPdsRepackInd(String pdsRepackInd) {
		this.pdsRepackInd = pdsRepackInd;
	}

	public String getPdsManufacturingInd() {
		return pdsManufacturingInd;
	}

	public void setPdsManufacturingInd(String pdsManufacturingInd) {
		this.pdsManufacturingInd = pdsManufacturingInd;
	}

	public String getPdsOtherName() {
		return pdsOtherName;
	}

	public void setPdsOtherName(String pdsOtherName) {
		this.pdsOtherName = pdsOtherName;
	}

	public String getPdsPackagingMaterialTypeName() {
		return pdsPackagingMaterialTypeName;
	}

	public void setPdsPackagingMaterialTypeName(String pdsPackagingMaterialTypeName) {
		this.pdsPackagingMaterialTypeName = pdsPackagingMaterialTypeName;
	}

	public String getPdsContainerTypeName() {
		return pdsContainerTypeName;
	}

	public void setPdsContainerTypeName(String pdsContainerTypeName) {
		this.pdsContainerTypeName = pdsContainerTypeName;
	}

	public String getPdsUnitDisplayedUsIdentifier() {
		return pdsUnitDisplayedUsIdentifier;
	}

	public void setPdsUnitDisplayedUsIdentifier(String pdsUnitDisplayedUsIdentifier) {
		this.pdsUnitDisplayedUsIdentifier = pdsUnitDisplayedUsIdentifier;
	}

	public String getPdsTransmittingUserIdentifier() {
		return pdsTransmittingUserIdentifier;
	}

	public void setPdsTransmittingUserIdentifier(String pdsTransmittingUserIdentifier) {
		this.pdsTransmittingUserIdentifier = pdsTransmittingUserIdentifier;
	}

	public String getPdsCreatedUserId() {
		return pdsCreatedUserId;
	}

	public void setPdsCreatedUserId(String pdsCreatedUserId) {
		this.pdsCreatedUserId = pdsCreatedUserId;
	}

	public LocalDateTime getPdsCreatedTs() {
		return pdsCreatedTs;
	}

	public void setPdsCreatedTs(LocalDateTime pdsCreatedTs) {
		this.pdsCreatedTs = pdsCreatedTs;
	}

	public String getPdsUpdatedUserId() {
		return pdsUpdatedUserId;
	}

	public void setPdsUpdatedUserId(String pdsUpdatedUserId) {
		this.pdsUpdatedUserId = pdsUpdatedUserId;
	}

	public LocalDateTime getPdsUpdatedTs() {
		return pdsUpdatedTs;
	}

	public void setPdsUpdatedTs(LocalDateTime pdsUpdatedTs) {
		this.pdsUpdatedTs = pdsUpdatedTs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
