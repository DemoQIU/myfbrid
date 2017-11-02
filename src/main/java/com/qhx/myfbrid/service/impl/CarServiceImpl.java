/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qhx.myfbrid.dao.CarMapper;
import com.qhx.myfbrid.model.Car;
import com.qhx.myfbrid.service.CarService;

@Service
public class CarServiceImpl implements CarService{
	private static Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);
	@Autowired
	private CarMapper carMapper;
	@Override
	public List<Car> findCarByUsername(String username) {
		List<Car> carList = carMapper.selectCarByUsername(username);
		return carList;
	}

	@Override
	public void deleteCarGoodsByNameAndGoodId(String username, int goodId) {
		carMapper.deleteCarByIdAndCarname(goodId, username);
		logger.info("--->delete car successful !!!");
	}

	@Override
	public void addGoods2Car(Car car) {
		carMapper.addGoods2Car(car);
		logger.info("--->insert car:{} into database successful !!!",car.getSaverName());
	}
}
