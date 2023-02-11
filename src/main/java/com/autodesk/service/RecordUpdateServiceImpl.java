package com.autodesk.service;

//Author's email address: mukul0064@gmail.com

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.autodesk.model.RequestEvent;
import com.autodesk.model.UpdateResultResponse;

import io.agroal.api.AgroalDataSource;

// update records implementations
@RequestScoped
public class RecordUpdateServiceImpl implements RecordUpdateService {

	public static final String UPDATE_QUERY = "UPDATE employee SET employeeFirstName = ?, employeeLastName = ?, designation = ?, department = ?, salary = ? WHERE employeeId = ?";

	@Inject
	AgroalDataSource client;

	@Override
	public UpdateResultResponse RecordUpdateServiceMethod(RequestEvent requestEvent) {
		UpdateResultResponse responseBody = new UpdateResultResponse();
		try (Connection connection = client.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
			statement.setString(1, requestEvent.getEmployeeFirstName());
			statement.setString(2, requestEvent.getEmployeeLastName());
			statement.setString(3, requestEvent.getDesignation());
			statement.setString(4, requestEvent.getDepartment());
			statement.setString(5, requestEvent.getSalary());
			statement.setString(6, requestEvent.getEmployeeId());
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				responseBody.setStatus("SUCCESS");
				responseBody.setMessage("Employee record updated successfully");
			} else {
				responseBody.setStatus("FAILED");
				responseBody.setMessage("Employee record update failed");
			}
		} catch (SQLException e) {
			responseBody.setStatus("FAILED");
			responseBody.setMessage("Employee record update failed due to an internal error");
			e.printStackTrace();
		}
		return responseBody;
	}

}
