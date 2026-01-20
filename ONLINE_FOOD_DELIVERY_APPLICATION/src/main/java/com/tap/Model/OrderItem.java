package com.tap.Model;

public class OrderItem {
	
	private int orderItemId;
	private int orderId;
	private String itemName;
	private int quantity;
	private double totalAmount;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}
	
	
	

	public OrderItem(int orderItemId, int orderId, String itemName, int quantity, double totalAmount) {
		super();
		this.orderItemId = orderItemId;
		this.orderId = orderId;
		this.itemName = itemName;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}




	public int getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quatity) {
		this.quantity = quatity;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", itemName=" + itemName
				+ ", quatity=" + quantity + ", totalAmount=" + totalAmount + "]";
	}
	
}
	
	