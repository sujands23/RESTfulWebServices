package model.pojo;

public class ProductModel {
//data members of this pojo class
	
	private String id; 
	private String Rid; 
	public String getRid() {
		return Rid;
	}
	public void setRid(String rid) {
		Rid = rid;
	}


	private String name;	
	private String description;
	private String features;
	private String quantity;
	private double price ;
	private int threshold;
	
	
	
	
	
	
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the features
	 */
	public String getFeatures() {
		return features;
	}
	/**
	 * @param features the features to set
	 */
	public void setFeatures(String features) {
		this.features = features;
	}
	/**
	 * @return the proImage
	 */
	
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the threshold
	 */
	public int getThreshold() {
		return threshold;
	}
	/**
	 * @param threshold the threshold to set
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param features
	 * @param proImage
	 * @param price
	 * @param threshold
	 */
	public ProductModel(String id, String name, String description,
			String features, double price, int threshold) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.features = features;
	
		this.price = price;
		this.threshold = threshold;
	}
	public ProductModel(String id, String rid, String name) {
		super();
		this.id = id;
		Rid = rid;
		this.name = name;
	}
	public ProductModel(String id, String quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}


	
	
	
	

}
