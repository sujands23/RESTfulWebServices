package model.pojo;

public class RetailerReward {
	private String rewardId;
	private String retailerId;
	private String packageId;
	private String rewardDate;
	private String rewardStatus;
	/**
	 * @param rewardId
	 * @param retailerId
	 * @param packageId
	 * @param rewardDate
	 * @param rewardStatus
	 */
	
	/**
	 * @param packageId
	 */
	public RetailerReward(String rewardId, String retailerId, String packageId,
			String rewardStatus) {
		super();
		this.rewardId = rewardId;
		this.retailerId = retailerId;
		this.packageId = packageId;
		this.rewardStatus = rewardStatus;
	}

	
	public RetailerReward(String rewardId, String retailerId, String packageId,
			String rewardDate, String rewardStatus) {
		this.rewardId = rewardId;
		this.retailerId = retailerId;
		this.packageId = packageId;
		this.rewardDate = rewardDate;
		this.rewardStatus = rewardStatus;
	}
	
	/**
	 * @param retailerId
	 * @param packageId
	 * @param rewardStatus
	 */
	public RetailerReward(String retailerId, String packageId,
			String rewardStatus) {
		this.retailerId = retailerId;
		this.packageId = packageId;
		this.rewardStatus = rewardStatus;
	}

	/**
	 * @return the rewardId
	 */
	public String getRewardId() {
		return rewardId;
	}
	/**
	 * @param rewardId the rewardId to set
	 */
	public void setRewardId(String rewardId) {
		this.rewardId = rewardId;
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
	 * @return the packageId
	 */
	public String getPackageId() {
		return packageId;
	}
	/**
	 * @param packageId the packageId to set
	 */
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	/**
	 * @return the rewardDate
	 */
	public String getRewardDate() {
		return rewardDate;
	}
	/**
	 * @param rewardDate the rewardDate to set
	 */
	public void setRewardDate(String rewardDate) {
		this.rewardDate = rewardDate;
	}
	/**
	 * @return the rewardStatus
	 */
	public String getRewardStatus() {
		return rewardStatus;
	}
	/**
	 * @param rewardStatus the rewardStatus to set
	 */
	public void setRewardStatus(String rewardStatus) {
		this.rewardStatus = rewardStatus;
	}

}
