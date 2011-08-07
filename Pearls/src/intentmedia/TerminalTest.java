package intentmedia;

import junit.framework.TestCase;

public class TerminalTest extends TestCase{
	Terminal terminal = new Terminal();
	
	public TerminalTest(String name){
		super(name);
	}
	
	public void testTotal() {
		terminal.setPricing("A", 2, 4, 7);
		terminal.setPricing("B", 12);
		terminal.setPricing("C", 1.25f, 6, 6);
		terminal.setPricing("D", 0.15f);
		
		terminal.scanMultiple("ABCDABAA");
		assertEquals(32.40f, terminal.total());
		
		terminal.clearOrder();
		terminal.scanMultiple("CCCCCCC");
		assertEquals(7.25f, terminal.total());
		
		terminal.clearOrder();
		terminal.scanMultiple("ABCD");
		assertEquals(15.40f, terminal.total());
	}
		
}
