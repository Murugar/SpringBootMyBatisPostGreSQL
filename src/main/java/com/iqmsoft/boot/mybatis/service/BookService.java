package com.iqmsoft.boot.mybatis.service;

import java.util.List;
import java.util.Optional;

import com.iqmsoft.boot.mybatis.model.entity.Book;
import com.iqmsoft.boot.mybatis.model.entity.BookWithBookStore;


public interface BookService {

    Optional<Book> getBookById(Long id);

    List<Book> getBooksByAuthor(String author);

    List<Book> getBooksByPage(Integer page, Integer perPage);

    List<String> getAllBookNames();

    Optional<BookWithBookStore> getBookWithBookStoreById(Long id);

    Integer getTotalPage(Integer perPage);

    boolean saveBook(Book book);

    boolean modifyBookOnNameById(Book book);

    boolean deleteBookById(Long id);

}
