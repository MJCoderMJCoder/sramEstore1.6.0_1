package com.root.pojo;

public class Goods {
	private String goodsId;
	private String goodsType; //商品类型
	private String goodsPrice;
	private String goodsStock; //商品库存
	private String goodsName;
	private String goodsImg; //商品图片
	private String goodsStatus; //商品状态
	
	public String getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsStock() {
		return goodsStock;
	}
	public void setGoodsStock(String goodsStock) {
		this.goodsStock = goodsStock;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsImg() {
		return goodsImg;
	}
	public void setGoodsImg(String goodsImg) {
		this.goodsImg = goodsImg;
	}
	public String getGoodsStatus() {
		return goodsStatus;
	}
	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}
	
	public Goods() {
	}
	public Goods(String goodsId, String goodsType, String goodsPrice,
			String goodsStock, String goodsName, String goodsImg,
			String goodsStatus) {
		this.goodsId = goodsId;
		this.goodsType = goodsType;
		this.goodsPrice = goodsPrice;
		this.goodsStock = goodsStock;
		this.goodsName = goodsName;
		this.goodsImg = goodsImg;
		this.goodsStatus = goodsStatus;
	}
}
