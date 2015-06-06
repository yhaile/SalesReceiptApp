package salesReceipt.OrderProcessing;

import java.util.ArrayList;
import salesReceipt.Products.*;


/**
 * This class creates a receipt object and builds a receipt 
 * @author yhaile
 *
 */
public class Receipt {

	private ArrayList<Product> productList;
	private double totalSalesTax;
	private double totalPrice;
	
	
	/**
	 * Receipt constructor
	 * @param product
	 * @param tax
	 * @param total
	 */
	public Receipt(ArrayList<Product> product, double tax, double total) {
		productList = product;
		totalSalesTax = tax;
		totalPrice = total;
	}
	
	// Setters
	/**
	 * @param productList
	 */
	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}
	
	/**
	 * @param totalSalesTax
	 */
	public void setTotalSalesTax(double totalSalesTax)	{
		this.totalSalesTax = totalSalesTax;
	}
	
	/**
	 * @param totalAmount
	 */
	public void setTotalAmount(double totalAmount)	{
		this.totalPrice = totalAmount;
	}
	
	/**
	 * @return productList
	 */
	public ArrayList<Product> getProductList() {
		return productList;
	}
	
	// Getters
	/**
	 * @return totalSalesTax
	 */
	public double getTotalSalesTax() {
		return totalSalesTax;
	}
	
	
	/**
	 * @return totalPrice
	 */
	public double getTotalAmount() {
		return totalPrice;
	}
	
	/**
	 * @return
	 */
	public int getTotalNumberOfItems() {
		return productList.size();
	}
	
	// toString builds receipt text
	public String toString() {
		String receipt = "";
		for(Product product: productList) {
			receipt += (product.toString() + "\n");
		}
		
		receipt += "Sales Taxes:" + RoundIT.truncate(totalSalesTax) + "\nTotal:" + RoundIT.truncate(totalPrice) + "\n";
		return receipt;
	}
	
}