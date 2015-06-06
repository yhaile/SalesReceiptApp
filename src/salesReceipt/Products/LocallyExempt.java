package salesReceipt.Products;

/**
 * Class for Locally Exempt products: books, food, medical items
 * @author yhaile
 *
 */
public class LocallyExempt extends Product {
	
	// Child class constructor
	public LocallyExempt() {
		super();
	}
	
	/**
	 * @param productName
	 * @param price
	 * @param totalPrice
	 * @param quantity
	 */
	public LocallyExempt(String productName, double price, double totalPrice, int quantity){
		super(productName, price, totalPrice, quantity, true);
	}
	
}