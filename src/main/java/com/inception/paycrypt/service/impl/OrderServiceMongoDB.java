package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.exception.OrderServiceException;
import com.inception.paycrypt.exception.UserServiceException;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.repository.OrderRepository;
import com.inception.paycrypt.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Order Service for MongoDB
 *
 * @author Daniel Rincón (daniel.rincon-m@mail.escuelaing.edu.co)
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("orderServiceMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderServiceMongoDB implements OrderService {

    /**
     * The {@link OrderRepository}
     */
    private final OrderRepository orderRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Order create(OrderDto orderDto) {
        return orderRepository.save(new Order(orderDto));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Order findById(String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);

        if (optionalOrder.isPresent()) {

            return optionalOrder.get();
        }

        throw new UserServiceException(OrderServiceException.ORDER_NOT_FOUND);
    }
}
