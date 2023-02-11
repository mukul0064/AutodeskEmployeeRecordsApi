package com.autodesk.resource;

//Author's email address: mukul0064@gmail.com

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.logging.Logger;

import com.autodesk.constant.ApiConstants;
import com.autodesk.model.DeleteRequestEvent;
import com.autodesk.model.HealthStatus;
import com.autodesk.model.RequestEvent;
import com.autodesk.model.ResponseBody;
import com.autodesk.model.UpdateResultResponse;
import com.autodesk.service.RecordAddService;
import com.autodesk.service.RecordDeleteService;
import com.autodesk.service.RecordUpdateService;
import com.autodesk.service.RecordsService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@ApplicationScoped
@Path(ApiConstants.API_URL)
public class RemployeeRecordsController {

	private static final Logger LOGGER = Logger.getLogger(RemployeeRecordsController.class);

	@Inject
	RecordsService recordsService;

	@Inject
	RecordDeleteService recordDeleteService;

	@Inject
	RecordUpdateService recordUpdateService;

	@Inject
	RecordAddService recordAddService;

	// get-inventory
	@GET
	@Path(ApiConstants.RECORDS_URL)
	@Produces({ "application/json" })
	public Response employeeRecords() {
		LOGGER.info("Entered Employee Records Service");
		List<ResponseBody> result = recordsService.RecordsServiceMethod();
		if (result.isEmpty()) {
			return Response.noContent().build();
		}
		return Response.ok().entity(result).build();
	}

	// update-inventory
	@PUT
	@Path(ApiConstants.UPDATE_URL)
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response updateRecord(@RequestBody @Valid RequestEvent requestEvent) {
		LOGGER.info("Entered Employee Records Service for updating record");
		UpdateResultResponse result = recordUpdateService.RecordUpdateServiceMethod(requestEvent);
		return Response.ok().entity(result.getMessage().toString()).build();
	}

	// add-inventory
	@POST
	@Path(ApiConstants.ADD_URL)
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public Response addRecord(@RequestBody @Valid RequestEvent requestEvent) {
		LOGGER.info("Entered Employee Records Service for adding record");
		String result = recordAddService.RecordAddServiceMethod(requestEvent);
		return Response.ok().entity(result.toString()).build();
	}

	// delete-inventory
	@PUT
	@Path(ApiConstants.DELETE_URL)
	@Produces({ "application/json" })
	public Response deleteRecord(@RequestBody @Valid DeleteRequestEvent deleteRequestEvent) {
		LOGGER.info("Entered Employee Records Service for deleting record");
		String result = recordDeleteService.RecordDeleteServiceMethod(deleteRequestEvent);
		return Response.ok().entity(result.toString()).build();
	}

	// health endpoint
	@GET
	@Path(ApiConstants.RESOURCE_HEALTH)
	@Produces({ "application/json" })
	public Response healthCheckpost() {
		LOGGER.info("Entered Employee Records Service Health API");
		HealthStatus healthStatus = new HealthStatus();
		healthStatus.setStatusText(Response.Status.OK.toString());
		return Response.status(Response.Status.OK).entity(healthStatus).build();
	}

}
