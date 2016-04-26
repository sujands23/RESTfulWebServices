package model.pojo;

public class ProductStock {

	String ProductCode;
	String ProductModelId;
	String ProductName;
	String ProductStatus;
	String OrderId;
	/**
	 * @param productCode
	 * @param productModelId
	 * @param productName
	 * @param productStatus
	 * @param orderId
	 */
	public ProductStock(String productCode, String productModelId,
			String productName, String productStatus, String orderId) {
		ProductCode = productCode;
		ProductModelId = productModelId;
		ProductName = productName;
		ProductStatus = productStatus;
		OrderId = orderId;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getProductModelId() {
		return ProductModelId;
	}
	public void setProductModelId(String productModelId) {
		ProductModelId = productModelId;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getProductStatus() {
		return ProductStatus;
	}
	public void setProductStatus(String productStatus) {
		ProductStatus = productStatus;
	}
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	
	
	
}
