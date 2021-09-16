package com.inception.paycrypt.service.impl;

import com.inception.paycrypt.dto.OrderDto;
import com.inception.paycrypt.exception.OrderServiceException;
import com.inception.paycrypt.model.Order;
import com.inception.paycrypt.repository.OrderRepository;
import com.inception.paycrypt.service.OrderService;
import com.inception.paycrypt.utils.CurrencyCode;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.annotation.security.RolesAllowed;
import java.util.Optional;

import static com.inception.paycrypt.utils.UserRoles.ADMIN;

/**
 * Implementation class for conversionService
 *
 * @author Laura Bernal
 * @version 1.0.0
 * @since 1.0.0
 */
@Component("orderMongoDB")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderMongoDB implements OrderService{

    /**
     *
     * Order information extraction
     */
    private final OrderRepository orderRepository;

    /**
     * create Order
     * @param orderDto
     * @return
     */
    @Override
    public Order create(OrderDto orderDto) {
        return orderRepository.save(new Order(orderDto));
    }

    /**
     * Update of order date
     * @param orderDto
     * @param id
     * @return
     */
    @Override
    public Order updateOrderDate(OrderDto orderDto, String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.update(orderDto);
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
    }

    /**
     * Delete order
     *
     * @param id
     */
    @Override
    public void deleteOrder(String id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if(!orderRepository.existsById(id)){
            throw  new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
        }
        orderRepository.deleteById(id);
    }

    /**
     * Update of order  by target currecy
     *
     * @param orderDto
     * @param targetCurrencyCode
     * @return
     */
    @Override
    public Order updateTargetValue(OrderDto orderDto, CurrencyCode targetCurrencyCode) {
        Optional<Order> optionalOrder = orderRepository.findById(orderDto.getId());
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.update(orderDto);
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
    }

    /**
     *Update of order  by source currency
     *
     * @param orderDto
     * @param sourceCurrencyCode
     * @return
     */
    @Override
    public Order updateSourcetValue(OrderDto orderDto, CurrencyCode sourceCurrencyCode) {
        Optional<Order> optionalOrder = orderRepository.findById(orderDto.getId());
        if(optionalOrder.isPresent()){
            Order order = optionalOrder.get();
            order.update(orderDto);
            orderRepository.save(order);
            return order;
        }
        throw new OrderServiceException(OrderServiceException.ORDEN_NOT_FOUND);
    }


}


























