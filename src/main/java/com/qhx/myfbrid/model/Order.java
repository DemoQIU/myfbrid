/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
/**订单实体类**/
@ToString
public class Order {
	/** 订单id */
	@Setter
	@Getter
	private int orderId = 0;
    /** 订购者名字 */
	@Setter
	@Getter
	private String orderName = "";
    /** 商品id */
	@Setter
	@Getter
	private int goodsId = 0;
    /** 商品价格 */
	@Setter
	@Getter
	private double goodsPrice = 0.00;
    /** 订单数量 */
	@Setter
	@Getter
	private int orderCount = 0;
    /** 订单时间 */
	@Setter
	@Getter
	private LocalDateTime orderCreateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
    /** 收货人名字 */
	@Setter
	@Getter
	private String receiver = "";
    /** 联系电话 */
	@Setter
	@Getter
	private int telephone = 0;
    /** 配送地址 */
	@Setter
	@Getter
	private String sendAddress = "";
}
