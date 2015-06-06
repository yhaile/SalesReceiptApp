package salesReceipt.Products;

import salesReceipt.OrderProcessing.RoundIT;

/**
 * Parent class for all sale items
 * @author yhaile
 *
 */
public abstract class  Product {
	
	private String productName = "";
	private double price = 0.0, totalPrice = 0.0;
	private int quantity = 1;
	private double totalTaxRate = 0.0;
	private boolean imported = false;
	private boolean locallyExempt = false;
	
	// Constants
	private static double IMPORT_TAX_RATE = 0.05;
	private static double LOCAL_TAX_RATE = 0.10;

	// No parameter constructor
	public Product() {
	
	}
	
	/**
	 * Product constructor
	 * @param productName
	 * @param price
	 * @param totalPrice
	 * @param quantity
	 * @param locallyExempt
	 */
	public Product(String productName, double price, double totalPrice, int quantity, boolean locallyExempt){
		
		this.productName = productName;
		this.price = price;
		this.totalPrice = totalPrice;
		this.quantity = quantity;
		this.locallyExempt = locallyExempt;
		
		// Sets imported products if string "imported"
		if(productName.contains("imported")) {
			this.imported = true;
		}
	}
	
	//Setters
	/**
	 * @param productName
	 */
	public void setProductName(String productName){
		this.productName = productName;
		}
		
	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price * quantity;
	}
				
	/**
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
	/**
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * @return imported
	 */
	public boolean isImported(){
		return imported;
	}
	
	/**
	 * @return locallyExempt
	 */
	public boolean isLocallyExempt(){
		return locallyExempt;
	}
	
	//Getters
	/**
	 * @return productName
	 */
	public String getProductName(){
		return productName;
	}

	/**
	 * @return price
	 */
	public double getPrice(){
		return price;
	}
	
	/**
	 * @return totalPrice
	 */
	public double getTotalPrice(){
		return totalPrice;
	}
	
	/**
	 * @return quantity
	 */
	public int getQuantity(){
		return quantity;
	}
	
	/**
	 * @return totalTaxRate
	 */
	public double getTotalTaxRate() {
		
		// Sets text rates based on whether a product is imported or exempt
		if(isLocallyExempt() == false) {
			totalTaxRate += LOCAL_TAX_RATE;
		}
		if(isImported()) {
			totalTaxRate += IMPORT_TAX_RATE;
		}
		
		return totalTaxRate;
	}
	
	// toString builds receipt lines for individual items
	@Override
	public String toString() {
		return (quantity + " " + productName + ":" + RoundIT.truncate(totalPrice));
	}
	
}
