/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbird.common;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.servlet.ModelAndView;

import com.qhx.myfbrid.model.Car;
import com.qhx.myfbrid.model.Goods;
import com.qhx.myfbrid.model.User;
import com.qhx.myfbrid.shiro.ShiroManager;

/**
 * common controller 提供一系列公用方法及属性 
 */
public class BaseController {
	//公用模型视图类
	protected ModelAndView modelAndView = null;
	//商品集合
	protected static List<Goods> goods = null;
	//购物车集合
	protected static List<Car> cars = null;
	//商品
	protected Goods good = null;
	
	//默认构造方法
	public BaseController(){}
	
	@PostConstruct
	protected void init(){
		modelAndView = new ModelAndView();
		goods = new ArrayList<>();
		cars = new ArrayList<>();
	}
	
	//获得当前用户名
	protected String getCurrentUsername(){
		User currentUser = ShiroManager.getCurrentUser();
		if(null != currentUser){
			return currentUser.getUsername();
		}else{
			return "";
		}
	}
	
	//清空集合
	protected void clearCollection(){
		goods.clear();
		cars.clear();
	}
}
