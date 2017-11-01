/**
 * @author QIUHX 
 * 2017年10月27日
 */
package com.qhx.myfbrid.test;

import java.time.LocalDateTime;

import org.junit.Test;

import com.qhx.myfbrid.model.Goods;

public class MyfbridTest {
	@Test
	public void testLombok(){
		Goods goods = new Goods();
		goods.setGoodsId(2);
		System.out.println(goods);
	}
	
	@Test
	public void testLocalTime(){
		System.out.println(LocalDateTime.now());
	}
}
