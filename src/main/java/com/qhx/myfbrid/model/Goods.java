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
public class Goods {
	/** 商品 id */
	@Setter
	@Getter
	private int goodsId = 0;
    /** 商品 名字 */
	@Setter
	@Getter
	private String goodsName = "";
    /** 商品 描述 */
	@Setter
	@Getter
	private String goodsDesc = "";
    /** 商品 价格 */
	@Setter
	@Getter
	private double goodsPrice = 0.00;
    /** 商品 产地 */
	@Setter
	@Getter
	private String goodsAddress = "";
    /** 商品 数量 */
	@Setter
	@Getter
	private int goodsCount = 0;
    /** 商品 输入时间 */
	@Setter
	@Getter
	private LocalDateTime goodsCreateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
    /** 商品 图片路径 */
	@Setter
	@Getter
	private String goodsImgSrc = "";
}
