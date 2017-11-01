/**
 * @author QIUHX 
 * 2017年11月1日
 */
package com.qhx.myfbrid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qhx.myfbrid.model.Goods;

@Repository(value = "goodsMapper")
public interface GoodsMapper {
	List<Goods> selectAllGoods();
}
