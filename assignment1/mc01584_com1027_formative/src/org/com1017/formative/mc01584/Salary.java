package org.com1017.formative.mc01584;

/**
 * @author Max Carter
 * @since 19/10/2019
 */
public class Salary {
    //Defining constants for tax rates.
    private static final int PERSONAL_ALLOWANCE_DEFAULT = 9440;
    private static final int PERSONAL_ALLOWANCE_SECOND_THRESHOLD = 10500;
    private static final int PERSONAL_ALLOWANCE_THIRD_THRESHOLD = 10660;
    private static final int PERSONAL_ALLOWANCE_SECOND_AGE = 65;
    private static final int PERSONAL_ALLOWANCE_THIRD_AGE = 75;
    private static final int TAX_LOWER_THRESHOLD = 32010;

    private static final double TAX_RATE_LOWER = 0.2;
    private static final double TAX_RATE_HIGHER = 0.4;


    /** The salary of an employee. */
    private double salary = 0;

    /** Creates a new salary. */
    public Salary() { }

    /**
     * Creates a new salary with a starting value {@code salary}.
     * @param salary
     */
    public Salary(double salary) {
        setSalary(salary);
    }

    /**
     * Sets the salary to {@code salary}.
     * @param salary New salary.
     */
    public void setSalary(double salary) {
    	if (salary >= 0) {
            this.salary = salary;
    	}
    }

    /**
     * Gets the salary.
     * @return The salary.
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Calculates the tax rate which would be applied to the salary instance.
     * @return The amount of tax which will be applied.
     */
    public double calculateTax(int age) {
    	//Returns 0 straight away if the employee earns below the allowance.
        if (salary <= PERSONAL_ALLOWANCE_DEFAULT) {
            return 0;
        }

        //Checks to see if the age of the employee makes them able to have a reduction on their taxes.
    	int taxAllowanceUsed = PERSONAL_ALLOWANCE_DEFAULT;
    	
    	if (age >= PERSONAL_ALLOWANCE_SECOND_AGE && age < PERSONAL_ALLOWANCE_THIRD_AGE) {
    		taxAllowanceUsed = PERSONAL_ALLOWANCE_SECOND_THRESHOLD;
    	} else if (age >= PERSONAL_ALLOWANCE_THIRD_AGE) {
    		taxAllowanceUsed = PERSONAL_ALLOWANCE_THIRD_THRESHOLD;
    	}
        
    	//Reduce the taxable amount of money.
        double salaryLeftover = this.salary - taxAllowanceUsed;
        double taxableSalary = 0;

        if (salaryLeftover <= TAX_LOWER_THRESHOLD) {
        	//Returns the taxable salary at the lower threshold.
            return salaryLeftover*TAX_RATE_LOWER;
        } else {
        	//Taxes employee at mid tax range.
            taxableSalary+=TAX_LOWER_THRESHOLD*TAX_RATE_LOWER;
            salaryLeftover-= TAX_LOWER_THRESHOLD;
        }

        //Returns salary with the higher tax rate applied.
        return (salaryLeftover*TAX_RATE_HIGHER) + taxableSalary;
    }

}