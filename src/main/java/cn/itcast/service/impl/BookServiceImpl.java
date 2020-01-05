package cn.itcast.service.impl;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    @Override
    public List<Book> findAllBook() {
        return bookDao.findAllBook();
    }

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void deleteItemById(int bkID) {

        bookDao.deleteItemById(bkID);
    }

    @Override
    public Book getItemById(int bkID) {
        return bookDao.getItemById(bkID);
    }

    @Override
    public void updateBookById(Book book) {
        bookDao.updateBookById(book);
    }

    @Override
    public List<Book> getBookByCNA(Book book) {
        return bookDao.getBookByCNA(book);
    }

    @Override
    public void upBookStu(Book book) {
        bookDao.upBookStu(book);
    }
}
