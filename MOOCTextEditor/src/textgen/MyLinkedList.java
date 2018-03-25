package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		
		// Initially head points to tail and tail to head (both null)
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Null elements not allowed!");
		} else {
			LLNode<E> newNode = new LLNode<E>(element);
			
			newNode.prev = tail.prev;
			newNode.prev.next = newNode;
			newNode.next = tail;
			tail.prev = newNode;
			size++;
			return true;
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index >= 0 && index < size) {
			LLNode<E> indexNode = head.next;
			
			for (int i = 0; i < index; i++) {
				indexNode = indexNode.next;
			}
			
			return indexNode.data;
		} else {
			throw new IndexOutOfBoundsException("Index not in range!");
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("Null elements not allowed!");
		}
		
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index not in range!");
		}
		
		// List of size N has 0..N-1 indices, so just call add() method
		if (index == size) {
			add(element);
		} else if (index == 0) {
			LLNode<E> newNode = new LLNode<E>(element);
			head.next.prev = newNode;
			newNode.next = head.next;
			head.next = newNode;
			newNode.prev = head;
			size++;
		} else {
			LLNode<E> newNode = new LLNode<E>(element);
			LLNode<E> preIndexNode = head.next;
			
			// Get node at index-1 position
			for (int i = 0; i < index - 1; i++) {
				
				preIndexNode = preIndexNode.next;
				//System.out.println("Iteration " + i + ". Data is " + preIndexNode.data);
			}
			
			LLNode<E> postIndexNode = preIndexNode.next;
			
			preIndexNode.next = newNode;
			newNode.prev = preIndexNode;
			newNode.next = postIndexNode;
			postIndexNode.prev = newNode;
			size++;
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException("Index not in range!");
		} else if (index == 0) {
			E toRemove = head.next.data;
			head.next.next.prev = head;
			head.next = head.next.next;
			size--;
			return toRemove;
		} else if(index == size) {
			E toRemove = tail.prev.data;
			tail.prev.prev.next = tail;
			tail.prev = tail.prev.prev;
			size--;
			return toRemove;
		} else {
			LLNode<E> toRemove = head.next;
			for (int i = 0; i < index; i++) {
				toRemove = toRemove.next;
			}
			
			toRemove.next.prev = toRemove.prev;
			toRemove.prev.next = toRemove.next;
			size--;
			return toRemove.data;
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		
		if (element == null) {
			throw new NullPointerException("Null elements not allowed!");
		}
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Index not in range!");
		} else {
			
			LLNode<E> currentNode = head.next;
			LLNode<E> newNode = new LLNode<E>(element);
			
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
			
			newNode.next = currentNode.next;
			newNode.prev = currentNode.prev;
			newNode.next.prev = newNode;
			newNode.prev.next = newNode;
			
			return currentNode.data;
		}		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
