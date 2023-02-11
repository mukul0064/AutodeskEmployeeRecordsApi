package com.autodesk.exception;

//Author's email address: mukul0064@gmail.com

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.jboss.logging.Logger;

@Provider
public class GenericExceptionHandler implements ExceptionMapper<Exception>, BaseExceptionHandler {

	private static final Logger LOGGER = Logger.getLogger(GenericExceptionHandler.class);

	@Override
	public Response toResponse(Exception exception) {
		LOGGER.error("Generic Api Exception while processing request: " + exception.getMessage());
		var control = getCacheControl();
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(error(exception.getMessage()))
				.cacheControl(control).build();
	}

}
