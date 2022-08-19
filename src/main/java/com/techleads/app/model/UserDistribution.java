package com.techleads.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
//@Table(name = "usr_dstbtn", schema = "scm_app_epds")
@Table(name = "usr_dstbtn")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDistribution implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserDistributionKey userDistributionKey;

	@Column(name = "usr_dstbtn_fclty_id")
	private String userDistributionFacilityId;

	@Column(name = "usr_dstbtn_prgrm_cd")
	private String userDistributionPgrmCode;

	@Column(name = "usr_dstbtn_prt_fmly_cd")
	private String userDistributionPartFamilyCode;

	@Column(name = "usr_dstbtn_splr_nb")
	private String userDistributionSupplierNumber;

	@Column(name = "usr_dstbtn_shop_clas_in")
	private String userDistributionShopClassInd;

	@Column(name = "usr_dstbtn_prt_nb")
	private String userDistributionPartNumber;

	@Column(name = "usr_dstbtn_crte_usr_id")
	private String userDistributionCreatedUserId;

	@Column(name = "usr_dstbtn_crte_ts")
	private LocalDateTime userDistributionCreatedTs;

	@Column(name = "usr_dstbtn_updt_usr_id")
	private String userDistributionUpdatedUserId;

	@Column(name = "usr_dstbtn_updt_ts")
	private LocalDateTime userDistributionUpdatedTs;

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
//	@JoinColumns({
//			@JoinColumn(name = "usr_dfntn_id", referencedColumnName = "usr_dfntn_id",
//					insertable = false, updatable = false),
//			@JoinColumn(name = "usr_dfntn_wrk_ara_nm", referencedColumnName = "usr_dfntn_wrk_ara_nm",
//					insertable = false, updatable = false)
//	})
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	@JsonIgnore
//	private UserDefinition userDefinition;





}
