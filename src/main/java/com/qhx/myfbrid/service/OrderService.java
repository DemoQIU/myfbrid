/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.service;

import java.util.List;

import com.qhx.myfbrid.model.Order;

public interface OrderService {
	void saveBatchOrders(List<Order> orderList);
}
