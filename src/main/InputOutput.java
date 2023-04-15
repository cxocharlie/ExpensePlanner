package main;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InputOutput {

	Scanner userInput = new Scanner(System.in);
	ExpenseManager expenseManager = new ExpenseManager();
	
	BigDecimal inputTakeHomePay() {
		System.out.println("Input take home pay");
		BigDecimal takeHomePay = new BigDecimal(userInput.nextLine());
		return takeHomePay; 
	}
	
	void inputExpenses(BigDecimal takeHomePay) {
			
			while(true) {
				System.out.println("Input name of expense");
				String expenseName = userInput.nextLine();
				
				System.out.println("Input cost of expense");
				BigDecimal expenseCost = new BigDecimal(userInput.nextLine()).setScale(2);
				
				BigDecimal expenseCostAsPercentOfPay = expenseCost.divide(takeHomePay).setScale(1, RoundingMode.HALF_DOWN);
				
				expenseManager.addNewExpenseToSumIfAffordable(takeHomePay, new Expense(expenseName, expenseCost, expenseCostAsPercentOfPay ) );
				
				System.out.println("\nWould you like to input another expense? Y/N");
				if(userInput.nextLine().equalsIgnoreCase("N")) {
					break;			
				}
			}
			
		}
		
	void outputExpenses() {
		expenseManager.printListOfExpenses();
	}
	
}
