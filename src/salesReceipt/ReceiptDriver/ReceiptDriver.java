package salesReceipt.ReceiptDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import salesReceipt.OrderProcessing.*;
import salesReceipt.Products.LocallyExempt;
import salesReceipt.Products.LocallyNonExemptItem;
import salesReceipt.Products.Product;

/**
 * Driver class for SalesReceiptApp
 * @author yhaile
 *
 */
public class ReceiptDriver {

	// Main method for app	
	public static void main(String[] args) {
		
		// 3 purchases are triggered with 3 Instances of the order object
		Order order1 = new Order();
		Order order2 = new Order();
		Order order3 = new Order();
		
		Properties prop = new Properties();
	 	InputStream input = null;
		Product product;
		SimPurchase purchase = new SimPurchase();
		
		try {
			  
	 		input = new FileInputStream("config/shoppingBaskets.properties");
	 		// load a properties file with 3 shopping baskets orders
	 		prop.load(input);
	 		// Order1
	 		product = new LocallyExempt(prop.getProperty("basket.one.item_one.name"), Double.valueOf(prop.getProperty("basket.one.item_one.price")), Double.valueOf(prop.getProperty("basket.one.item_one.price")), Integer.valueOf(prop.getProperty("basket.one.item_one.quantity")));
	 		order1.addToOrder(product);
	 		product = new LocallyNonExemptItem(prop.getProperty("basket.one.item_two.name"), Double.valueOf(prop.getProperty("basket.one.item_two.price")), Double.valueOf(prop.getProperty("basket.one.item_two.price")), Integer.parseInt(prop.getProperty("basket.one.item_two.quantity")));
	 		order1.addToOrder(product);
	 		product = new LocallyExempt(prop.getProperty("basket.one.item_three.name"), Double.valueOf(prop.getProperty("basket.one.item_three.price")), Double.valueOf(prop.getProperty("basket.one.item_three.price")), Integer.parseInt(prop.getProperty("basket.one.item_three.quantity")));
	 		order1.addToOrder(product);
	 		
	 		// Initiate purchase
	 		purchase.processReceipt(order1);
	 		
	 		// Order2
	 		product = new LocallyExempt(prop.getProperty("basket.two.item_one.name"), Double.valueOf(prop.getProperty("basket.two.item_one.price")), Double.valueOf(prop.getProperty("basket.two.item_one.price")), Integer.valueOf(prop.getProperty("basket.two.item_one.quantity")));
	 		order2.addToOrder(product);
	 		product = new LocallyNonExemptItem(prop.getProperty("basket.two.item_two.name"), Double.valueOf(prop.getProperty("basket.two.item_two.price")), Double.valueOf(prop.getProperty("basket.two.item_two.price")), Integer.parseInt(prop.getProperty("basket.two.item_two.quantity")));
	 		order2.addToOrder(product);
	 		
	 		//Initiate purchase
	 		purchase.processReceipt(order2);
	 		
	 		//Order3	
	 		product = new LocallyNonExemptItem(prop.getProperty("basket.three.item_one.name"), Double.valueOf(prop.getProperty("basket.three.item_one.price")), Double.valueOf(prop.getProperty("basket.three.item_one.price")), Integer.valueOf(prop.getProperty("basket.three.item_one.quantity")));
	 		order3.addToOrder(product);
	 		product = new LocallyNonExemptItem(prop.getProperty("basket.three.item_two.name"), Double.valueOf(prop.getProperty("basket.three.item_two.price")), Double.valueOf(prop.getProperty("basket.three.item_two.price")), Integer.parseInt(prop.getProperty("basket.three.item_two.quantity")));
	 		order3.addToOrder(product);
	 		product = new LocallyExempt(prop.getProperty("basket.three.item_three.name"), Double.valueOf(prop.getProperty("basket.three.item_three.price")), Double.valueOf(prop.getProperty("basket.three.item_three.price")), Integer.parseInt(prop.getProperty("basket.three.item_three.quantity")));
	 		order3.addToOrder(product);
	 		product = new LocallyExempt(prop.getProperty("basket.three.item_four.name"), Double.valueOf(prop.getProperty("basket.three.item_four.price")), Double.valueOf(prop.getProperty("basket.three.item_four.price")), Integer.parseInt(prop.getProperty("basket.three.item_four.quantity")));
	 		order3.addToOrder(product); 		
	 		
	 		// Initiate purchase
	 		purchase.processReceipt(order3);
	
		} catch (IOException ex) {
	 		ex.printStackTrace();
	 	} finally {
	 		if (input != null) {
	 			try {
	 				input.close();
	 			} catch (IOException e) {
	 				e.printStackTrace();
	 			}
	 		}
	 	}
	}
}