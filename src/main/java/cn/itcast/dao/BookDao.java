package cn.itcast.dao;

import cn.itcast.domain.Book;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    //查询所有账户
    @Select("select * from tb_book")
    public List<Book> findAllBook();
    //保存账户信息
    @Insert("insert into tb_book(bkCode,bkName,bkAuthor,bkPress,bkDatePress,bkISBN,bkCatalog,bkLanguage,bkPages,bkPrice,bkDateIn,bkBrief,bkCover,bkStatus) " +
            "values(#{bkCode},#{bkName},#{bkAuthor},#{bkPress},#{bkDatePress},#{bkISBN},#{bkCatalog},#{bkLanguage},#{bkPages},#{bkPrice},#{bkDateIn},#{bkBrief},#{bkCover},#{bkStatus})")
    public void saveBook(Book book);

    /**删除指定id数据*/
    @Delete("delete from tb_book where bkID=#{bkID}")
    public void deleteItemById(int bkID);

    //更新前的查询
    @Select("select * from tb_book where bkID=#{bkID}")
    Book getItemById(int bkID);

    //更新
    @Update("update tb_book set bkCode=#{bkCode},bkName=#{bkName},bkAuthor=#{bkAuthor},bkPress=#{bkPress},bkDatePress=#{bkDatePress},bkISBN=#{bkISBN},bkCatalog=#{bkCatalog},bkLanguage=#{bkLanguage},bkPages=#{bkPages},bkPages=#{bkPages},bkPrice=#{bkPrice},bkDateIn=#{bkDateIn},bkBrief=#{bkBrief},bkCover=#{bkCover},bkStatus=#{bkStatus} where bkID=#{bkID}")
    public void updateBookById(Book book);


    //模糊查找
    @Select("select * from tb_book where bkCode like '%${bkCode}%' and bkName like '%${bkName}%' and bkAuthor like '%${bkAuthor}%'")
    List<Book> getBookByCNA(Book book);


    //根据参数更新数据
    //更新
    @Update("update tb_book set bkCode=#{bkCode},bkName=#{bkName},bkAuthor=#{bkAuthor},bkPress=#{bkPress},bkDatePress=#{bkDatePress},bkISBN=#{bkISBN},bkCatalog=#{bkCatalog},bkLanguage=#{bkLanguage},bkPages=#{bkPages},bkPages=#{bkPages},bkPrice=#{bkPrice},bkDateIn=#{bkDateIn},bkBrief=#{bkBrief},bkCover=#{bkCover},bkStatus=#{bkStatus} where bkID=#{bkID}")
    public void upBookStu(Book book);


}
