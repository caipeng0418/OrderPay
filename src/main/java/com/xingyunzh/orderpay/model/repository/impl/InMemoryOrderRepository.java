package com.xingyunzh.orderpay.model.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xingyunzh.orderpay.model.Order;
import com.xingyunzh.orderpay.model.repository.OrderRepository;
import com.xingyunzh.orderpay.model.repository.PaymentRepository;

@Repository
public class InMemoryOrderRepository implements OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
	private PaymentRepository paymentRepo;
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> results = jdbcTemplate.query("select * from \"order\"", new OrderRowMapper(jdbcTemplate, paymentRepo));
		return results;
	}

}
