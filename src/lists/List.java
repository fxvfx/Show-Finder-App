package lists;


public interface List {

	public double calculateTotal();

	public String toString();

	public void addItem();

	public void removeItem();

	public abstract void getNext();

}
