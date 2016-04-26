package model.pojo;

public class RetailerInfo {
	String RETAILER_ID;
	String RETAILER_NAME;
	String LOCATION;
	String LICENCE_NUMBER;
	String USER_ID;
	/**
	 * @param retailer_id
	 * @param retailer_name
	 * @param location
	 * @param licence_number
	 * @param user_id
	 */
	public RetailerInfo(String retailer_id, String retailer_name,
			String location, String licence_number, String user_id) {
		RETAILER_ID = retailer_id;
		RETAILER_NAME = retailer_name;
		LOCATION = location;
		LICENCE_NUMBER = licence_number;
		USER_ID = user_id;
	}
	public String getRETAILER_ID() {
		return RETAILER_ID;
	}
	public void setRETAILER_ID(String retailer_id) {
		RETAILER_ID = retailer_id;
	}
	public String getRETAILER_NAME() {
		return RETAILER_NAME;
	}
	public void setRETAILER_NAME(String retailer_name) {
		RETAILER_NAME = retailer_name;
	}
	public String getLOCATION() {
		return LOCATION;
	}
	public void setLOCATION(String location) {
		LOCATION = location;
	}
	public String getLICENCE_NUMBER() {
		return LICENCE_NUMBER;
	}
	public void setLICENCE_NUMBER(String licence_number) {
		LICENCE_NUMBER = licence_number;
	}
	public String getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(String user_id) {
		USER_ID = user_id;
	}

}
