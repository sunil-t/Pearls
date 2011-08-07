package intentmedia;

/**
 * The Class ShoppingCartProduct resembles a product in a shopping cart.
 */
public class ShoppingCartProduct {
	
	/** The {@link Product}. */
	Product p;
	
	/** The product count. */
	int productCount = 1;

	/**
	 * @param p {@link Product}
	 */
	public ShoppingCartProduct(Product p) {
		this.p = p;
	}

	/**
	 * Increment count of {@link Product}.
	 */
	public void incrementCount() {
		productCount++;
	}

	/**
	 * @return the total for this {@link Product} applying unit or volume price.
	 */
	public float getTotal() {
		if (productCount == 1)
			return p.getUnitPrice();
		if (p.getVolume() == 1 || productCount < p.getVolume())
			return productCount * p.getUnitPrice();
		return ((p.getVolumePrice() * (productCount / p.getVolume())) + ((productCount % p
				.getVolume()) * p.getUnitPrice()));
	}

	public String toString() {
		return p.getCode();
	}
}
