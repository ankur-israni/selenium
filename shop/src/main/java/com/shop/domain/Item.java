package com.shop.domain;

public class Item {

	private String id;
	private String name;
	private Integer quantity;
	private Float price;
	private String dimensions;
	private String image;
	
	

	public Item(String id, String name,  Float price,String dimensions, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.dimensions=dimensions;
		this.image=image;
	}

	public Item(String id, String name,  Float price, Integer quantity,String dimensions, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity=quantity;
		this.dimensions=dimensions;
		this.image=image;
	}
	
	
	
	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
