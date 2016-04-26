package model.pojo;


public class RewardPackage {
//data members of this pojo class
	
	private String id;
	private String offers;
	private String Order_value;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOffers() {
		return offers;
	}
	public void setOffers(String offers) {
		this.offers = offers;
	}
	public String getOrder_value() {
		return Order_value;
	}
	public void setOrder_value(String orderValue) {
		Order_value = orderValue;
	}
	public RewardPackage(String id, String offers, String orderValue) {
		super();
		this.id = id;
		this.offers = offers;
		Order_value = orderValue;
	}
	
	
}
