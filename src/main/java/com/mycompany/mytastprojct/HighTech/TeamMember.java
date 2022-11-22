package com.mycompany.mytastprojct.HighTech;

/**
 * A team member that is paid a weekly wage
 */
public class TeamMember extends AbstEmployee {

	private double weeklyWage;

	public TeamMember(long id, String name, Manager boss, double weeklyWage) {
		super(id, name, boss);
		this.weeklyWage = weeklyWage;
	}

	public double getWeeklyWage() {
		return weeklyWage;
	}

	public void setWeeklyWage(double weeklyWage) {
		this.weeklyWage = weeklyWage;
	}

	@Override
	public double getSalary() {
		return weeklyWage;
	}

	@Override
	public String toString() {
		return super.toString()
				+ String.format("\tWeekly wage: %.2f", this.weeklyWage);
	}

}
