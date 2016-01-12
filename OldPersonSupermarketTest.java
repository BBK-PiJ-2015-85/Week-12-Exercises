import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OldPersonSupermarketTest {
	PersonQueue pq;
	Person jim, sue, tess;
	
	@Before
	public void setUp() {
		pq = new OldPersonSupermarket();
		jim = new Person("Jim", 30);
		sue = new Person("Sue", 34);
		tess = new Person("Tess", 50);
	}
	
	@Test
	public void retrievesAPersonFromEmptyQueue() {
		assertNull(pq.retrieve());
	}
	
	@Test
	public void insertsTwoPeopleToQueueAndRetrivesOne() {
		pq.insert(jim);
		pq.insert(sue);
		assertEquals(sue, pq.retrieve());
	}
	
	@Test
	public void insertOnePersonToQueueAndRetrieveThem() {
		pq.insert(jim);
		assertEquals(jim, pq.retrieve());
	}
	
	@Test
	public void insertThreePeopleToQueueAndRetieveTwo() {		
		pq.insert(jim);
		pq.insert(sue);
		pq.insert(tess);
		assertEquals(tess, pq.retrieve());
		assertEquals(sue, pq.retrieve());		
	}
	
	@Test
	public void insertTwoPeopleAndRetrieveThree() {
		pq.insert(jim);
		pq.insert(sue);
		assertEquals(sue, pq.retrieve());
		assertEquals(jim, pq.retrieve());	
		assertNull(pq.retrieve());
	}
}