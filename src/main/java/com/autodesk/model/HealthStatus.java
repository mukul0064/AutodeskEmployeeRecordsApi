package com.autodesk.model;

//Author's email address: mukul0064@gmail.com

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthStatus {

	private String statusText;

	/**
	 * The HealthStatus provides the well-being status of the API.
	 */
	@JsonProperty("statusText")
	@NotNull
	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		HealthStatus healthStatus = (HealthStatus) o;
		return Objects.equals(statusText, healthStatus.statusText);
	}

	@Override
	public int hashCode() {
		return Objects.hash(statusText);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class HealthStatus {\n");
		sb.append("    statusText: ").append(toIndentedString(statusText)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
