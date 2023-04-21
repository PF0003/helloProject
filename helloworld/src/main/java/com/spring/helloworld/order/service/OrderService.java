package com.spring.helloworld.order.service;

import java.util.List;
import java.util.Map;

import com.spring.helloworld.cart.vo.CartStayVO;
import com.spring.helloworld.order.vo.OrderAirVO;
import com.spring.helloworld.order.vo.OrderStayVO;

public interface OrderService {
	public List<OrderAirVO> listMyOrderGoodsAir(OrderAirVO orderVO) throws Exception;
	public void addNewOrderAir(List<OrderAirVO> myOrderList) throws Exception;
	public OrderAirVO findMyOrderAIr(String order_id) throws Exception;
	
	public List<OrderStayVO> listMyOrderGoodsStay(OrderStayVO orderVO) throws Exception;
	public void addNewOrderStay(List<OrderStayVO> myOrderList) throws Exception;
	public OrderStayVO findMyOrderStay(String order_id) throws Exception;
	
	public Map<String ,List> myStayCartList(CartStayVO cartStayVO) throws Exception;
}