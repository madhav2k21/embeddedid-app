package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "pds_itm", schema = "scm_app_epds")
public class PdsItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PdsItemKey pdsItemKey;

	@Column(name = "pds_itm_d_note_nb")
	private String pdsItemDNoteNumber;

	@Column(name = "pds_itm_old_prt_nb")
	private String pdsItemOldPartNumber;

	@Column(name = "pds_itm_ds")
	private String pdsItemDescription;

	@Column(name = "pds_itm_shop_clas_in")
	private String pdsItemShopClassInd;

	@Column(name = "pds_itm_adpt_dt")
	private Date pdsItemAdoptionDate;

	@Column(name = "pds_itm_ablsh_dt")
	private Date pdsItemAbolishDate;

	@Column(name = "pds_itm_fmly_cd")
	private String pdsItemFamilyCode;

	@Column(name = "pds_itm_fnctn_cd")
	private String pdsItemFunctionCode;

	@Column(name = "pds_itm_prgrm_cd")
	private String pdsItemProgramCode;

	@Column(name = "pds_itm_splr_nb")
	private String pdsItemSupplierNumber;

	@Column(name = "pds_itm_splr_nb_dt")
	private Date pdsItemSupplierNumberDate;

	@Column(name = "pds_itm_splr_adrs_nm")
	private String pdsItemSupplierAddressNumber;

	@Column(name = "pds_itm_crte_usr_id")
	private String pdsItemCreatedUserId;

	@Column(name = "pds_itm_crte_ts")
	private LocalDateTime pdsItemCreatedTs;

	@Column(name = "pds_itm_updt_usr_id")
	private String pdsItemUpdatedUserId;

	@Column(name = "pds_itm_updt_ts")
	private LocalDateTime pdsItemUpdatedTs;

	@Column(name = "pds_itm_prt_clas_cd")
	private String pdsItemPartClassInd;

	@Column(name = "pds_itm_prcs_cd")
	private String pdsItemProcessCode;

	public PdsItemKey getPdsItemKey() {
		return pdsItemKey;
	}

	public void setPdsItemKey(PdsItemKey pdsItemKey) {
		this.pdsItemKey = pdsItemKey;
	}

	public String getPdsItemDNoteNumber() {
		return pdsItemDNoteNumber;
	}

	public void setPdsItemDNoteNumber(String pdsItemDNoteNumber) {
		this.pdsItemDNoteNumber = pdsItemDNoteNumber;
	}

	public String getPdsItemOldPartNumber() {
		return pdsItemOldPartNumber;
	}

	public void setPdsItemOldPartNumber(String pdsItemOldPartNumber) {
		this.pdsItemOldPartNumber = pdsItemOldPartNumber;
	}

	public String getPdsItemDescription() {
		return pdsItemDescription;
	}

	public void setPdsItemDescription(String pdsItemDescription) {
		this.pdsItemDescription = pdsItemDescription;
	}

	public String getPdsItemShopClassInd() {
		return pdsItemShopClassInd;
	}

	public void setPdsItemShopClassInd(String pdsItemShopClassInd) {
		this.pdsItemShopClassInd = pdsItemShopClassInd;
	}

	public Date getPdsItemAdoptionDate() {
		return pdsItemAdoptionDate;
	}

	public void setPdsItemAdoptionDate(Date pdsItemAdoptionDate) {
		this.pdsItemAdoptionDate = pdsItemAdoptionDate;
	}

	public Date getPdsItemAbolishDate() {
		return pdsItemAbolishDate;
	}

	public void setPdsItemAbolishDate(Date pdsItemAbolishDate) {
		this.pdsItemAbolishDate = pdsItemAbolishDate;
	}

	public String getPdsItemFamilyCode() {
		return pdsItemFamilyCode;
	}

	public void setPdsItemFamilyCode(String pdsItemFamilyCode) {
		this.pdsItemFamilyCode = pdsItemFamilyCode;
	}

	public String getPdsItemFunctionCode() {
		return pdsItemFunctionCode;
	}

	public void setPdsItemFunctionCode(String pdsItemFunctionCode) {
		this.pdsItemFunctionCode = pdsItemFunctionCode;
	}

	public String getPdsItemProgramCode() {
		return pdsItemProgramCode;
	}

	public void setPdsItemProgramCode(String pdsItemProgramCode) {
		this.pdsItemProgramCode = pdsItemProgramCode;
	}

	public String getPdsItemSupplierNumber() {
		return pdsItemSupplierNumber;
	}

	public void setPdsItemSupplierNumber(String pdsItemSupplierNumber) {
		this.pdsItemSupplierNumber = pdsItemSupplierNumber;
	}

	public Date getPdsItemSupplierNumberDate() {
		return pdsItemSupplierNumberDate;
	}

	public void setPdsItemSupplierNumberDate(Date pdsItemSupplierNumberDate) {
		this.pdsItemSupplierNumberDate = pdsItemSupplierNumberDate;
	}

	public String getPdsItemSupplierAddressNumber() {
		return pdsItemSupplierAddressNumber;
	}

	public void setPdsItemSupplierAddressNumber(String pdsItemSupplierAddressNumber) {
		this.pdsItemSupplierAddressNumber = pdsItemSupplierAddressNumber;
	}

	public String getPdsItemCreatedUserId() {
		return pdsItemCreatedUserId;
	}

	public void setPdsItemCreatedUserId(String pdsItemCreatedUserId) {
		this.pdsItemCreatedUserId = pdsItemCreatedUserId;
	}

	public LocalDateTime getPdsItemCreatedTs() {
		return pdsItemCreatedTs;
	}

	public void setPdsItemCreatedTs(LocalDateTime pdsItemCreatedTs) {
		this.pdsItemCreatedTs = pdsItemCreatedTs;
	}

	public String getPdsItemUpdatedUserId() {
		return pdsItemUpdatedUserId;
	}

	public void setPdsItemUpdatedUserId(String pdsItemUpdatedUserId) {
		this.pdsItemUpdatedUserId = pdsItemUpdatedUserId;
	}

	public LocalDateTime getPdsItemUpdatedTs() {
		return pdsItemUpdatedTs;
	}

	public void setPdsItemUpdatedTs(LocalDateTime pdsItemUpdatedTs) {
		this.pdsItemUpdatedTs = pdsItemUpdatedTs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getPdsItemPartClassInd() {
		return pdsItemPartClassInd;
	}

	public void setPdsItemPartClassInd(String pdsItemPartClassInd) {
		this.pdsItemPartClassInd = pdsItemPartClassInd;
	}

	public String getPdsItemProcessCode() {
		return pdsItemProcessCode;
	}

	public void setPdsItemProcessCode(String pdsItemProcessCode) {
		this.pdsItemProcessCode = pdsItemProcessCode;
	}

}
