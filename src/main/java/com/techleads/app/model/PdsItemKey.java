package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PdsItemKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "pds_vrsn_nb")
	private Short pdsVersionNumber;

	@Column(name = "pds_trckng_ky")
	private Long pdsTrackingKey;

	public Short getPdsVersionNumber() {
		return pdsVersionNumber;
	}

	public void setPdsVersionNumber(Short pdsVersionNumber) {
		this.pdsVersionNumber = pdsVersionNumber;
	}

	public Long getPdsTrackingKey() {
		return pdsTrackingKey;
	}

	public void setPdsTrackingKey(Long pdsTrackingKey) {
		this.pdsTrackingKey = pdsTrackingKey;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
