package edu.sussex.coms223.lab7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/*-
 * The class OrderedListTest contains a set of JUnit tests that exercise class
 * OrderedList.
 * 
 * At the beginning of each test, create a local instance of an OrderedList
 * using Integer as the generic template type and the default constructor:
 * 
 *   OrderList<Integer> list = new OrderedList<>();
 *   
 * However, to get 100% code coverage of OrderedList.java, you must use the other
 * constructor in at least one test method:
 * 
 *   OrderList<Integer> list = new OrderedList<>(10);
 * 
 * The following assertion methods should be used to implement your tests:
 * 
 *   assertTrue(condition) 
 *   assertFalse(condition) 
 *   assertEquals(expected value, expression) 
 *   assertThrows(exception class, executable)
 *   assertNull(expression)
 * 
 * Below are some examples taken from the previous labs StackTest.java:
 * 
 *   assertEquals(0, s.size());
 *   assertNull(s.first()); 
 *   assertTrue(s.isEmpty());
 *   assertThrows(NoSuchElementException.class, () -> { s.pop(); });
 * 
 */
class OrderedListTest {

	@Test
	void testEmptySizeAndClear() {
		OrderedList l = new OrderedList();
		OrderedList m = new OrderedList();
		OrderedList n = new OrderedList();
		assertTrue(l.isEmpty());
		l.add(14);
		l.add(17);
		assertTrue(l.size() == 2);
		assertThrows(OrderViolationException.class, () -> {l.add(12);});
		l.clear();
		assertTrue(l.isEmpty());
		assertThrows(IndexOutOfBoundsException.class, () -> {m.add(0, 12);});
		l.add(12);
		assertThrows(OrderViolationException.class, () -> {l.add(0, 13);});
		l.add(12);
		assertThrows(OrderViolationException.class, () -> {l.add(1, 12);});
		assertThrows(OrderViolationException.class, () -> {l.add(1, 7);});
	}

	@Test
	void testAdd() {
		OrderedList l = new OrderedList();
		l.add(17);
		assertTrue(l.elements.size() == 1);
	}

	@Test
	void testInsertGet() {
		OrderedList l = new OrderedList();
		l.add(10);
		l.add(20);
		l.insert(15);
		assertTrue(l.elements.get(1).equals(15));
		assertThrows(OrderViolationException.class, () -> {l.insert(15);});
		assertThrows(IndexOutOfBoundsException.class, () -> {l.get(-1);});
	}

	@Test
	void testRemove() {
		OrderedList<Integer> list = new OrderedList<>(10);
		list.insert(0);
		assertEquals(0, list.get(0));
		list.remove(0);
		assertTrue(list.isEmpty());
		list.insert(1);
		list.remove(Integer.valueOf(1));
		assertTrue(list.isEmpty());
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(-1);
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.remove(10);
		});
		assertThrows(NoSuchElementException.class, () -> {
			list.remove(Integer.valueOf(0));
		});
		list.insert(1);
		assertThrows(NoSuchElementException.class, () -> {
			list.remove(Integer.valueOf(0));
		});
	}

	@Test
	void testFirstNext() {
		OrderedList l = new OrderedList();
		l.add(10);
		l.add(20);
		l.add(30);
		assertTrue(l.first().equals(10));
		l.cursor = 1;
		assertTrue(l.next().equals(30));
		l.clear();
		assertNull(l.first());
		l.add(10);	
		l.first();
		assertNull(l.next());
	}
}
