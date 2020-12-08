package com.codeacademy.eshop.order.service;

import com.codeacademy.eshop.cart.service.CartService;
import com.codeacademy.eshop.config.Company;
import com.codeacademy.eshop.invoice.service.InvoiceService;
import com.codeacademy.eshop.order.model.Order;
import com.codeacademy.eshop.order.repository.OrderRepository;
import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.user.model.User;
import com.codeacademy.eshop.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private UserService userService;
    private InvoiceService invoiceService;

    public OrderService(OrderRepository orderRepository, UserService userService, InvoiceService invoiceService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.invoiceService = invoiceService;
    }

    @Transactional
    public void placeOrder(String userName, List<Product> cartProducts) {
        Order createdOrder = createNewOrder(userName, cartProducts);
        invoiceService.createInvoice(createdOrder);
    }

    private Order createNewOrder(String userName, List<Product> cartProducts) {
        User currentUser = userService.findUserByUserName(userName);
        Order order = new Order();
        order.setUser(currentUser);
        order.setProducts(cartProducts);
        return orderRepository.save(order);
    }
}
