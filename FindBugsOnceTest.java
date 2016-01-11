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
	public void testsNameWithMiddleNameSingleSpace() {
		String input = "James Graeme Pickles";
		String output = fbo.getInitials(input);
		String expected = "JGP";
		assertEquals(output, expected);
	}
	
	@Test
	public void testsNameWithManySpaces() {
		String input = "James     Pickles";
		String output = fbo.getInitials(input);
		String expected = "JP";
		assertEquals(output, expected);
	}
	
	@Test
	public void testsNameWithMiddleNameManySpaces() {
		String input = "James Graeme    Pickles";
		String output = fbo.getInitials(input);
		String expected = "JGP";
		assertEquals(output, expected);
	}
	
	@Test
	public void testsNameWithSpacesAtFront() {
		String input = "  James Graeme Pickles";
		String output = fbo.getInitials(input);
		String expected = "JGP";
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