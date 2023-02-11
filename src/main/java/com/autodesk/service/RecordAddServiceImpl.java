package com.autodesk.service;

//Author's email address: mukul0064@gmail.com

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.autodesk.model.RequestEvent;

import io.agroal.api.AgroalDataSource;

// adding records implementation
@RequestScoped
public class RecordAddServiceImpl implements RecordAddService {

	@Inject
	AgroalDataSource client;

	private static final String ADD_EMPLOYEE_QUERY = "INSERT INTO employee (employeeId, employeeFirstName, employeeLastName, designation, department, salary) VALUES (?, ?, ?, ?, ?, ?)";

	@Override
	public String RecordAddServiceMethod(RequestEvent requestEvent) {
		try (Connection conn = client.getConnection();
				PreparedStatement statement = conn.prepareStatement(ADD_EMPLOYEE_QUERY)) {

			statement.setInt(1, Integer.parseInt(requestEvent.getEmployeeId()));
			statement.setString(2, requestEvent.getEmployeeFirstName());
			statement.setString(3, requestEvent.getEmployeeLastName());
			statement.setString(4, requestEvent.getDesignation());
			statement.setString(5, requestEvent.getDepartment());
			statement.setString(6, requestEvent.getSalary());

			int result = statement.executeUpdate();
			if (result > 0) {
				return "Success";
			} else {
				return "Failure";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Failure";
		}
	}
}
