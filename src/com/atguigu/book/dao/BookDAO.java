package com.atguigu.book.dao;

import com.atguigu.book.pojo.Book;
import com.atguigu.book.pojo.CartItem;
import com.atguigu.book.pojo.User;

import java.util.List;

public interface BookDAO {
          List<Book> getBookList();
          Book getBook(Integer id);
}
