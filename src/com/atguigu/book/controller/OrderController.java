package com.atguigu.book.controller;

import com.atguigu.book.pojo.OrderBean;
import com.atguigu.book.pojo.User;
import com.atguigu.book.service.OrderService;

import javax.servlet.http.HttpSession;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

public class OrderController {
    private OrderService orderService ;

    //结账
    public String checkout(HttpSession session){
        User user =(User)session.getAttribute("currUser");
//        if (user.getCart().getTotalBookCount() == 0){
//            return "index";
//        }
        OrderBean orderBean = new OrderBean() ;
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(now);
//        int year = now.getYear();
//        Month month = now.getMonth();
//        int day = now.getDayOfMonth();
        orderBean.setOrderNo(UUID.randomUUID().toString()+"_"+format);
        orderBean.setOrderDate(now);


        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);

        return "index" ;
    }
    public String getOrderList(HttpSession session){
        User  user = (User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser",user);
        return "order/order";
    }
}
