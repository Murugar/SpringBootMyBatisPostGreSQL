package com.iqmsoft.boot.mybatis.service;

import java.util.List;
import java.util.Optional;

import com.iqmsoft.boot.mybatis.model.entity.BookStore;
import com.iqmsoft.boot.mybatis.model.entity.BookStoreWithBooks;


public interface BookStoreService {

    Optional<BookStore> getBookStoreById(Long id);

    List<String> getAllBookStoreNames();

    Optional<BookStoreWithBooks> getBookStoreWithBooksById(Long id);

}
