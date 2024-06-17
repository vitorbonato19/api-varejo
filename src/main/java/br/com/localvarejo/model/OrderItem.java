package br.com.localvarejo.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double price;
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "ordersItem_order_id")
	private Order orders = new Order();
	
	@ManyToOne
	@JoinColumn(name = "orderItem_product_id")
	private Product products;
	
	public OrderItem() {
		
	}

	public OrderItem(Long id, Integer quantity, Double price,Order orders, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = product.getPrice();
		this.orders = orders;
		this.products = product;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return products;
	}

	public Order getOrders() {
		return orders;
	}

	public Product getProducts() {
		return products;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}

	public double getSubtotal() {
		return products.getPrice() * quantity;
	}

	
	
}
