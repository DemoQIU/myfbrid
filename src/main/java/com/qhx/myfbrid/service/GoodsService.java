/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.service;

import java.util.List;

import com.qhx.myfbrid.model.Goods;

public interface GoodsService {
	List<Goods> findAllGoods();
	Goods findGoodsById(String id);
	List<Goods> findGoodsByKeyword(String keyword);
}
