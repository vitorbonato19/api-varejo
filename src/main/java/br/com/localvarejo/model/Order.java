package br.com.localvarejo.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "order_clients_id")
	private Client clients = new Client();
	
	@OneToMany(mappedBy = "orders")
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(Long id, String desc, Instant moment, Client clients, List<OrderItem> items) {
		super();
		this.id = id;
		this.desc = desc;
		this.moment = moment;
		this.clients = clients;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	@JsonIgnore
	public Client getClients() {
		return clients;
	}

	public List<OrderItem> getItems() {
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
	
	
}
