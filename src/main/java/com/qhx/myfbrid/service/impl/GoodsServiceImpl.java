/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhx.myfbrid.dao.GoodsMapper;
import com.qhx.myfbrid.model.Goods;
import com.qhx.myfbrid.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsMapper goodsMapper;
	
	//返回所有的商品信息
	@Override
	public List<Goods> findAllGoods() {
		List<Goods> goods = goodsMapper.selectAllGoods();
		return goods;
	}
	
	//根据商品Id查找商品信息
	@Override
	public Goods findGoodsById(String id) {
		return goodsMapper.queryGoodsById(id);
	}
	
	//根据商品关键字模糊查询商品
	@Override
	public List<Goods> findGoodsByKeyword(String keyword) {
		List<Goods> goodsList = goodsMapper.queryGoodsByKeyword(keyword);
		return goodsList;
	}
}
