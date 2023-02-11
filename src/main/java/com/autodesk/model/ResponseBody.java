package com.autodesk.model;

//Author's email address: mukul0064@gmail.com

import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ResponseBody {

	@NotEmpty()
	@NotNull()
	@Pattern(regexp = "^[1-9][0-9]{3}$", message = "Employee ID. Must be 4 digit positive number greater than 999.")
	String employeeId;
	@NotEmpty()
	@NotNull()
	String employeeFirstName;
	@NotEmpty()
	@NotNull()
	String employeeLastName;
	@NotEmpty()
	@NotNull()
	String designation;
	@NotEmpty()
	@NotNull()
	String department;
	@NotEmpty()
	@NotNull()
	String salary;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "ResponseBody [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName
				+ ", employeeLastName=" + employeeLastName + ", designation=" + designation + ", department="
				+ department + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, designation, employeeFirstName, employeeId, employeeLastName, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseBody other = (ResponseBody) obj;
		return Objects.equals(department, other.department) && Objects.equals(designation, other.designation)
				&& Objects.equals(employeeFirstName, other.employeeFirstName)
				&& Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeLastName, other.employeeLastName) && Objects.equals(salary, other.salary);
	}

}
