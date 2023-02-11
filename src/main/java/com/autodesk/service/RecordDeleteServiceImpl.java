package com.autodesk.service;

//Author's email address: mukul0064@gmail.com

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;

import com.autodesk.model.DeleteRequestEvent;

import io.agroal.api.AgroalDataSource;

// deleting records implementation
@RequestScoped
public class RecordDeleteServiceImpl implements RecordDeleteService {

	public static final String DELETE_EMPLOYEE_QUERY = "DELETE FROM employee WHERE employeeId = ?";

	@Inject
	AgroalDataSource client;

	@Override
	public String RecordDeleteServiceMethod(@Valid DeleteRequestEvent deleteRequestEvent) {
		String employeeId = deleteRequestEvent.getEmployeeId();
		String result = "Failure";

		try (Connection connection = client.getConnection();
				PreparedStatement stmt = connection.prepareStatement(DELETE_EMPLOYEE_QUERY)) {
			stmt.setInt(1, Integer.parseInt(employeeId));
			int affectedRows = stmt.executeUpdate();
			if (affectedRows > 0) {
				result = "Success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
