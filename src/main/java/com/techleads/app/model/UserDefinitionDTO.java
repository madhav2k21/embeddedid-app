package com.techleads.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@AllArgsConstructorz
//@NoArgsConstructor
public class UserDefinitionDTO {

	@JsonProperty("id")
	private String UserDefinitionId;
	@JsonProperty("role")
	private String UserDefinitionTitleName;
	@JsonProperty("firstName")
	private String UserDefinitionFirstName;
	@JsonProperty("lastName")
	private String UserDefinitionLastName;
	@JsonProperty("workArea")
	private String userDefinitionWorkAreaName;
	@JsonProperty("facility")
	private String facility;

//	public UserDefinitionDTO() {
//
//	}
//
//	public UserDefinitionDTO(String UserDefinitionTitleName, String UserDefinitionLastName,
//			String UserDefinitionFirstName) {
//		this.UserDefinitionTitleName = UserDefinitionTitleName;
//		this.UserDefinitionLastName = UserDefinitionLastName;
//		this.UserDefinitionFirstName = UserDefinitionFirstName;
//	}
//
//	public void setUserDefinitionId(String userDefinitionId) {
//		UserDefinitionId = userDefinitionId;
//	}
//
//	public void setUserDefinitionTitleName(String userDefinitionTitleName) {
//		UserDefinitionTitleName = userDefinitionTitleName;
//	}
//
//	public void setUserDefinitionFirstName(String userDefinitionFirstName) {
//		UserDefinitionFirstName = userDefinitionFirstName;
//	}
//
//	public void setUserDefinitionLastName(String userDefinitionLastName) {
//		UserDefinitionLastName = userDefinitionLastName;
//	}
//
//	public String getUserDefinitionId() {
//		return UserDefinitionId;
//	}
//
//	public String getUserDefinitionTitleName() {
//		return UserDefinitionTitleName;
//	}
//
//	public String getUserDefinitionFirstName() {
//		return UserDefinitionFirstName;
//	}
//
//	public String getUserDefinitionLastName() {
//		return UserDefinitionLastName;
//	}
//
//	public static String asString(Object value) {
//		return (value != null ? value.toString().trim() : "");
//	}

}
