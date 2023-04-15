package main;

import java.math.BigDecimal;

public class Expense {

	public String name;
	public BigDecimal cost, costAsPercentOfPay;
	
	public Expense(String name, BigDecimal cost, BigDecimal costAsPercentOfPay) {
		this.name = name;
		this.cost = cost;
		this.costAsPercentOfPay = costAsPercentOfPay;
	}
	
}
