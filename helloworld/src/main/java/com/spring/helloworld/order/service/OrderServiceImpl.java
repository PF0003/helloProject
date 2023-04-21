package com.spring.helloworld.order.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

import com.spring.helloworld.cart.vo.CartStayVO;
import com.spring.helloworld.goods.vo.GoodsStayVO;
import com.spring.helloworld.order.dao.OrderDAO;
import com.spring.helloworld.order.vo.OrderAirVO;
import com.spring.helloworld.order.vo.OrderStayVO;

@Service("orderService")
@Transactional(propagation=Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;
	
	//항공주문==============
	public List<OrderAirVO> listMyOrderGoodsAir(OrderAirVO orderVO) throws Exception {
		List<OrderAirVO> orderGoodsList;
		orderGoodsList=orderDAO.listMyOrderGoodsAir(orderVO);
		return orderGoodsList;
	}
	
	public void addNewOrderAir(List<OrderAirVO> myOrderList) throws Exception {
		orderDAO.insertNewOrderAir(myOrderList);
		//카트에서 주문 상품 제거한다.
		orderDAO.removeGoodsFromCartAir(myOrderList);
	}	
	
	public OrderAirVO findMyOrderAIr(String order_id) throws Exception {
		return orderDAO.findMyOrderAir(order_id);
	}
	
	//항공주문==============
	public List<OrderStayVO> listMyOrderGoodsStay(OrderStayVO orderVO) throws Exception {
		List<OrderStayVO> orderGoodsList;
		orderGoodsList=orderDAO.listMyOrderGoodsStay(orderVO);
		return orderGoodsList;
	}
	
	public void addNewOrderStay(List<OrderStayVO> myOrderList) throws Exception {
		orderDAO.insertNewOrderStay(myOrderList);
		//카트에서 주문 상품 제거한다.
//		orderDAO.removeGoodsFromCartAir(myOrderList);
	}	
	
	public OrderStayVO findMyOrderStay(String order_id) throws Exception {
		return orderDAO.findMyOrderStay(order_id);
	}
		
	
	//0405변재선
	public Map<String ,List> myStayCartList(CartStayVO cartStayVO) throws Exception{
		Map<String,List> cartStayMap=new HashMap<String,List>();
		List<CartStayVO> myStayCartList=orderDAO.selectStayCartList(cartStayVO);
		//?
		if(myStayCartList.size()==0){ 
			return null;
		}
		List<GoodsStayVO> myGoodsList=orderDAO.selectGoodsList(myStayCartList);
		
		cartStayMap.put("myStayCartList", myStayCartList);
		cartStayMap.put("myGoodsList",myGoodsList);
		
		return cartStayMap;
	}
}