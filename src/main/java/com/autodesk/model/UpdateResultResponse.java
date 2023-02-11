package com.autodesk.model;

//Author's email address: mukul0064@gmail.com

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateResultResponse {

	@NotNull
	@NotEmpty
	String status;
	@NotNull
	@NotEmpty
	String Message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "UpdateResultResponse [status=" + status + ", Message=" + Message + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Message, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UpdateResultResponse other = (UpdateResultResponse) obj;
		return Objects.equals(Message, other.Message) && Objects.equals(status, other.status);
	}

}
