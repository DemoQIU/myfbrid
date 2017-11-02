/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.service;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qhx.myfbrid.model.Car;

@Repository(value = "carService")
public interface CarService {
	//通过用户名查找购物车
	List<Car> findCarByUsername(String username);
	//删除购物车中的商品
	void deleteCarGoodsByNameAndGoodId(String username,int goodId);
	//往购物车里添加商品
	void addGoods2Car(Car car);
}
