package com.autodesk.model;

//Author's email address: mukul0064@gmail.com

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteRequestEvent {

	@NotEmpty()
	@NotNull()
	@Pattern(regexp = "^[1-9][0-9]{3}$", message = "Employee ID. Must be 4 digit positive number greater than 999.")
	String employeeId;

	@JsonProperty("employeeId")
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "DeleteRequestEvent [employeeId=" + employeeId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeleteRequestEvent other = (DeleteRequestEvent) obj;
		return Objects.equals(employeeId, other.employeeId);
	}

}
