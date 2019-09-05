

public class NoPaymentState implements State {
    GumballMachine gumballMachine;
 
    public NoPaymentState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
 
	public void insertCoin() {
		System.out.println("You inserted payment");
		gumballMachine.setState(gumballMachine.getHasPaymentState());
	}
 
	public void ejectCoin() {
		System.out.println("You haven't inserted payment");
	}
 
	public void turnCrank() {
		System.out.println("You turned, but there's no quarter");
	 }
 
	public void dispense() {
		System.out.println("You need to pay first");
	} 
 
	public String toString() {
		return "waiting for payment";
	}
}
