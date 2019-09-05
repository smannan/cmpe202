

public class Main {

	public static void main(String[] args) {
		GumballMachine gumballMachine = new GumballMachine(5);

		System.out.println(gumballMachine);

		gumballMachine.addPayment();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);

		gumballMachine.addPayment();
		gumballMachine.turnCrank();
		gumballMachine.addPayment();
		gumballMachine.turnCrank();

		System.out.println(gumballMachine);
	}
}
