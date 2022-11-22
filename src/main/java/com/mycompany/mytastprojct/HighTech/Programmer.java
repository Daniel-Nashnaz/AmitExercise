package com.mycompany.mytastprojct.HighTech;

/**
 * A programmer that gets a weekly wage and has a favorite programming language
 * 
 */
public class Programmer extends TeamMember {
	public enum Language {
		C("C"), CPP("C++"), Java("Java"), Python("Python"), Ruby("Ruby"), None(
				"None");

		private final String displayName;

		private Language(String name) {
			displayName = name;
		}

		@Override
		public String toString() {
			return displayName;
		}
	}

	private Language prefferedLanguage;

	public Programmer(long id, String name, Manager boss, double weeklyWage,
			Language prefferedLanguage) {
		super(id, name, boss, weeklyWage);
		this.prefferedLanguage = prefferedLanguage;
	}

	public Programmer(long id, String name, Manager boss, double weeklyWage) {
		this(id, name, boss, weeklyWage, Language.None);
	}

	public Language getPrefferedLanguage() {
		return prefferedLanguage;
	}

	public void setPrefferedLanguage(Language prefferedLanguage) {
		this.prefferedLanguage = prefferedLanguage;
	}

	@Override
	public String toString() {
		return super.toString() + "\tPreffered language: "
				+ this.prefferedLanguage;
	}

}
