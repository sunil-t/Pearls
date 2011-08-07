/**
 * @author Sunil Thunuguntla
 */

package intentmedia;

import java.util.HashMap;

/**
 * The Class Terminal.
 * 
 * This is the Class responsible that maintains the {@link Product} product list and generates the order list.
 * It also calculates the total cost of the order based on unit and volume prices of {@link Product}s
 */
public class Terminal {
	
	/** The order list. */
	private HashMap<String, ShoppingCartProduct> orderList = new HashMap<String, ShoppingCartProduct>();
	
	/** The product list. */
	private HashMap<String, Product> productList = new HashMap<String, Product>();

	/**
	 * Sets the pricing of {@link Product}.
	 *
	 * @param productCode: unique code of the product
	 * @param unitPrice the unit price
	 */
	public void setPricing(String productCode, float unitPrice) {
		setPricing(productCode, unitPrice, 1, unitPrice);
	}
	
	/**
	 * Sets the pricing.
	 *
	 * @param productCode: unique code of the product
	 * @param unitPrice : Products unit price
	 * @param volume : If Product has volume price then this is volume required
	 * @param volumePrice : Product volume price
	 */
	public void setPricing(String productCode, float unitPrice, int volume, float volumePrice) {
		if(productList.containsKey(productCode))
			productList.get(productCode).setPricing(unitPrice, volume, volumePrice);
		else 
			productList.put(productCode, new Product(productCode, unitPrice, volume, volumePrice));
	}
	
	
	/**
	 * Scans the Product and adds to the order list.
	 *
	 * @param productCode the product code
	 */
	public void scan(String productCode) {
		if(productCode == null || !productList.containsKey(productCode)){
			System.out.println("Sorry. Could not scan product: '" + productCode + "'. Product is not registered");
			return;
		}
		if(orderList.containsKey(productCode))
			orderList.get(productCode).incrementCount();
		else
			orderList.put(productCode, new ShoppingCartProduct(productList.get(productCode)));
	}
	
	/**
	 * Scan multiple. Utility function so that you can give a string of product codes to scan at once.
	 *
	 * @param products the products
	 */
	public void scanMultiple(String products) {
		for(int i=0; i< products.length(); i++) {
			scan(String.valueOf(products.charAt(i)).toString());
		}
	}
	
	public void clearOrder() {
		orderList.clear();
	}
	
	/**
	 * Total.
	 *
	 * @return total: total for your order
	 */
	public float total(){
		float total = 0;
		for(String scp: orderList.keySet()){
			total += orderList.get(scp).getTotal();
		}
		return total;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String [] args) {
		Terminal terminal = new Terminal();
		terminal.setPricing("A", 2, 4, 7);
		terminal.setPricing("B", 12);
		terminal.setPricing("C", 1.25f, 6, 6);
		terminal.setPricing("D", 0.15f);
		terminal.scanMultiple("ABCD");
		System.out.format("Total : $%.2f", terminal.total());
	}
}
