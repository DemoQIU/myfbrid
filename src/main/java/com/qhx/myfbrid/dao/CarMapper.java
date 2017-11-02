/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qhx.myfbrid.model.Car;

@Repository(value = "carMapper")
public interface CarMapper {
	List<Car> selectCarByUsername(String username);
	void deleteCarByIdAndCarname(int id,String carName);
	void addGoods2Car(Car car);
}
