package com.mycompany.mytastprojct.HighTech;

/**
 * A QA tester that gets a weekly wage and is paid a bonus for each bug found in
 * the current week
 */
public class QATester extends TeamMember {

	public static double bonusPerBugFound = 5; // Same for all QA Testers

	private int bugsFoundThisWeek;

	public QATester(long id, String name, Manager boss, double weeklyWage) {
		super(id, name, boss, weeklyWage);
		resetBugsFound();
	}

	public static double getBonusPerBugFound() {
		return bonusPerBugFound;
	}

	public static void setBonusPerBugFound(double bonusPerBugFound) {
		QATester.bonusPerBugFound = bonusPerBugFound;
	}

	public void addBugsFound(int numOfNewBugsFound) {
		this.bugsFoundThisWeek += numOfNewBugsFound;
	}

	public void resetBugsFound() {
		this.bugsFoundThisWeek = 0;
	}

	/**
	 * The salary of a QA tester is composed of the weekly wage plus the bonus
	 * on each bug found.
	 */
	@Override
	public double getSalary() {
		return super.getSalary() + bugsFoundThisWeek * bonusPerBugFound;
	}

	@Override
	public String toString() {
		return super.toString()
				+ String.format("\tBugs Found: %d", this.bugsFoundThisWeek);

	}

}
