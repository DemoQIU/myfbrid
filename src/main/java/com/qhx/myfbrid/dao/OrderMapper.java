/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qhx.myfbrid.model.Order;

@Repository(value = "orderMapper")
public interface OrderMapper {
	void insertBatchOrders(List<Order> orderList);
}
