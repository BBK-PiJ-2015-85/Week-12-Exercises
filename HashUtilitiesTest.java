import org.junit.*;
import static org .junit.Assert.*;
import java.util.Random;

public class HashUtilitiesTest {
	@Test
	public void testsShortHash() {
		HashUtilities hashTest = new HashUtilities();
		Random rand = new Random();
		int input;
		int output;
		for (int i = 0; i <= 2000; i++) {
			input = rand.nextInt(100000000);
			output = hashTest.shortHash(input);
			assertTrue("blaaa",output <= 1000);
			assertTrue(output >= 0);
		}
		
		output = hashTest.shortHash(-1);
		assertTrue(output <= 1000 && output >= 0);
		
		output = hashTest.shortHash(0);
		assertTrue(output <= 1000 && output >= 0);
		
		output = hashTest.shortHash(1000);
		assertTrue(output <= 1000 && output >= 0);
		
		output = hashTest.shortHash(1001);
		assertTrue(output <= 1000 && output >= 0);
		
		output = hashTest.shortHash(-1000);
		assertTrue(output <= 1000 && output >= 0);
		
	}
}