package com.techleads.app.model;

import lombok.*;

import java.io.Serializable;

import javax.persistence.*;

//@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDistributionKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@Column(name = "usr_dfntn_id")
	private String userDefinitionId;

//	@Column(name = "usr_dfntn_wrk_ara_nm")
	private String userDefinitionWorkAreaName;

//	@Column(name = "usr_dstbtn_ky", columnDefinition = "serial", insertable = false,updatable = false)
//	@Column(name = "usr_dstbtn_ky", columnDefinition = "nextval('scm_app_epds.non_id_seq')", insertable = false,updatable = false)
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy=GenerationType.SEQUENCE)
//	@GeneratedValue(generator="my_seq")
//	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1)
//	@Column(name = "usr_dstbtn_ky")
	private Integer userDistributionKey;

}
