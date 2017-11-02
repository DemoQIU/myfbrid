/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qhx.myfbird.common.BaseController;
import com.qhx.myfbrid.model.Car;
import com.qhx.myfbrid.service.CarService;
import com.qhx.myfbrid.utils.RequestStates;
import com.qhx.myfbrid.utils.ResultUtils;

/**购物车控制器,添加、删除**/
@Controller
public class CarController extends BaseController{
	@Autowired
	private CarService carService;
	
	//显示购物车中的商品
	@RequestMapping(value = "/myCar")
	public String myCar(Model model){
		clearCollection();
		model.addAttribute("carList", carService.findCarByUsername(getCurrentUsername()));
		return "/order/car";
	}
	
	//删除购物车中的商品
	@RequestMapping(value = "/carDelete",method = RequestMethod.POST,
				produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String delete(int goodsId){
		carService.deleteCarGoodsByNameAndGoodId(getCurrentUsername(), goodsId);
		return ResultUtils.getJson(RequestStates.success.getResultInfo());
	}
	
	//往购物车中添加商品
	@RequestMapping(value = "/addGoods",method = RequestMethod.POST,
				produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public String addGoods2Car(Car car){
		String username = getCurrentUsername();
		car.setSaverName(username);
		carService.addGoods2Car(car);
		return ResultUtils.getJson(RequestStates.success.getResultInfo());
	}
}
