package com.mycompany.mytastprojct.HighTech;

import java.util.HashSet;
import java.util.Set;

/**
 * A Manager with subordinates who has a salary per subordinate.
 */
public class Manager extends AbstEmployee {

	private final static double DEFAULT_WAGE_PER_SUBORDINATE = 50;

	private Set<Employee> subordinates;

	private double wagePerSubordinate;

	public Manager(long id, String name, Manager boss, double wagePerSubordinate) {
		super(id, name, boss);
		this.wagePerSubordinate = wagePerSubordinate;
		this.subordinates = new HashSet<Employee>();
	}

	public Manager(long id, String name, Manager boss) {
		this(id, name, boss, DEFAULT_WAGE_PER_SUBORDINATE);
	}

	public Set<Employee> getSubordinates() {
		return subordinates;
	}

	public void addSubordinate(Employee newSubordinate) {
		this.subordinates.add(newSubordinate);
	}

	public void removeSubordinate(Employee subordinate) {
		this.subordinates.remove(subordinate);
	}

	public boolean isSubordinate(Employee subordinate) {
		return this.subordinates.contains(subordinate);
	}

	public double getWagePerSubordinate() {
		return wagePerSubordinate;
	}

	public void setWagePerSubordinate(double wagePerSubordinate) {
		this.wagePerSubordinate = wagePerSubordinate;
	}

	@Override
	public double getSalary() {
		return this.subordinates.size() * this.wagePerSubordinate;
	}

	@Override
	public String toString() {
		return super.toString()
				+ String.format("\tNumber of subbordinates: %s",
						this.subordinates.size());
	}

}
