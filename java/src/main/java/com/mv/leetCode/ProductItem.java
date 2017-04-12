package com.mv.leetCode;

/**
 * @author Zhe
 *
 */
public class ProductItem {
	
	private String upc;
	private String code;
	private String category;
	private Float itemPrice;
	private Float couponAmount;
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public Float getCouponAmount() {
		return couponAmount;
	}
	public void setCouponAmount(Float couponAmount) {
		this.couponAmount = couponAmount;
	}
	
	public ProductItem(String upc, String code, String category, Float itemPrice, Float couponAmount) {
		super();
		this.upc = upc;
		this.code = code;
		this.category = category;
		this.itemPrice = itemPrice;
		this.couponAmount = couponAmount;
	}
	@Override
	public String toString() {
		return "ProductItem [percentageOff=" + couponAmount/itemPrice +"upc=" + upc + ", code=" + code + ", category=" + category + ", itemPrice=" + itemPrice
				+ ", couponAmount=" + couponAmount + "]";
	}
}
