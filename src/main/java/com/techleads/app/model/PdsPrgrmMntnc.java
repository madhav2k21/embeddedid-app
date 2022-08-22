package com.techleads.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "pds_prgrm_mntnc",schema = "scm_app_epds")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PdsPrgrmMntnc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "prgrm_mntnc_ky")
	private Integer progmMntncItemNumKey;


	@Column(name = "prgrm_mntnc_itm_nb")
	private String progmMntncItemNum;


	@Column(name = "prgrm_mntnc_fclty_id")
	private String progmMntncFacilityId;

	@Column(name = "prgrm_mntnc_trckng_nb")
	private String progmMntncTrackingNum;

	@Column(name = "prgrm_mntnc_rvsn_nb")
	private String progmMntncRivisionNum;

	@Column(name = "prgrm_mntnc_cntnr_typ_nm")
	private String progmMntncCenterTypNum;

	@Column(name = "prgrm_mntnc_cntnr_rtrn_mode_cd")
	private String progmMntncCenterRetunModeCd;

	@Column(name = "prgrm_mntnc_vlu_nm")
	private String progmMntncValueNum;

	@Column(name = "prgrm_mntnc_crte_usr_id")
	private String progmMntncCrtedUsrId;

	@Column(name = "prgrm_mntnc_crte_ts")
	private LocalDateTime progmMntncCrtedTs;


	@Column(name = "prgrm_mntnc_updt_usr_id")
	private String progmMntncUpdtedUsrId;

	@Column(name = "prgrm_mntnc_updt_ts")
	private LocalDateTime progmMntncUpdtedTs;

}
