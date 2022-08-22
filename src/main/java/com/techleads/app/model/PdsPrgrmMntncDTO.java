package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PdsPrgrmMntncDTO  {

	private Integer progmMntncItemNumKey;
	private String progmMntncItemNum;
	private String progmMntncFacilityId;
	private String progmMntncTrackingNum;
	private String progmMntncRivisionNum;
	private String progmMntncCenterTypNum;
	private String progmMntncCenterRetunModeCd;
	private String progmMntncValueNum;
}
