package br.com.localvarejo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payments")
public class Payment implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false, updatable = false)
	private UUID uuid;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-DD-dd HH:mm:ss", timezone="GMT")
	private Instant moment;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	@JoinColumn(name = "payment_order_uuid")
	private Order order;
	
	public Payment() {
		
	}
	
	public Payment(UUID uuid, Instant moment, Order order) {
		super();
		this.uuid = uuid;
		this.moment = moment;
		this.order = order;
	}

	public double getValue() {
		return order.getTotal();
	}
	
	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(uuid, other.uuid);
	}
	
}
