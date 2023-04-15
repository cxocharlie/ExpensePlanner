package main;

public class Main {

	
	public static void main(String[] args) {  
		
		InputOutput io = new InputOutput();
		
		io.inputExpenses( io.inputTakeHomePay() );
		io.outputExpenses();
	}

}
