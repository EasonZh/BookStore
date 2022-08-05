package com.atguigu.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

public class Cart {
    private Map<Integer,CartItem>cartItemMap;//购物车项的集合，key是book的id
    private Double totalMoney;//购物车的总金额
    private Integer totalCount;//购物项的数量
    private Integer totalBookCount;//书的总数量

    public Cart(Map<Integer, CartItem> cartItemMap, Double totalMoney, Integer totalCount) {
        this.cartItemMap = cartItemMap;
        this.totalMoney = totalMoney;
        this.totalCount = totalCount;
    }

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney=0.0;
        if(cartItemMap!=null&&cartItemMap.size()>0){
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for(Map.Entry<Integer,CartItem>cartItemEntry:entries){
                CartItem cartItem = cartItemEntry.getValue();
                BigDecimal price = new BigDecimal("" + cartItem.getBook().getPrice());
                BigDecimal buyCount = new BigDecimal(""+cartItem.getBuyCount());
                BigDecimal multiply = price.multiply(buyCount);
                totalMoney=totalMoney+multiply.doubleValue();
            }
        }
        return totalMoney;
    }


    public Integer getTotalCount() {
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount=0;
        if(cartItemMap!=null&&cartItemMap.size()>0){
            for(CartItem cartItem:cartItemMap.values()){
                totalBookCount = totalBookCount+cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }
}

