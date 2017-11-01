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

}
