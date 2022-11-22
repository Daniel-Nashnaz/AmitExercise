package com.mycompany.mytastprojct.HighTech;

/**
 * Interface for accessing basic fields of a company employee
 */
public interface Employee {

	public long getId();

	public String getName();

	public Employee getBoss();
	
	public double getSalary();
}
