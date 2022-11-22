package com.mycompany.mytastprojct.HighTech;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

/**
 * Creates simulation of a company with 3 levels: A single CEO, NUM_MANAGERS
 * managers, and NUM_MEMBERS_IN_TEAM members in each team. Prints the top-paid
 * employees at each level.
 */
public class Company {

    private static final int NUM_MANAGERS = 5;
    private static final int NUM_MEMBERS_IN_TEAM = 10;
    private static final double PROPORTION_OF_PROGRAMMERS = 0.5;
    private static final int NUM_TO_PRINT = 3;

    public enum ManagementLevel {
        CEO, Managers, TeamMembers
    }

    public static void main(String[] args) throws FileNotFoundException {
        Map<ManagementLevel, List<Employee>> employees = generateCompanyEmployees();
        printMostPaidEmployeesPerLevel(employees);
    }

    /**
     * Prints to standard output the NUM_TO_PRINT most paid employees at each
     * level of the company hierarchy.
     *
     * @param employees maps each level to a list of employees
     */
    private static void printMostPaidEmployeesPerLevel(
            Map<ManagementLevel, List<Employee>> employees) {

        sortBySalary(employees);

        printTopAtEachLevel(employees);
    }

    /**
     * Prints the NUM_TO_PRINT employees at each level
     *
     * @param employees maps from company levels to employees, assuming that the
     * employees are already sorted in the relevant order
     */
    private static void printTopAtEachLevel(
            Map<ManagementLevel, List<Employee>> employees) {
        for (Entry<ManagementLevel, List<Employee>> entry : employees
                .entrySet()) {
            ManagementLevel level = entry.getKey();
            List<Employee> employeesAtCurrentLevel = entry.getValue();
            int numEmployeesToPrint = Math.min(NUM_TO_PRINT,
                    employeesAtCurrentLevel.size());

            System.out.println(level.toString() + ":");

            for (int i = 0; i < numEmployeesToPrint; i++) {
                System.out.println(employeesAtCurrentLevel.get(i));
            }
        }
    }

    /**
     * Sorts the employees of each level by their salary from high to low
     *
     * @param employees contains the company employees at each level
     */
    private static void sortBySalary(
            Map<ManagementLevel, List<Employee>> employees) {
        for (List<Employee> employeesAtCurrentLevel : employees.values()) {
            Collections.sort(employeesAtCurrentLevel,
                    new Comparator<Employee>() {
                public int compare(Employee e1, Employee e2) {
                    return Double.compare(e2.getSalary(),
                            e1.getSalary());
                }
            });
        }
    }

    /**
     * Creates employees in different levels with random properties.
     *
     * @return the levels of the company with the employees at each level
     */
    private static Map<ManagementLevel, List<Employee>> generateCompanyEmployees() {
        Map<ManagementLevel, List<Employee>> employees = new TreeMap<ManagementLevel, List<Employee>>();

        for (ManagementLevel level : ManagementLevel.values()) {
            employees.put(level, new LinkedList<Employee>());
        }

        Manager ceo = EmployeeUtils.generateRandomManager();
        employees.get(ManagementLevel.CEO).add(ceo);

        generateManagersAndTeams(employees, ceo);
        return employees;
    }

    /**
     * Generates NUM_MANAGERS random managers with their teams. Adds the
     * managers to employees.
     *
     * @param employees a map from the company levels to the list of employees
     * at this level
     * @param ceo the company CEO
     */
    private static void generateManagersAndTeams(
            Map<ManagementLevel, List<Employee>> employees, Manager ceo) {
        for (int i = 0; i < NUM_MANAGERS; i++) {
            Manager newManager = EmployeeUtils.generateRandomManager();
            newManager.setBoss(ceo);
            employees.get(ManagementLevel.Managers).add(newManager);
            generateTeamMembers(employees, newManager);
        }
    }
    /**
     * Generates random employees in a particular team, roughly
     * PROPORTION_OF_PROGRAMMERS of them will be programmers.
     *
     * @param employees a map from the company levels to the list of employees
     * at this level
     * @param manager the team manager
     */
    private static void generateTeamMembers(
            Map<ManagementLevel, List<Employee>> employees, Manager manager) {
        Random rand = new Random();
        for (int j = 0; j < NUM_MEMBERS_IN_TEAM; j++) {
            float r = rand.nextFloat();
            TeamMember newTeamMember;
            if (r < PROPORTION_OF_PROGRAMMERS) {
                newTeamMember = EmployeeUtils.generateRandomProgrammer();
            } else {
                newTeamMember = EmployeeUtils.generateRandomQATester();
            }

            newTeamMember.setBoss(manager);
            employees.get(ManagementLevel.TeamMembers).add(newTeamMember);
        }
    }
}
