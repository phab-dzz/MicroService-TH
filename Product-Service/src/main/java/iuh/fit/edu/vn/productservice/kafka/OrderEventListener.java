package iuh.fit.edu.vn.productservice.kafka;
import com.fasterxml.jackson.databind.JsonNode;
import iuh.fit.edu.vn.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {
    private final ProductService productService;

    @Autowired
    public OrderEventListener(ProductService productService) {
        this.productService = productService;
    }

    @KafkaListener(topics = "order-created", groupId = "product-service-group")
    public void handleOrderCreated(JsonNode orderEvent) {
        try {
            JsonNode items = orderEvent.get("items");
            if (items != null && items.isArray()) {
                for (JsonNode item : items) {
                    Long productId = item.get("productId").asLong();
                    int quantity = item.get("quantity").asInt();
                    productService.updateStock(productId, quantity);
                }
            }
        } catch (Exception e) {
            // Log error
            System.err.println("Error processing order event: " + e.getMessage());
        }
    }
}
