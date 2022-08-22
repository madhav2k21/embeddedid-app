package com.techleads.app.model;

import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class PdsUserFacilityRelationshipKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "pds_usr_fclty_id")
	private String pdsUserFacilityId;

	@Column(name = "pds_usr_fclty_usr_dfntn_id")
	private String pdsUserFacilityUserDefinitionId;

	@Column(name = "pds_usr_fclty_wrk_ara_nm")
	private String pdsUserFacilityWorkAreaName;

	public String getPdsUserFacilityId() {
		return pdsUserFacilityId;
	}

	public void setPdsUserFacilityId(String pdsUserFacilityId) {
		this.pdsUserFacilityId = pdsUserFacilityId;
	}

	public String getPdsUserFacilityUserDefinitionId() {
		return pdsUserFacilityUserDefinitionId;
	}

	public void setPdsUserFacilityUserDefinitionId(String pdsUserFacilityUserDefinitionId) {
		this.pdsUserFacilityUserDefinitionId = pdsUserFacilityUserDefinitionId;
	}

	public String getPdsUserFacilityWorkAreaName() {
		return pdsUserFacilityWorkAreaName;
	}

	public void setPdsUserFacilityWorkAreaName(String pdsUserFacilityWorkAreaName) {
		this.pdsUserFacilityWorkAreaName = pdsUserFacilityWorkAreaName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public PdsUserFacilityRelationshipKey(String pdsUserFacilityId, String pdsUserFacilityUserDefinitionId,
			String pdsUserFacilityWorkAreaName) {
		super();
		this.pdsUserFacilityId = pdsUserFacilityId;
		this.pdsUserFacilityUserDefinitionId = pdsUserFacilityUserDefinitionId;
		this.pdsUserFacilityWorkAreaName = pdsUserFacilityWorkAreaName;
	}

	public PdsUserFacilityRelationshipKey() {
		super();
		// TODO Auto-generated constructor stub
	}

}
