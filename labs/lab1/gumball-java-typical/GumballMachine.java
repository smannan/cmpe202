
public class GumballMachine
{

    private int num_gumballs;
    private int cost;
    private int current_payment;

    public GumballMachine( int size, int cost )
    {
        // initialise instance variables
        this.num_gumballs = size;
        // how much a gumball costs
        this.cost = cost;
        // how much the user has given
        this.current_payment = 0;
    }
    
    public int getNumGumballs()
    {
        return this.num_gumballs;
    }
    
    public int getCurrentPayment()
    {
        return this.current_payment;
    }

    public void insertCoin(int coin)
    {
        // add the coin value to the user's current payment
        this.current_payment += coin;
    }
    
    public void turnCrank()
    {
    	if ( this.current_payment >= this.cost )
    	{
    		if ( this.num_gumballs > 0 )
    		{
    			this.num_gumballs-- ;
    			this.current_payment -= this.cost;
    			System.out.println( "Thanks for your payment.  Gumball Ejected!" ) ;
    		}
    		else
    		{
    			System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
    		}
    	}
    	else 
    	{
    		System.out.println( "Please insert a coin" ) ;
    	}        
    }
}
