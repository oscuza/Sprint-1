package n1exercici1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonthTest {

	@Test
	public void testSize() {
		Month m=new Month();
		assertEquals(12, m.getSizeList());
	}

	@Test
	public void testNotNull() {
		Month m=new Month();
	assertNotNull(m.getList());
	}

	@Test
	public void testPosAugust() {
		Month m=new Month();
		assertEquals("August",m.getList().get(7) );
		
	}
}
