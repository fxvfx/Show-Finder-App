package tickets;


/**
 * Specifies the methods needed for a CartList
 * @author Francis Villanueva
 *
 */
abstract class CartList<T> {
	/**
	 * calculates total price of everything in the List
	 * @return: total price
	 */
	public abstract double calculateTotal();

	/**
	 * returns a String representation of the List
	 * @return: a String representation of the list
	 */
	public abstract String toString();

	/**
	 * adds an item to the List
	 */
	public abstract void addItem();

	/**
	 * removes an item to the List
	 */
	public abstract void removeItem();
}
