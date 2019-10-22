package org.com1027.formative.mc01584;

/**
 * @author Max Carter
 * @since 19/10/2019
 */
class Employee {
    /** ID of the employee. */
    private int id;

    /** Name of the employee. */
    private String forename = null, surname = null;

    /** The salary object of the employee. */
    private Salary salary = null;

    /** The position the employee has in the company. */
    private CompanyPosition companyPosition = null;

    /**
     * Creates a new employee.
     * @param id                The unique identification of the employee.
     * @param forename          The forename of the employee.
     * @param surname           The surname of he employee.
     * @param salary            The employee's salary.
     * @param companyPosition   The position the employee has in the company.
     */
    public Employee(int id, String forename, String surname, Salary salary, CompanyPosition companyPosition) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
        this.salary = salary;
        this.companyPosition = companyPosition;
    }

    /**
     * Gets the ID of the employee.
     * @return Employee ID.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the forename of the employee.
     * @return Employee forename.
     */
    public String getForename() {
        return forename;
    }

    /**
     * Gets the employee surname.
     * @return Employee surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets the salary of the employee.
     * @return Employee salary.
     */
    public double getSalary() {
        return salary.getSalary();
    }

    /**
     * Gets the position name of the employee.
     * @return Employee's position name.
     */
    public String getPositionName() {
        return companyPosition.getPositionName();
    }

    /**
     * Determines if the employee is eligible for a bonus.
     * @return Returns true if the employee is eligible for a bonus.
     */
    public boolean eligibleForBonus() {
        return false;
    }

    @Override
    public String toString() {
        return getSurname() + ", " + getForename() + " (" + getId() + "): " +
                getPositionName() + " at £" + getSalary() + " (£" + salary.calculateTax() +
                " tax) and is " + (eligibleForBonus() ? "" : "not ") + "eligible for a bonus.";
    }
}
