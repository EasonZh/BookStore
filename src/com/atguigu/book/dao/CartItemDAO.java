package com.atguigu.book.dao;

import com.atguigu.book.pojo.Cart;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface CartItemDAO {
    //如果购物车中没有则数量加一
     void updateCartItem(CartItem cartItem);
     //如果购物车中没有则新增购物项
     void addCartItem(CartItem cartItem);
    //返回购物车的内容
     List<CartItem> getCartItemList(User user);
     //删除特定购物车项
    void delCartItem(CartItem cartItem);
}
