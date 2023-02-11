package com.autodesk.exception;

//Author's email address: mukul0064@gmail.com

import javax.ws.rs.core.CacheControl;

import com.autodesk.model.Error;

public interface BaseExceptionHandler {
	default Error error(String message) {
		var error = new Error();
		error.setMessage(message);
		return error;
	}

	default CacheControl getCacheControl() {
		var control = new CacheControl();
		control.setMaxAge(0);
		return control;
	}

}
