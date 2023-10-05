package ro.mycode.evomarketapi.orderdetails.services;

import org.springframework.stereotype.Service;
import ro.mycode.evomarketapi.exceptions.ListEmptyException;
import ro.mycode.evomarketapi.exceptions.OrderDetailsNotFoundException;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.orderdetails.repo.OrderDetailsRepo;
import ro.mycode.evomarketapi.product.models.Product;

import java.util.List;
import java.util.Optional;


@Service
public class OrderDetailsQuerryServiceImpl implements OrderDetailsQuerryService{
    private OrderDetailsRepo orderDetailsRepo;

    public OrderDetailsQuerryServiceImpl(OrderDetailsRepo orderDetailsRepo) {
        this.orderDetailsRepo = orderDetailsRepo;
    }


    @Override
    public Optional<OrderDetails> findById(long id) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findById(id);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public Optional<OrderDetails> findBySKU(String SKU) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findBySKU(SKU);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public Optional<OrderDetails> findByOrderIdAndProductId(long orderId, long productId) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findByOrderIdAndProductId(orderId, productId);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public Optional<OrderDetails> findByOrderIdAndSKU(long orderId, String SKU) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findByOrderIdAndSKU(orderId, SKU);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public Optional<OrderDetails> findByOrderId(long orderId) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findByOrderId(orderId);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public Optional<OrderDetails> findByOrderIdAndProductIdAndSKU(long orderId, long productId, String SKU) {
        Optional<OrderDetails> orderDetailsOptional = orderDetailsRepo.findByOrderIdAndProductIdAndSKU(orderId, productId, SKU);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new OrderDetailsNotFoundException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> getAllById(long id) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.getAllById(id);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new ListEmptyException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> getAllBySKU(String SKU) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.getAllBySKU(SKU);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new ListEmptyException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> getAllByOrderIdAndProductId(long orderId, long productId) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.getAllByOrderIdAndProductId(orderId, productId);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new ListEmptyException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> getAllByOrderIdAndSKU(long orderId, String SKU) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.getAllByOrderIdAndSKU(orderId, SKU);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new ListEmptyException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> getAllByOrderId(long orderId) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.getAllByOrderId(orderId);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new ListEmptyException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> getAllByOrderIdAndProductIdAndSKU(long orderId, long productId, String SKU) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.getAllByOrderIdAndProductIdAndSKU(orderId, productId, SKU);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new ListEmptyException();
        }
    }

    @Override
    public Optional<List<OrderDetails>> getAllByOrderIdAndProductIdAndSKUAndProduct(long orderId, long productId, String SKU, Product product) {
        Optional<List<OrderDetails>> orderDetailsOptional = orderDetailsRepo.getAllByOrderIdAndProductIdAndSKUAndProduct(orderId, productId,SKU,product);
        if (orderDetailsOptional.isPresent()) {
            return orderDetailsOptional;
        } else {
            throw new ListEmptyException();
        }
    }
}
