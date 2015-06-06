package salesReceipt.Products;

/**Class for locally non-exempt items
 * @author yhaile
 *
 */
public class LocallyNonExemptItem extends Product {
	
	// Child class constructor
	public LocallyNonExemptItem() {
		super();
	}
	
	/**
	 * @param productName
	 * @param price
	 * @param totalPrice
	 * @param quantity
	 */
	public LocallyNonExemptItem(String productName, double price, double totalPrice, int quantity){
		
		// Super class is called and false is passed as last param for non-exempt
		super(productName, price, totalPrice, quantity, false);
		
	}

}
