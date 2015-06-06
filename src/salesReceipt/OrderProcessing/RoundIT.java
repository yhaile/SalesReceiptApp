package salesReceipt.OrderProcessing;

import java.text.DecimalFormat;

/**
 * Class performs numeric formating
 * @author yhaile
 *
 */
public class RoundIT {
	
	// Constant
	private static double DECIMAL_VALUE = 0.05;
 
	/**
	 * Method rounds up to the nearest .05
	 * @param value
	 * @return value
	 */
	public static double roundup(double value) {
		
		if((value* 100.0)%5.0  != 0) {
			return (int) ((value / DECIMAL_VALUE) + 1) * DECIMAL_VALUE;
		}
			return value;
	}
	
	/**
	 * Method truncates currency values to two decimal placess
	 * @param value
	 * @return value
	 */
	public static  String truncate(double value) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(value);
	}

}