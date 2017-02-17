package com.iqmsoft.boot.mybatis.repository;

import java.util.List;

import com.iqmsoft.boot.mybatis.model.entity.BookStore;
import com.iqmsoft.boot.mybatis.model.entity.BookStoreWithBooks;


public interface BookStoreRepository {

    BookStore selectBookStoreById(Long id);

    List<BookStore> selectAllBookStores();

    BookStoreWithBooks selectBookStoreWithBooksById(Long id);

}
