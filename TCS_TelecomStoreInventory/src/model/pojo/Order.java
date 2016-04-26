package model.pojo;

public class Order {
	private String orderId;
	private String retailerId;
	private String orderDate;
	private String orderAmount;
	/**
	 * @return the orderId
	 */
	public String getOrderId() {
		return orderId;
	}
	/**
	 * @param orderId the orderId to set
	 */
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	/**
	 * @return the retailerId
	 */
	public String getRetailerId() {
		return retailerId;
	}
	/**
	 * @param retailerId the retailerId to set
	 */
	public void setRetailerId(String retailerId) {
		this.retailerId = retailerId;
	}
	/**
	 * @return the orderDate
	 */
	public String getOrderDate() {
		return orderDate;
	}
	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	/**
	 * @return the orderAmount
	 */
	public String getOrderAmount() {
		return orderAmount;
	}
	/**
	 * @param orderAmount the orderAmount to set
	 */
	public void setOrderAmount(String orderAmount) {
		this.orderAmount = orderAmount;
	}
	/**
	 * @param orderId
	 * @param retailerId
	 * @param orderDates
	 * @param orderAmount
	 */
	public Order(String orderId, String retailerId, String orderDate,
			String orderAmount) {
		this.orderId = orderId;
		this.retailerId = retailerId;
		this.orderDate = orderDate;
		this.orderAmount = orderAmount;
	}

}
