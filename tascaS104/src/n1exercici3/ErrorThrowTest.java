package n1exercici3;



import org.junit.Test;

public class ErrorThrowTest {

	@Test(expected=IndexOutOfBoundsException.class)
	public void testErrorThrow() {
		ErrorThrow ethrow= new ErrorThrow();
		ethrow.setNum(9,3);
		
	}

}
