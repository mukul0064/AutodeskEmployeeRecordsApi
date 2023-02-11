package com.autodesk.service;

//Author's email address: mukul0064@gmail.com

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.autodesk.model.ResponseBody;

import io.agroal.api.AgroalDataSource;

// extract records implementation
@RequestScoped
public class RecordsServiceImpl implements RecordsService {

	public static final String RECORDS_QUERY = "SELECT * FROM autodesk.employee";

	@Inject
	AgroalDataSource client;

	@Override
	public List<ResponseBody> RecordsServiceMethod() {
		List<ResponseBody> result = new ArrayList<>();
		try (Connection connection = client.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(RECORDS_QUERY)) {
			while (resultSet.next()) {
				ResponseBody responseBody = new ResponseBody();
				responseBody.setEmployeeId(resultSet.getString("employeeId"));
				responseBody.setEmployeeFirstName(resultSet.getString("employeeFirstName"));
				responseBody.setEmployeeLastName(resultSet.getString("employeeLastName"));
				responseBody.setDesignation(resultSet.getString("designation"));
				responseBody.setDepartment(resultSet.getString("department"));
				responseBody.setSalary(resultSet.getString("salary"));
				result.add(responseBody);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
