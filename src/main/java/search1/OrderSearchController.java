package search1;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class OrderSearchController {
	@Autowired // is used for DI
	OrderService orderService; // DI

	@PostMapping("/order")
	@ResponseStatus(code = HttpStatus.CREATED)
	String createOrder(@RequestBody @Valid Order order, BindingResult bindingResult) {
		validateModel(bindingResult);
		System.out.println(order);
		return orderService.createOrder(order); // delegate
	}

	
	private void validateModel(Errors bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new IllegalArgumentException("Somethign went wrong. Plesae retry");
		}
	}

//DRY 
	@PutMapping("/order/{id}")
	void updateOrder(@RequestBody @Valid Order order, BindingResult bindingResult, @PathVariable("id") int orderId) {
		validateModel(bindingResult);
		System.out.println(orderId);
		orderService.updateOrder(orderId);
	}

	@DeleteMapping("/order/{id}")
	void deleteOrder(@PathVariable("id") int orderId, HttpRequest httpRequest) {
		System.out.println(httpRequest.getHeaders());
		System.out.println(orderId);
		orderService.deleteOrder(orderId);
	}


}