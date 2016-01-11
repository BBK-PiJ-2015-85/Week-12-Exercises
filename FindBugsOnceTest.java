import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class FindBugsOnceTest {
	FindBugsOnce fbo;
	
	@Before
	public void setUp() {
		fbo = new FindBugsOnce();
	}
	
	@Test
	public void testsNameWithSingleSpace() {
		String input = "James Pickles";
		String output = fbo.getInitials(input);
		String expected = "JP";
		assertEquals(output, expected);
	}
	
	@Test
	public void testsNameWithDoubleSpace() {
		String input = "James     Pickles";
		String output = fbo.getInitials(input);
		String expected = "JP";
		assertEquals(output, expected);
	}
	/*
	public static void main(String[] args) {
		FindBugsOnce fbo = new FindBugsOnce();
		System.out.println(fbo.getInitials("James Pickles"));
		System.out.println(fbo.getInitials("James  Pickles"));
	}
	*/
}