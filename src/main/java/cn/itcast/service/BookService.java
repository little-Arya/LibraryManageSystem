package cn.itcast.service;

import cn.itcast.domain.Book;

import java.util.List;

public interface BookService {

    //查询所有账户
    public List<Book> findAllBook();
    //保存账户信息
    public void saveBook(Book book);
    /**
     * 删除指定id数据
     */
    public void deleteItemById(int bkID);

    //根据id查询数据
    Book getItemById(int bkID);

    //根据参数更新数据
    public void updateBookById(Book book);

    //模糊查找
    List<Book> getBookByCNA(Book book);


    //根据参数更新数据
    public void upBookStu(Book book);
}
