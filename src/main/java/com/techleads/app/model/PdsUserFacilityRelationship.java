package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
//@Table(name = "pds_usr_fclty_rlnshp", schema = "scm_app_epds")
@Table(name = "pds_usr_fclty_rlnshp")
public class PdsUserFacilityRelationship implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PdsUserFacilityRelationshipKey pdsUserFacilityRelationshipKey;

	@Column(name = "pds_usr_fclty_crte_usr_id")
	private String pdsUserFacilityCreatedUserId;

	@Column(name = "pds_usr_fclty_crte_ts")
	private LocalDateTime pdsUserFacilityCreatedTs;

	@Column(name = "pds_usr_fclty_updt_usr_id")
	private String pdsUserFacilityUpdatedUserId;

	@Column(name = "pds_usr_fclty_updt_ts")
	private LocalDateTime pdsUserFacilityUpdatedTs;

	public PdsUserFacilityRelationshipKey getPdsUserFacilityRelationshipKey() {
		return pdsUserFacilityRelationshipKey;
	}

	public void setPdsUserFacilityRelationshipKey(PdsUserFacilityRelationshipKey pdsUserFacilityRelationshipKey) {
		this.pdsUserFacilityRelationshipKey = pdsUserFacilityRelationshipKey;
	}

	public String getPdsUserFacilityCreatedUserId() {
		return pdsUserFacilityCreatedUserId;
	}

	public void setPdsUserFacilityCreatedUserId(String pdsUserFacilityCreatedUserId) {
		this.pdsUserFacilityCreatedUserId = pdsUserFacilityCreatedUserId;
	}

	public LocalDateTime getPdsUserFacilityCreatedTs() {
		return pdsUserFacilityCreatedTs;
	}

	public void setPdsUserFacilityCreatedTs(LocalDateTime pdsUserFacilityCreatedTs) {
		this.pdsUserFacilityCreatedTs = pdsUserFacilityCreatedTs;
	}

	public String getPdsUserFacilityUpdatedUserId() {
		return pdsUserFacilityUpdatedUserId;
	}

	public void setPdsUserFacilityUpdatedUserId(String pdsUserFacilityUpdatedUserId) {
		this.pdsUserFacilityUpdatedUserId = pdsUserFacilityUpdatedUserId;
	}

	public LocalDateTime getPdsUserFacilityUpdatedTs() {
		return pdsUserFacilityUpdatedTs;
	}

	public void setPdsUserFacilityUpdatedTs(LocalDateTime pdsUserFacilityUpdatedTs) {
		this.pdsUserFacilityUpdatedTs = pdsUserFacilityUpdatedTs;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
