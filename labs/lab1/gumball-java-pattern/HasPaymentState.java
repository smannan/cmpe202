

import java.util.Random;

public class HasPaymentState implements State {
	GumballMachine gumballMachine;
 
	public HasPaymentState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
  
	public void insertCoin() {
		System.out.println("You can't insert another quarter");
	}
 
	public void ejectCoin() {
		System.out.println("Payment returned");
		gumballMachine.setState(gumballMachine.getNoPaymentState());
	}
 
	public void turnCrank() {
		System.out.println("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());
	}

    public void dispense() {
        System.out.println("No gumball dispensed");
    }
 
	public String toString() {
		return "waiting for turn of crank";
	}
}
