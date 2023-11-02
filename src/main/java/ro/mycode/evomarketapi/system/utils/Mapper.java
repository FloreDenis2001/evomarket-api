package ro.mycode.evomarketapi.system.utils;

import ro.mycode.evomarketapi.order.dto.OrderDTO;
import ro.mycode.evomarketapi.order.models.Order;
import ro.mycode.evomarketapi.orderdetails.dto.OrderDetailsDTO;
import ro.mycode.evomarketapi.orderdetails.models.OrderDetails;
import ro.mycode.evomarketapi.product.dto.ProductDTO;
import ro.mycode.evomarketapi.product.dto.UpdateProductRequest;
import ro.mycode.evomarketapi.product.models.Product;
import ro.mycode.evomarketapi.user.dto.UserDTO;
import ro.mycode.evomarketapi.user.models.User;

public class Mapper {

    public Product covertProductDTOtoProduct(ProductDTO productdTO) {
        Product product = new Product();
        product.setName(productdTO.name());
        product.setDescription(productdTO.description());
        product.setCategory(productdTO.category());
        product.setPrice(productdTO.price());
        product.setSKU(productdTO.SKU());
        product.setCreatedDate(productdTO.createdDate());
        product.setQuantity(productdTO.quantity());
        product.setWeight(productdTO.weight());
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
        order.setOrderDate(orderDTO.orderDate());
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
        user.setRegisteredAt(userDTO.registeredAt());
        user.setCreatedAt(userDTO.createdAt());
        user.setActive(userDTO.active());
        user.setUserRole(userDTO.userRole());
        return user;


    }
}
