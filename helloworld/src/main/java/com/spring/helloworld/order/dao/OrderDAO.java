package com.spring.helloworld.order.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.spring.helloworld.cart.vo.CartStayVO;
import com.spring.helloworld.goods.vo.GoodsStayVO;
import com.spring.helloworld.order.vo.OrderAirVO;
import com.spring.helloworld.order.vo.OrderStayVO;

public interface OrderDAO {
	public List<OrderAirVO> listMyOrderGoodsAir(OrderAirVO orderAirVO) throws DataAccessException;
	public void insertNewOrderAir(List<OrderAirVO> myOrderList) throws DataAccessException;
	public OrderAirVO findMyOrderAir(String order_id) throws DataAccessException;
	
	public List<OrderStayVO> listMyOrderGoodsStay(OrderStayVO orderStayVO) throws DataAccessException;
	public void insertNewOrderStay(List<OrderStayVO> myOrderList) throws DataAccessException;
	public OrderStayVO findMyOrderStay(String order_id) throws DataAccessException;
	
	public void removeGoodsFromCartAir(OrderAirVO orderVO)throws DataAccessException;
	public void removeGoodsFromCartAir(List<OrderAirVO> myOrderList)throws DataAccessException;
	
	public List<CartStayVO> selectStayCartList(CartStayVO cartStayVO) throws DataAccessException;
	public List<GoodsStayVO> selectGoodsList(List<CartStayVO> cartList) throws DataAccessException;
}