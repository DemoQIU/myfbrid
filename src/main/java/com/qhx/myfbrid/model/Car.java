/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Car {
	/** 购物车编号 */
	@Setter
	@Getter
	private int carId = 0;
    /** 储存者名字 */
	@Setter
	@Getter
	private String saverName = "";
    /** 商品id */
	@Setter
	@Getter
	private int goodsId = 0;
    /** 商品名字 */
	@Setter
	@Getter
	private String goodsName = "";
    /** 商品价格 */
	@Setter
	@Getter
	private double goodsPrice = 0.00;
    /** 购物车数量 */
	@Setter
	@Getter
	private int carNum = 0;
    /** 产地 */
	@Setter
	@Getter
	private String originAddress = "";
    /** 创建时间 */
	@Setter
	@Getter
	private LocalDateTime createTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
}
