package search1;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepositary extends MongoRepository<Order, String> {

}
