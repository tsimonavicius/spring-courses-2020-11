package com.codeacademy.eshop.order.service;

import com.codeacademy.eshop.cart.model.CartPrice;
import com.codeacademy.eshop.invoice.service.InvoiceService;
import com.codeacademy.eshop.order.model.Order;
import com.codeacademy.eshop.order.repository.OrderRepository;
import com.codeacademy.eshop.product.model.Product;
import com.codeacademy.eshop.user.model.User;
import com.codeacademy.eshop.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    /**
     * Creates the order by the given name. This function also generates an invoice and returns its ID,
     */
    @Transactional
    public long placeOrder(String userName, List<Product> cartProducts) {
        Order createdOrder = createNewOrder(userName, cartProducts);
        return invoiceService.createInvoice(createdOrder);
    }

    /**
     * Creates the order by the given card products and user name.
     */
    private Order createNewOrder(String userName, List<Product> cartProducts) {
        User currentUser = userService.loadUserByUsername(userName);
        Order order = new Order();
        order.setUser(currentUser);
        order.setProducts(cartProducts);
        return orderRepository.save(order);
    }

    public CartPrice getOrderPrice(long id) {
        return invoiceService.getPriceByOrderId(id);
    }

    public Page<Order> getAllOrders(Pageable pageable) {
        return orderRepository.findAll(pageable);
    }

    public Order getOrderById(long id) {
        return orderRepository.getOne(id);
    }
}
