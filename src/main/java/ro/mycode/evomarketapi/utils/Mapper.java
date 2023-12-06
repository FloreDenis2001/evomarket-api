package ro.mycode.evomarketapi.utils;

import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.orderdetails.dto.OrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.dto.UpdateProductRequest;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.system.security.UserRole;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;

import java.time.LocalDateTime;

public class Mapper {

    public Product covertProductDTOtoProduct(ProductDTO productdTO) {
        Product product = new Product();
        product.setName(productdTO.getName());
        product.setDescription(productdTO.getDescription());
        product.setCategory(productdTO.getCategory());
        product.setPrice(productdTO.getPrice());
        product.setSku(productdTO.getSKU());
        product.setCreatedDate(LocalDateTime.now());
        product.setQuantity(productdTO.getQuantity());
        product.setWeight(productdTO.getWeight());
        return product;
    }

    public Product covertUpdateProductDTOtoProduct(UpdateProductRequest updateProductRequest) {
        Product product = new Product();
        product.setName(updateProductRequest.name());
        product.setDescription(updateProductRequest.description());
        product.setPrice(updateProductRequest.price());
        product.setQuantity(updateProductRequest.quantity());
        product.setWeight(updateProductRequest.weight());
        product.setCategory(updateProductRequest.category());
        return product;
    }

    public OrderDetails convertOrderDetailsDTOToOrderDetails(OrderDetailsDTO orderDetailsDTO) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setOrder(orderDetailsDTO.order());
        orderDetails.setProduct(orderDetailsDTO.product());
        orderDetails.setQuantity(orderDetailsDTO.quantity());
        orderDetails.setSKU(orderDetailsDTO.SKU());
        Long price = orderDetailsDTO.product().getPrice() * orderDetailsDTO.quantity();
        orderDetails.setPrice(price);
        return orderDetails;
    }


    public Order convertOrdetDTOtoOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setAmmount(orderDTO.ammount());
        order.setOrderAddress(orderDTO.orderAddress());
        order.setOrderDate(LocalDateTime.now());
        order.setOrderEmail(orderDTO.orderEmail());
        order.setOrderPhone(orderDTO.orderPhone());
        order.setOrderStatus(orderDTO.orderStatus());
        order.setShippingAddress(orderDTO.shippingAddress());
        return order;
    }

    public User convertUserDTOtoUser(UserDTO userDTO) {
        User user = new User();
        user.setFirstName(userDTO.firstName());
        user.setLastName(userDTO.lastName());
        user.setEmail(userDTO.email());
        user.setPassword(userDTO.password());
        user.setPhoneNumber(userDTO.phoneNumber());
        user.setRegisteredAt(LocalDateTime.now());
        user.setActive(userDTO.active());
        user.setUserRole(UserRole.CLIENT);
        return user;


    }
}
