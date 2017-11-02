/**
 * @author QIUHX 
 * 2017年11月2日
 */
package com.qhx.myfbrid.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qhx.myfbird.common.BaseController;
import com.qhx.myfbrid.model.Goods;
import com.qhx.myfbrid.model.Order;
import com.qhx.myfbrid.service.GoodsService;
import com.qhx.myfbrid.service.OrderService;

/**商品展示，订单**/
@Controller
public class GoodsController extends BaseController{
	private static Logger logger = LoggerFactory.getLogger(GoodsController.class);
//	15853123329
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	
	//查找所有商品
	@RequestMapping(value = "/goods/show")
	public List<Goods> showAllGoods(){
		return goodsService.findAllGoods();
	}
	
	//根据用户输入关键字查询商品
	@RequestMapping(value = "/queryGoodsByKeywords")
	public String queryGoodsByKeywords(@RequestParam("keyword") String keyword,Model model){
		List<Goods> goodsList = goodsService.findGoodsByKeyword(keyword);
		model.addAttribute("goodsList",goodsList);
		return "goods/query";
	}
	
	//根据用户点击的商品id查询商品的详细信息
	@RequestMapping(value = "/queryGoodsById")
	public ModelAndView queryGoodsById(@RequestParam("id") String id,Model model){
		good = goodsService.findGoodsById(id);
		if(null != good){
			modelAndView.setViewName("goods/detail");
			model.addAttribute("goodsDetail", good);
		}else{
			modelAndView.setViewName("error/404");
		}
		return modelAndView;
	}
	
	//购买商品
	@RequestMapping(value = "/buy")
	public String buy(@RequestParam("detailId") String detailId,Model model){
		good = goodsService.findGoodsById(detailId);
		goods.clear();
		goods.add(good);
		
		model.addAttribute("goodsList", goods);
		return "goods/buy";
	}
	
	// TODO 不是很懂
	//将用户购买提交的订单保存到数据库中
	@RequestMapping(value = "/goods/buy",method = RequestMethod.POST)
	public int buy(List<Order> orderList){
		orderService.saveBatchOrders(orderList);
		logger.info("--->save order list successful !!!");
		return 1;
	}
}
