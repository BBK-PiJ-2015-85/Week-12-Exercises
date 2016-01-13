import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

public class CircularPatientTest {
	CircularPatient start, jim, tim, sue, ben, bob;
	
	@Before
	public void setUp() {
		start = null;
		jim = new CircularPatient("Jim");
		tim = new CircularPatient("Tim");
		sue = new CircularPatient("Sue");
		ben = new CircularPatient("Ben");
		bob = new CircularPatient("Bob");		
	}
	
	@Test
	public void testsAddTwo() {
		start = jim;
		start.addPatient(tim);
		assertEquals("Jim, Tim", start.toString());
	}
	
	@Test
	public void testsAddTwoDeleteLast() {
		start = jim;
		start.addPatient(tim);
		start.deletePatient("Tim");
		assertEquals("Jim", start.toString());
	}
	
	@Test
	public void testsAddTwoDeleteFirst() {
		start = jim;
		start.addPatient(tim);
		start = start.getNextPatient();
		start.deletePatient("Jim");
		assertEquals("Tim", start.toString());
	}
	
	@Test
	public void testsAddOneDeleteOne() {
		start = jim;
		start = null;
		assertNull(start);
	}
	
	@Test
	public void testsAddThreeDeleteLast() {
		start = jim;
		start.addPatient(tim);
		start.addPatient(sue);
		assertEquals("Jim, Tim, Sue", start.toString());
		start.deletePatient("Sue");
		assertEquals("Jim, Tim", start.toString());
	}
	
	@Test
	public void testsDeleteNonExistentPatient() {
		start = jim;
		start.addPatient(tim);
		start.addPatient(sue);
		start.deletePatient("Ben");
		assertEquals("Jim, Tim, Sue", start.toString());
	}
	
	@Test
	public void testsLastPatientPointingToFirst() {
		start = jim;
		start.addPatient(tim);
		start.addPatient(sue);
		assertEquals(jim, sue.getNextPatient());
	}
	
	@Test
	public void testsAddFiveDeleteFive() {
		start = jim;
		start.addPatient(tim);
		start.addPatient(sue);
		start.addPatient(ben);
		start.addPatient(bob);
		assertEquals("Jim, Tim, Sue, Ben, Bob", start.toString());
		start.deletePatient("Ben");
		assertEquals("Jim, Tim, Sue, Bob", start.toString());
		start.deletePatient("Tim");
		assertEquals("Jim, Sue, Bob", start.toString());
		start = start.getNextPatient();
		start.deletePatient("Jim");
		assertEquals("Sue, Bob", start.toString());
		assertEquals(sue, bob.getNextPatient());
		start.deletePatient("Bob");
		assertEquals("Sue", start.toString());
		start = null;
		assertNull(start);
	}
}