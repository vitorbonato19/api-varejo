package br.com.localvarejo.model.enums;

public enum OrderStatusEnum {

	PAYD(1),
	WAITING_PAYMENT(2),
	CANCELED(3),
	DELIVERED(4);
	
	private int num;
	
	private OrderStatusEnum(int num) {
		this.num = num;
	}
	
	public int getNum() {
		return num;
	}
	
	public static OrderStatusEnum valueOf(int num) {
		for(OrderStatusEnum o : OrderStatusEnum.values()) {
			if (o.getNum() == num) {
				return o;
			}
		}
		throw new IllegalArgumentException("Please set a valid status code...");
	}
}
