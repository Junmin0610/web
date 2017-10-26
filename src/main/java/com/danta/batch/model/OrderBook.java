package com.danta.batch.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="orderbooks")
public class OrderBook {
	@Id
	private String id;
	private Long timestamp;
	private String order_currency;
	private String payment_currency;
	private List<Bid> bids;
	private List<Ask> asks;
	public OrderBook() {
		
	}
	public OrderBook(String id, Long timestamp, String order_currency, String payment_currency, List<Bid> bids,
			List<Ask> asks) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.order_currency = order_currency;
		this.payment_currency = payment_currency;
		this.bids = bids;
		this.asks = asks;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getOrder_currency() {
		return order_currency;
	}
	public void setOrder_currency(String order_currency) {
		this.order_currency = order_currency;
	}
	public String getPayment_currency() {
		return payment_currency;
	}
	public void setPayment_currency(String payment_currency) {
		this.payment_currency = payment_currency;
	}
	public List<Bid> getBids() {
		return bids;
	}
	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}
	public List<Ask> getAsks() {
		return asks;
	}
	public void setAsks(List<Ask> asks) {
		this.asks = asks;
	}
	
	
	
}
