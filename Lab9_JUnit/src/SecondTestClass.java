import junit.framework.Assert;
import junit.framework.TestCase;


public class SecondTestClass extends TestCase {
	private Money f12CHF;
    private Money f14CHF;   
    private Money f7USD;
    private Money f21USD;   
    private MoneyBag fMB1;
    private MoneyBag fMB2;
    
    public SecondTestClass(String name) {
		super(name);
	}


	protected void setUp() throws Exception {
		f12CHF = new Money(12, "CHF");
	    f14CHF= new Money(14, "CHF");
	    f7USD=  new Money( 7, "USD");
	    f21USD= new Money(21, "USD");
	    fMB1= new MoneyBag(f12CHF, f7USD);
	    fMB2= new MoneyBag(f14CHF, f21USD);

	}

	public void testBagEquals() {
	    Assert.assertTrue(!fMB1.equals(null));
	    Assert.assertEquals(fMB1, fMB1);
	    Assert.assertTrue(!fMB1.equals(f12CHF));
	    Assert.assertTrue(!f12CHF.equals(fMB1));
	    Assert.assertTrue(!fMB1.equals(fMB2));
	}
	public void testMixedSimpleAdd() { 
	    // [12 CHF] + [7 USD] == {[12 CHF][7 USD]} 
	    Money bag[]= { f12CHF, f7USD }; 
	    MoneyBag expected= new MoneyBag(bag); 
	    Assert.assertEquals(expected, f12CHF.add(f7USD)); 
	}
	public void testSimplify() {
	    // {[12 CHF][7 USD]} + [-12 CHF] == [7 USD]
	    Money expected= new Money(7, "USD");
	    Assert.assertEquals(expected, fMB1.add(new Money(-12, "CHF")));
	}

	

}
