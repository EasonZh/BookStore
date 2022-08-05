package com.atguigu.book.dao.impl;

import com.atguigu.book.dao.CartItemDAO;
import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;
import com.atguigu.myssm.basedao.BaseDAO;

import java.util.List;

public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void updateCartItem(CartItem cartItem) {
        executeUpdate("update t_cart set buyCount=? where id= ? ", cartItem.getBuyCount(),cartItem.getId());

    }

    @Override
    public void addCartItem(CartItem cartItem) {
        executeUpdate("insert into t_cart values(0,?,?,?)",cartItem.getBook().getId(),cartItem.getBuyCount(),cartItem.getUesr().getId());

    }

    @Override
    public List<CartItem> getCartItemList(User user) {
      return  executeQuery("select * from t_cart where userBean= ?",user.getId());

    }

    @Override
    public void delCartItem(CartItem cartItem) {
       super.executeUpdate("delete  from t_cart where id=?",cartItem.getId());
    }


}
