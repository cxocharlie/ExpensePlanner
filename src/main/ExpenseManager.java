package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class ExpenseManager {

	ArrayList<Expense> listOfExpenses = new ArrayList<>();
	BigDecimal newSumOfExpenses = new BigDecimal(0), sumOfExpenses = new BigDecimal(0);
	
	void printListOfExpenses() {
		for(Expense e : listOfExpenses) {
			System.out.println("\nExpense Name: " + e.name
					+ "\nExpense Cost: " + e.cost
					+ "\nExpense Cost as % of Pay: " + e.costAsPercentOfPay.multiply( new BigDecimal(100) ) + "%");
		}
	}
	
	void createExpenseInList(Expense e) {
		listOfExpenses.add(new Expense(e.name, e.cost, e.costAsPercentOfPay));
		System.out.println("Expense created and added to list");
	}
	
	boolean isExpenseAffordable(BigDecimal takeHomePay) {
		if(newSumOfExpenses.compareTo(takeHomePay) > 0) {
			return false;
		} else {
			return true;
		}
	}
	
	void logNewExpenseAndSum(Expense e, BigDecimal takeHomePay) {
		
		System.out.println("New expense added:\n" + e.name 
				+ " " + e.cost 
				+ " " + e.costAsPercentOfPay.multiply(new BigDecimal(100)) + "%");
		
		System.out.println("Sum of expenses: " + sumOfExpenses);
		System.out.println("Expenses as % of pay: " + sumOfExpenses.multiply(new BigDecimal(100)).divide(takeHomePay).setScale(1, RoundingMode.HALF_DOWN) + "%");
	}
	
	void addNewExpenseToSumIfAffordable(BigDecimal takeHomePay, Expense e) {
		newSumOfExpenses = sumOfExpenses.add(e.cost);
		
		if( isExpenseAffordable(takeHomePay) ) { 
			sumOfExpenses = sumOfExpenses.add(e.cost);
			
			createExpenseInList(e);
			logNewExpenseAndSum(e, takeHomePay);
		} else {
			System.out.println(e.name + " exceeds your budget by " + takeHomePay.subtract(sumOfExpenses));
		}
	}
	
}
