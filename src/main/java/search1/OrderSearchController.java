package search1;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderSearchController {
	@Autowired // is used for Dependency Injection-call the dependency service in a dependent
				// controller
	OrderService orderService;
	@GetMapping("/order")
	List<Order> getOrder() {
		return orderService.getOrders();
	}
	@GetMapping("/order/{id}")
	Order getOrderById(@PathVariable("id") String orderId) {
		return OrderService.getOrder(orderId);
	}
}