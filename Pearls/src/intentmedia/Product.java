package intentmedia;

/**
 * The Class Product.
 */
public class Product {
	
	/** The product code. */
	private String productCode;
	
	/** The unit price. */
	private float unitPrice;
	
	/** The volume if there is volume price else this is 1. */
	private int volume;
	
	/** The volume price if applicable otherwise its unitprice. */
	private float volumePrice;

	public Product() {
		System.out.println("Created");
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param name the name
	 * @param unitPrice the unit price
	 */
	public Product(String productCode, float unitPrice) {
		this(productCode, unitPrice, 1, unitPrice);
	}

	/**
	 * Instantiates a new product.
	 *
	 * @param productCode
	 * @param unitPrice
	 * @param volume 
	 * @param volumePrice
	 */
	public Product(String productCode, float unitPrice, int volume, float volumePrice) {
		this.productCode = productCode;
		this.unitPrice = unitPrice;
		this.volume = volume;
		this.volumePrice = volumePrice;
	}

	/**
	 * Sets the pricing.
	 *
	 * @param unitPrice
	 * @param volume 
	 * @param volumePrice 
	 */
	public void setPricing(float unitPrice, int volume, float volumePrice) {
		this.unitPrice = unitPrice;
		this.volume = volume;
		this.volumePrice = volumePrice;
	}

	public String getCode() {
		return productCode;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public int getVolume() {
		return volume;
	}

	public float getVolumePrice() {
		return volumePrice;
	}

	public String toString() {
		return productCode;
	}
}
