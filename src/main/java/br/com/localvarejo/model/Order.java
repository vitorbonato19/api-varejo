package br.com.localvarejo.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.localvarejo.model.enums.OrderStatusEnum;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "order_desc")
	private String desc;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD-dd HH:mm:ss", timezone="GMT")
	@Column(name = "order_moment")
	@CreationTimestamp
	private Instant moment;
	
	private Integer orderStatus;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	public Order() {
		
	}

	public Order(Long id, String desc, Instant moment, OrderStatusEnum orderStatus, Client client) {
		super();
		this.id = id;
		this.desc = desc;
		this.moment = moment;
		setOrderStatusEnum(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public OrderStatusEnum getOrderStatus() {
		return OrderStatusEnum.valueOf(orderStatus);
	}

	public void setOrderStatusEnum(OrderStatusEnum orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getNum();
		}
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	@JsonIgnore
	public Client getClients() {
		return client;
	}

	public Set<OrderItem> getItems() {
		return items;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	public double getTotal() {
		double total = 0.0;
			for (OrderItem x : items) {
				total += x.getSubtotal();
			}
		return total;
	}
	
	
}
