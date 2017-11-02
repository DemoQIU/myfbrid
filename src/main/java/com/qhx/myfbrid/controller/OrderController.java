/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qhx.myfbird.common.BaseController;

/**订单控制器**/
@Controller
public class OrderController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value = "/order")
	public String order(){
		return "order/order";
	}
}
