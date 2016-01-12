import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;

public class ArrayStringStackTest {
	StringStack ss;
	
	@Before
	public void setUp() {
		ss = new ArrayStringStack();
	}
	
	@Test
	public void testsIfStackIsEmpty() {
		boolean output = ss.isEmpty();
		assertTrue(output == true);
	}	
	
	public void testsAddingElementsToStack() {
		ss.push("1");
		assertEquals("1", ss.peek());
		ss.push("2");
		assertEquals("2", ss.peek());
		ss.push("3");
		assertEquals("3", ss.peek());
	}
		
	@Test
	public void testsRemovingAnElementFromStack() {
		ss.push("1"); 
		ss.push("2");
		ss.push("3");
		assertTrue(ss.isEmpty() == false);
		assertEquals("3", ss.pop());
		assertEquals("2", ss.peek());
		assertEquals("2", ss.pop());
		assertEquals("1", ss.peek());
		assertEquals("1", ss.pop());
		assertEquals(null, ss.peek());
		assertTrue(ss.isEmpty() == true);
		assertEquals(null, ss.pop());
	}
	
	@Test
	public void testsLookingAtTopElement() {
		assertEquals(null, ss.peek());
		ss.push("1"); 
		assertEquals(ss.peek(), "1");
		assertTrue(ss.isEmpty() == false);
		ss.push("2");
		assertEquals(ss.peek(), "2");
		ss.push("3");
		assertEquals(ss.peek(), "3");
	}
	
	@Test
	public void pushOneStringThenPeek() {
		ss.push("1");
		assertEquals("1", ss.peek());
	}
	
	@Test
	public void pushThreeStringsThenPeekTop() {
		ss.push("Jim");
		ss.push("Tim");
		ss.push("Ben");
		assertEquals("Ben", ss.peek());
	}
	
	@Test
	public void peekAnEmptyStack() {
		assertNull(ss.peek());
	}
	
	@Test
	public void pushTwoStringsThenPopOne() {
		ss.push("Jim");
		ss.push("Tim");
		assertEquals(ss.pop(), "Tim");
		assertEquals(ss.peek(), "Jim");
	}
	
	@Test
	public void pushTwoStringsThenPopTwo() {
		ss.push("Jim");
		ss.push("Tim");
		assertEquals(ss.pop(), "Tim");
		assertEquals(ss.pop(), "Jim");
		assertTrue(ss.isEmpty());
	}
	
	@Test
	public void popAnEmptyStack() {
		assertNull(ss.pop());
	}
	
	@Test
	public void pushOneStringThenPopOne() {
		ss.push("Jim");
		assertFalse(ss.isEmpty());
		assertEquals(ss.pop(), "Jim");
		assertNull(ss.peek());
		assertTrue(ss.isEmpty());
	}		
}