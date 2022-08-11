package com.techleads.app.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
//@Table(name = "usr_dstbtn", schema = "scm_app_epds")
@Table(name = "usr_dstbtn")
public class UserDistribution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserDistributionKey userDistributionKey;

	@Column(name = "usr_dstbtn_fclty_id")
	private String userDistributionFacilityId;

	@Column(name = "usr_dstbtn_fmly_cd")
	private String userDistributionFamiliyCode;

	@Column(name = "usr_dstbtn_prt_fmly_cd")
	private String userDistributionPartFamilyCode;

	@Column(name = "usr_dstbtn_splr_nb")
	private String userDistributionSupplierNumber;

	@Column(name = "usr_dstbtn_shop_clas_in")
	private String userDistributionShopClassInd;

	@Column(name = "usr_dstbtn_prt_nb")
	private String userDistributionPartNumber;

	@Column(name = "usr_dstbtn_crte_usr_id")
	private String userDistributionCreatedUserId;

	@Column(name = "usr_dstbtn_crte_ts")
	private LocalDateTime userDistributionCreatedTs;

	@Column(name = "usr_dstbtn_updt_usr_id")
	private String userDistributionUpdatedUserId;

	@Column(name = "usr_dstbtn_updt_ts")
	private LocalDateTime userDistributionUpdatedTs;

	public UserDistributionKey getUserDistributionKey() {
		return userDistributionKey;
	}

	public void setUserDistributionKey(UserDistributionKey userDistributionKey) {
		this.userDistributionKey = userDistributionKey;
	}

	public String getUserDistributionFacilityId() {
		return userDistributionFacilityId;
	}

	public void setUserDistributionFacilityId(String userDistributionFacilityId) {
		this.userDistributionFacilityId = userDistributionFacilityId;
	}

	public String getUserDistributionFamiliyCode() {
		return userDistributionFamiliyCode;
	}

	public void setUserDistributionFamiliyCode(String userDistributionFamiliyCode) {
		this.userDistributionFamiliyCode = userDistributionFamiliyCode;
	}

	public String getUserDistributionPartFamilyCode() {
		return userDistributionPartFamilyCode;
	}

	public void setUserDistributionPartFamilyCode(String userDistributionPartFamilyCode) {
		this.userDistributionPartFamilyCode = userDistributionPartFamilyCode;
	}

	public String getUserDistributionSupplierNumber() {
		return userDistributionSupplierNumber;
	}

	public void setUserDistributionSupplierNumber(String userDistributionSupplierNumber) {
		this.userDistributionSupplierNumber = userDistributionSupplierNumber;
	}

	public String getUserDistributionShopClassInd() {
		return userDistributionShopClassInd;
	}

	public void setUserDistributionShopClassInd(String userDistributionShopClassInd) {
		this.userDistributionShopClassInd = userDistributionShopClassInd;
	}

	public String getUserDistributionPartNumber() {
		return userDistributionPartNumber;
	}

	public void setUserDistributionPartNumber(String userDistributionPartNumber) {
		this.userDistributionPartNumber = userDistributionPartNumber;
	}

	public String getUserDistributionCreatedUserId() {
		return userDistributionCreatedUserId;
	}

	public void setUserDistributionCreatedUserId(String userDistributionCreatedUserId) {
		this.userDistributionCreatedUserId = userDistributionCreatedUserId;
	}

	public LocalDateTime getUserDistributionCreatedTs() {
		return userDistributionCreatedTs;
	}

	public void setUserDistributionCreatedTs(LocalDateTime userDistributionCreatedTs) {
		this.userDistributionCreatedTs = userDistributionCreatedTs;
	}

	public String getUserDistributionUpdatedUserId() {
		return userDistributionUpdatedUserId;
	}

	public void setUserDistributionUpdatedUserId(String userDistributionUpdatedUserId) {
		this.userDistributionUpdatedUserId = userDistributionUpdatedUserId;
	}

	public LocalDateTime getUserDistributionUpdatedTs() {
		return userDistributionUpdatedTs;
	}

	public void setUserDistributionUpdatedTs(LocalDateTime userDistributionUpdatedTs) {
		this.userDistributionUpdatedTs = userDistributionUpdatedTs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
