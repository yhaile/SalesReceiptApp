package salesReceipt.OrderProcessing;

import java.util.ArrayList;
import salesReceipt.Products.*;

/**
 * Order class instantiated for each complete shopping basket.
 * @author yhaile
 *
 */
public class Order {
	
	// List of Items in shopping basket
	private ArrayList<Product> orderList;
	
	// Order constructor
	public Order() {
		orderList = new ArrayList<Product>();
	}
	
	/** 
	 * Adds product items to order
	 * @param product
	 */
	public void addToOrder(Product product)	{
		orderList.add(product);
	}
	
	/** 
	 * Method gets an order when complete 
	 *  @return orderList
	 */
	public ArrayList<Product> getCompleteOrder() {
		return orderList;
	}
	
}