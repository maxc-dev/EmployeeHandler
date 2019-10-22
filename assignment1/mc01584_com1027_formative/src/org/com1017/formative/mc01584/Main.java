package org.com1017.formative.mc01584;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    for (Salary salary : Arrays.asList(new Salary(16475), new Salary(53875), new Salary(100000))) {
            System.out.println(salary.getSalary() + ": " + salary.calculateTax());
        }
    }
}