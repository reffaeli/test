import com.sun.org.apache.bcel.internal.generic.NEW;

import junit.framework.Assert;
import junit.framework.TestCase;


public class MoneyTest extends TestCase {

	private Money m12chf;
	private Money m14chf;
	
	public MoneyTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		m12chf= new Money(12,"CHF");
		m14chf= new Money(14,"CHF");
	}

	
	public void testAdd() {
		Money expected= new Money(26,"CHF");
		Money result= (Money)m12chf.add(m14chf);
		Assert.assertTrue(expected.equals(result));
	}
	public void testSimpleAdd(){
		
		Money expected= new Money(26,"CHF");
		Money result= (Money)m12chf.add(m14chf);
		Assert.assertTrue(expected.equals(result));
	}

	
	public void testEquals() {
		//Money m12chf = new Money(12, "chf");
		
		// Money m14chf  = new Money(14,"chf");
		///Assert.assertFalse(condition);
		Assert.assertTrue(m12chf.equals(new Money(12, "CHF"))); /*test 1 of equals()*/
		Assert.assertTrue(!m12chf.equals(null)); 				/*test 2 of equals()*/
		Assert.assertTrue(!m12chf.equals(m14chf));				/*test 3 of equals()*/
	}
}
