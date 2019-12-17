package com.onlineshopping.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="sales_order")
public class SalesOrder {
		
	@Id
	@Column(name="order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long orderId;
	@Column(name="order_date")
	private Date orderDate;
	@Column(name="cust_id")
	private Long custId;
	@Column(name="order_desc") 
	private String orderDesc;
	@Column(name="total_price")
	private Double totalprice;
	
	@OneToMany(cascade = { CascadeType.ALL }, mappedBy = "salesOrder")
	private List<OrderLineItem> orderLineItems;

	
	public SalesOrder() {}
	
	public SalesOrder(Long orderId, Date orderDate, Long custId, String orderDesc, Double totalprice) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.custId = custId;
		this.orderDesc = orderDesc;
		this.totalprice = totalprice;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getOrderDesc() {
		return orderDesc;
	}
	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc;
	}
	public Double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}
	
	public List<OrderLineItem> getOrderLineItems() {
		return orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
		this.orderLineItems.forEach(orderLineItem -> orderLineItem.setSalesOrder(this));
	}
	
}
