/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<Integer> list2;
	MyLinkedList<Integer> list3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
		list2 = new MyLinkedList<Integer>();
		list3 = new MyLinkedList<Integer>();
		list3.add(100);
		list3.add(200);
		list3.add(300);
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
		try {
			list1.remove(-11);
			fail("Expected out of bound exception!");
		} catch (IndexOutOfBoundsException e) {
		}
		
		int last = list1.remove(list1.size());
		assertEquals("Check the last element was remove and value was correct: ", 42, last);
		
		list1.add(15);
		list1.add(15);
		list1.add(2, 25);
		list1.add(3, 35);
		int removed = list1.remove(2);
		assertEquals("Remove element at index 2 and check value ", 25, removed);
		assertEquals("Check new element at index 2 is correct ", (Integer) 35, list1.get(2));
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		list2.add(100);
		assertEquals("Add at End: check index 1 is correct ", (Integer) 100, list2.get(0));
		
		list2.add(101);
		list2.add(102);
		assertEquals("Add at End: check index 3 is correct ", (Integer) 102, list2.get(2));
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		list3.add(3, 1);
		assertEquals("Add at the end of list using index: check value ", (Integer) 100, list3.get(0));
		
		list3.add(1, 110);
		list3.add(1, 220);
		assertEquals("Add twice at same index and check latest value", (Integer) 220, list3.get(1));
		assertEquals("Check firstly added value at index+1", (Integer) 110, list3.get(2));
		
		list3.add(0, 0);
		assertEquals("Check element at index 0", (Integer) 0, list3.get(0));
		
		try {
			list3.add(-100, 2);
			fail("Was expecting out of bounds exception!");
		} catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			list3.add(1, null);
			fail("Was expecting null exception!");
		} catch (NullPointerException e) {
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
	    try {
	    		list3.set(-100, 12);
	    		fail("Excepted out of bounds exception here!");
	    } catch (IndexOutOfBoundsException e) {
	    	
	    }
	    
	    int old = list3.set(0, 10);
	    assertEquals("Check old data is correct ", 100, old);
	    assertEquals("Check new data is correct ", (Integer) 10, list3.get(0));
	    
	    old = list3.set(list3.size() - 1, 500);
	    assertEquals("Check old data is correct ", 300, old);
	    assertEquals("Check new data is correct ", (Integer) 500, list3.get(list3.size() - 1));

	}
	
	
	// TODO: Optionally add more test methods.
	
}
