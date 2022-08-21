package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

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
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer userDistributionKey;

}
