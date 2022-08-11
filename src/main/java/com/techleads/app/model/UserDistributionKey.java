package com.techleads.app.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserDistributionKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "usr_dfntn_id")
	private String userDefinitionId;

	@Column(name = "usr_dfntn_wrk_ara_nm")
	private String userDefinitionWorkAreaName;

	@Column(name = "usr_dstbtn_ky")
	private Integer userDistributionKey;

	public String getUserDefinitionId() {
		return userDefinitionId;
	}

	public void setUserDefinitionId(String userDefinitionId) {
		this.userDefinitionId = userDefinitionId;
	}

	public String getUserDefinitionWorkAreaName() {
		return userDefinitionWorkAreaName;
	}

	public void setUserDefinitionWorkAreaName(String userDefinitionWorkAreaName) {
		this.userDefinitionWorkAreaName = userDefinitionWorkAreaName;
	}

	public Integer getUserDistributionKey() {
		return userDistributionKey;
	}

	public void setUserDistributionKey(Integer userDistributionKey) {
		this.userDistributionKey = userDistributionKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
