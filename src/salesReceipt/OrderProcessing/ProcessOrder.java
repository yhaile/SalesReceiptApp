package salesReceipt.OrderProcessing;

import java.util.ArrayList;
import salesReceipt.Products.Product;

/**
 *  Order processisng class functions like shopping cart checkout
 * @author yhaile
 *
 */
public class ProcessOrder {
	
	ArrayList<Product> productList = new ArrayList<Product>();
	Receipt receipt;
	
	/**
	 * This methods intiates checkout and processes complete orders
	 * @param order
	 */
	public void processCompleteOrder(Order order){

		productList = order.getCompleteOrder();
	
		for(Product product : productList) {
			product.setTotalPrice(product.getQuantity() * (product.getPrice() +  RoundIT.roundup(product.getPrice() * product.getTotalTaxRate())));
		} 
		printReceipt(getReceipt());
	}
	
	/**
	*  Retrieves Receipt for order
	* @return Receipt
	*/
	public Receipt getReceipt()	{
	
		double totalTax = 0.0;
		double totalAmount = 0.0;
		
		for(Product product : productList) {
			totalTax += (product.getTotalPrice() - (product.getQuantity() * product.getPrice()));
			totalAmount += product.getTotalPrice();
		}
				
		receipt = new Receipt(productList, totalTax, totalAmount);
		return receipt;
	}
	
	/**
	 * Prints individual order receipt
	 * @param receipt
	 */
	public void printReceipt(Receipt receipt) {
		String output = receipt.toString();
		System.out.println(output);
	}

}