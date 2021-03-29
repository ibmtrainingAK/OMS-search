package search1;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
	public String createOrder(Order order) {
		return "order created";
	}

	public List<Order> getOrders() {
		return new ArrayList<Order>();
	}

	public void updateOrder(int orderId) {
	}

	public void deleteOrder(int orderId) {
		System.out.println("order deleted");
	}

	public static Order getOrder(String orderId) {
		return new Order();
	}
}
