package jtm.activity09;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

/*- TODO #2
 * Implement Iterator interface with Orders class
 * Hint! Use generic type argument of iterateable items in form: Iterator<Order>
 * 
 * TODO #3 Override/implement public methods for Orders class:
 * - Orders()                — create new empty Orders
 * - add(Order item)            — add passed order to the Orders
 * - List<Order> getItemsList() — List of all customer orders
 * - Set<Order> getItemsSet()   — calculated Set of Orders from list (look at description below)
 * - sort()                     — sort list of orders according to the sorting rules
 * - boolean hasNext()          — check is there next Order in Orders
 * - Order next()               — get next Order from Orders, throw NoSuchElementException if can't
 * - remove()                   — remove current Order (order got by previous next()) from list, throw IllegalStateException if can't
 * - String toString()          — show list of Orders as a String
 * 
 * Hints:
 * 1. To convert Orders to String, reuse .toString() method of List.toString()
 * 2. Use built in List.sort() method to sort list of orders
 * 
 * TODO #4
 * When implementing getItemsSet() method, join all requests for the same item from different customers
 * in following way: if there are two requests:
 *  - ItemN: Customer1: 3
 *  - ItemN: Customer2: 1
 *  Set of orders should be:
 *  - ItemN: Customer1,Customer2: 4
 */

public class Orders implements Iterator<Order> {
	List<Order> itemsList = new LinkedList<Order>();
	ListIterator<Order> elements = itemsList.listIterator();
	int currentIndex = 1;

	String customer; // Name of the customer
	String name; // Name of the requested item
	int count; // Count of the requested items

	Order current = new Order(customer, name, count);

	public Orders() {
		itemsList = new LinkedList<Order>();
	}

	public void add(Order item) {
		elements.add(item);
	}

	public List<Order> getItemsList() {
		// TODO— List of all customer orders
		return itemsList;
	}

	public Set<Order> getItemsSet() {
		// TODO— calculated Set of Orders from list
//		 * When implementing getItemsSet() method, join all requests for the same item from different customers
//		 * in following way: if there are two requests:
//		 *  - ItemN: Customer1: 3
//		 *  - ItemN: Customer2: 1
//		 *  Set of orders should be:
//		 *  - ItemN: Customer1,Customer2: 4
		HashSet<Order> res = new HashSet<Order>();
		
		return res;
	}

	public void sort() {
//TODO   — sort list of orders according to the sorting rules
		// Use built in List.sort() method to sort list of orders
//		List.sort(elements);
	}

	public void remove() {
//TODO — remove current Order (order got by previous next()) from list, throw IllegalStateException if can't
		try {
			elements.remove();
		} catch (IllegalStateException e) {
			throw e;
		}
	}

	@Override
	public boolean hasNext() {
		while (elements.hasNext()) {
			return true;
		}
		return false;
	}

	@Override
	public Order next() {
		if (!elements.hasNext()) {
			throw new NoSuchElementException();
		} else {
			return elements.next();
		}
	}

	@Override
	public String toString() {
		return ".*" + itemsList.toString();
	}

	/*-
	 * TODO #1
	 * Create data structure to hold:
	 *   1. some kind of collection of Orders (e.g. some List)
	 *   2. index to the current order for iterations through the Orders in Orders
	 *   Hints:
	 *   1. you can use your own implementation or rely on .iterator() of the List
	 *   2. when constructing list of orders, set number of current order to -1
	 *      (which is usual approach when working with iterateable collections).
	 */
}
