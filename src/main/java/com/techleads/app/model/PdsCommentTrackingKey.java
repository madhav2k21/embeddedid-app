package com.techleads.app.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
public class PdsCommentTrackingKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "pds_cmnt_ts")
	private LocalDateTime pdsCommentTimestamp;

	@Column(name = "pds_trckng_ky")
	private Long pdsTrackingKey;

	public LocalDateTime getPdsCommentTimestamp() {
		return pdsCommentTimestamp;
	}

	public void setPdsCommentTimestamp(LocalDateTime pdsCommentTimestamp) {
		this.pdsCommentTimestamp = pdsCommentTimestamp;
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
