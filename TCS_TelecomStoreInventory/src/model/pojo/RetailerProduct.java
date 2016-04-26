package model.pojo;

public class RetailerProduct {
	String retailerid,reatilername,productmodelid,productname;

	public RetailerProduct(String retailerid, String productmodelid) {
		super();
		this.retailerid = retailerid;
		this.productmodelid = productmodelid;
	}

	public RetailerProduct(String productmodelid) {
		super();
		this.productmodelid = productmodelid;
	}

	public String getRetailerid() {
		return retailerid;
	}

	public void setRetailerid(String retailerid) {
		this.retailerid = retailerid;
	}

	public String getReatilername() {
		return reatilername;
	}

	public void setReatilername(String reatilername) {
		this.reatilername = reatilername;
	}

	public String getProductmodelid() {
		return productmodelid;
	}

	public void setProductmodelid(String productmodelid) {
		this.productmodelid = productmodelid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	
	

}
