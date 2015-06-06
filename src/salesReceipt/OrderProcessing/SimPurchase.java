package salesReceipt.OrderProcessing;

import java.util.Properties;

/**
 * This class simulates a purchase(recieves items like a shopping cart)
 * @author yhaile
 *
 */
public class SimPurchase {
	
	Properties properties;
	Order order;
	ProcessOrder processOrder;
	
	// SimPurchas constructor
	public SimPurchase() {
	    order = new Order();
	    processOrder = new ProcessOrder();
	}
	
	/**
	 * @param order
	 */
	public void processOrder(Order order) {
	 		processReceipt(order);
	}
	
	/**
	 * Completes purchase and initiates processing.
	 * @param order
	 */
	public void processReceipt(Order order) {
		processOrder.processCompleteOrder(order);
		
	}
	
	/**
	 * @return order
	 */
	public Order getOrder()	{
		return order;
	}
}