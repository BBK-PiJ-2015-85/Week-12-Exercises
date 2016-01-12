import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class EmployeeListTest {
	EmployeeList el;
	Employee<String> jim, sue, ben, tim;
	
	@Before
	public void setUp() {
		el = new EmployeeList();
		jim = new <String>Employee("Jim");
		sue = new <String>Employee("Sue");
		ben = new <String>Employee("Ben");
		tim = new <String>Employee("Tim");
	}
	
	@Test
	public void testsAddTwoPeople() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		assertEquals("Jim, Sue", el.toString());
		assertEquals("Sue, Jim", el.toStringBackwards());
	}
	
	@Test
	public void testsAddOneThenDeletesOne() {
		el.addEmployee(jim);
		assertTrue(el.deleteEmployee(jim));
	}
	
	@Test
	public void testsAddTwoThenDeleteTwo() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		assertTrue(el.deleteEmployee(jim));
		assertTrue(el.deleteEmployee(sue));
	}
	
	@Test
	public void testsDeleteFirstElement() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		assertTrue(el.deleteEmployee(sue));
		assertEquals("Jim", el.toString());
	}
	
	@Test
	public void testsAddFourThenDeleteThreee() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		el.addEmployee(ben);
		el.addEmployee(tim);
		assertTrue(el.deleteEmployee(jim));
		assertEquals("Sue, Ben, Tim", el.toString());
		assertTrue(el.deleteEmployee(ben));
		assertEquals("Sue, Tim", el.toString());
		assertTrue(el.deleteEmployee(tim));
		assertEquals("Sue", el.toString());
	}
	
	@Test
	public void testsAddFourThenDeleteHead() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		el.addEmployee(ben);
		el.addEmployee(tim);
		assertTrue(el.deleteEmployee(jim));
		assertEquals("Tim, Ben, Sue", el.toStringBackwards());
	}
	
	@Test
	public void testsAddFourThenDeleteTail() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		el.addEmployee(ben);
		el.addEmployee(tim);
		assertTrue(el.deleteEmployee(tim));
		assertEquals("Ben, Sue, Jim", el.toStringBackwards());
		assertEquals("Jim, Sue, Ben", el.toString());
	}
	
	@Test
	public void testsAddFourThenDeletOneInMiddle() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		el.addEmployee(ben);
		el.addEmployee(tim);
		assertTrue(el.deleteEmployee(ben));
		assertEquals("Tim, Sue, Jim", el.toStringBackwards());
		assertEquals("Jim, Sue, Tim", el.toString());
	}
	
	@Test
	public void testsDeleteItemNotInList() {
		el.addEmployee(jim);
		el.addEmployee(sue);
		assertFalse(el.deleteEmployee(tim));
	}
	
	@Test
	public void testsAddsOneDeletesOneAddsOne() {
		el.addEmployee(jim);
		assertEquals("Jim", el.toString());
		assertTrue(el.deleteEmployee(jim));
		assertEquals("Empty List", el.toString());
		el.addEmployee(sue);
		assertEquals("Sue", el.toStringBackwards());
	}
}