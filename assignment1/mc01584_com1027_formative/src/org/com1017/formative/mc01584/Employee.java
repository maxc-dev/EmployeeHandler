package org.com1017.formative.mc01584;

/**
 * @author Max Carter
 * @since 19/10/2019
 */
public class Employee {
	/** The minimum salary required for a bonus. */
	public static final int BONUS_THRESHOLD = 40000;
	
	/** Regex required of the capital letter. */
	public static final String REGEX_CAPITAL_LETTER = "^[A-Z]+";
	
    /** ID of the employee. */
    private int id;

    /** Name of the employee. */
    private String forename = null, surname = null;

    /** The salary object of the employee. */
    private Salary salary = null;

    /** The position the employee has in the company. */
    private CompanyPosition companyPosition = null;
    
    /** The age of the employee. */
    private int age = 0;

    /**
     * Creates a new employee.
     * @param id                The unique identification of the employee.
     * @param forename          The forename of the employee.
     * @param surname           The surname of he employee.
     * @param salary            The employee's salary.
     * @param companyPosition   The position the employee has in the company.
     * @param age				The age of the employee.
     */
    public Employee(int id, String forename, String surname, Salary salary, CompanyPosition companyPosition, int age) {
    	this.id = id;
        this.forename = capitaliseName(forename); 
        this.surname = capitaliseName(surname);
        this.salary = salary;
        this.companyPosition = companyPosition;
        if (age > 0) {
        	this.age = age;
        }
    }

    /**
     * Uses a regular expression to determine if the name starts with a capital letter.
     * @param name  Name to check.
     * @return 		Returns true if the name starts wtih a capital letter.
     */
    private boolean isNameCapitalised(String name) {
    	return name.matches(REGEX_CAPITAL_LETTER);
    }
    
    /**
     * Checks if a name is capitalised.
     * @param name  Name to check.
     * @return		The name begging with a capital letter.
     */
    private String capitaliseName(String name) {
    	if (isNameCapitalised(name)) {
    		//The name is returned straight away if it has a capital letter.
    		return name;
    	} else {
    		//The name ha the first character upper cased.
    		return name.substring(0, 1).toUpperCase() + name.substring(1);
    	}
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
        return getSalary() >= BONUS_THRESHOLD;
    }
    
    /**
     * Gets the age of the employee.
     * @return Employee's age.
     */
    public int getAge() {
    	return age;
    }

    @Override
    public String toString() {
    	//Creates a string buffer object and appends employee data
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append(getSurname());
    	stringBuffer.append(", ");
    	stringBuffer.append(getForename());
    	stringBuffer.append(" (");
    	stringBuffer.append(getId());
    	stringBuffer.append("): ");
    	
    	//Position and salary are displayed here
    	stringBuffer.append(getPositionName());
    	stringBuffer.append(" at £");
    	stringBuffer.append(getSalary());
    	
    	//Determines if employee is eligible for bonus
    	stringBuffer.append(" (£");
    	stringBuffer.append(salary.calculateTax(getAge()));
    	stringBuffer.append(" tax) and is ");
    	stringBuffer.append(eligibleForBonus() ? "" : "not ");
    	stringBuffer.append("eligible for bonus.");
    	
    	//Return the built string buffer.
        return stringBuffer.toString();
    }
}