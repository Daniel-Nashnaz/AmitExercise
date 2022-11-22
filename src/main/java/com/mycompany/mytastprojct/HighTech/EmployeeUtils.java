package com.mycompany.mytastprojct.HighTech;

import java.util.Random;

/**
 * A utility class containing static methods used to generate random employee
 * objects for the Company simulation
 *
 */
public class EmployeeUtils {

    private static final String[] FIRST_NAMES = new String[]{"Uma", "Bill",
        "Sean", "Rita", "Max", "Lucy", "Imen", "Kate", "Shlomo",
        "Jean-Luc", "Taylor", "Antonia", "Juan"};

    private static final String[] LAST_NAMES = {"Ballmer", "Berners-Lee",
        "Brin", "Dorsey", "Filo", "Gates", "Gosling", "Hewlett", "Jobs",
        "Mayer", "Moore", "Noyce", "O'Reilly", "Packard", "Page", "Shwed",
        "Wales", "Wozniak", "Yang", "Zuckerberg",};

    private static final int WEEKLY_WAGE_BASE = 4000;
    private static final int WEEKLY_WAGE_VARIANCE_RANGE = 3500;

    private static final int WAGE_PER_SUBORDINATE_BASE = 2500;
    private static final int WAGE_PER_SUBORDINATE_VARIANCE_RANGE = 1000;

    private static Random rand = new Random();

    private static long id = 300000;

    public static long generateEmployeeId() {
        return ++id;
    }

    public static String generateEmployeeName() {

        return FIRST_NAMES[rand.nextInt(FIRST_NAMES.length)] + " "
                + LAST_NAMES[rand.nextInt(LAST_NAMES.length)];
    }

    public static double generateWeeklyWage() {
        return rand.nextInt(WEEKLY_WAGE_VARIANCE_RANGE) + WEEKLY_WAGE_BASE;
    }

    public static double generateWagePerSubordinate() {
        return rand.nextInt(WAGE_PER_SUBORDINATE_VARIANCE_RANGE)
                + WAGE_PER_SUBORDINATE_BASE;
    }

    public static Programmer.Language generatePrefferedLanguage() {
        Programmer.Language[] values = Programmer.Language
                .values();
        int r = rand.nextInt(values.length);
        return values[r];

    }

    public static Programmer generateRandomProgrammer() {
        Programmer programmer = new Programmer(
                EmployeeUtils.generateEmployeeId(),
                EmployeeUtils.generateEmployeeName(), null,
                EmployeeUtils.generateWeeklyWage(),
                EmployeeUtils.generatePrefferedLanguage());

        return programmer;

    }

    public static QATester generateRandomQATester() {
        QATester tester = new QATester(EmployeeUtils.generateEmployeeId(),
                EmployeeUtils.generateEmployeeName(), null,
                EmployeeUtils.generateWeeklyWage());
        tester.addBugsFound(rand.nextInt(10));

        return tester;

    }

    public static Manager generateRandomManager() {
        Manager manager = new Manager(EmployeeUtils.generateEmployeeId(),
                EmployeeUtils.generateEmployeeName(), null,
                EmployeeUtils.generateWagePerSubordinate());

        return manager;

    }

}
