package com.mycompany.mytastprojct.HighTech;

/**
 * Represents an abstract company employee implementing the IEmployee interface
 * except the salary computation
 */
public abstract class AbstEmployee implements Employee {

	private long id;

	private String name;

	private Manager boss;
 
	public AbstEmployee(long id, String name, Manager boss) {
		super();
		this.id = id;
		this.name = name;
		this.boss = boss;
	}

	public abstract double getSalary();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Manager getBoss() {
		return boss;
	}

	/**
	 * Sets a new boss for the employee. Removes the employee from the
	 * subordinates of the old boss, and adds the employee as a subordinate of
	 * the new boss.
	 * 
	 * @param boss
	 *            the new boss
	 */
	public void setBoss(Manager boss) {
		if (getBoss() != null) {
			getBoss().removeSubordinate(this);
		}
		this.boss = boss;
		if (getBoss() != null) {
			getBoss().addSubordinate(this);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (getId() != other.getId())
			return false;
		return true;
	}

	public String toString() {
		return String.format(
				"ID: %10d\t\tName: %s\t\tBoss Name: %s\t\tSalary: %.2f",
				getId(), getName(), getBoss() != null ? getBoss().getName()
						: "None", getSalary());
	}

}
