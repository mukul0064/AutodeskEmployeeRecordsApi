package com.autodesk.model;

//Author's email address: mukul0064@gmail.com

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Error {

	private String message = null;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
