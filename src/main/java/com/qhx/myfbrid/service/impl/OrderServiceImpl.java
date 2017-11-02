/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhx.myfbrid.dao.OrderMapper;
import com.qhx.myfbrid.model.Order;
import com.qhx.myfbrid.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public void saveBatchOrders(List<Order> orderList) {
		orderMapper.insertBatchOrders(orderList);
	}
}
