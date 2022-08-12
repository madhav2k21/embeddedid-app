package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
	private Integer userDistributionKeyNum;

//	public String getUserDefinitionId() {
//		return userDefinitionId;
//	}
//
//	public void setUserDefinitionId(String userDefinitionId) {
//		this.userDefinitionId = userDefinitionId;
//	}
//
//	public String getUserDefinitionWorkAreaName() {
//		return userDefinitionWorkAreaName;
//	}
//
//	public void setUserDefinitionWorkAreaName(String userDefinitionWorkAreaName) {
//		this.userDefinitionWorkAreaName = userDefinitionWorkAreaName;
//	}
//
//	public Integer getUserDistributionKey() {
//		return userDistributionKey;
//	}
//
//	public void setUserDistributionKey(Integer userDistributionKey) {
//		this.userDistributionKey = userDistributionKey;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}

}
