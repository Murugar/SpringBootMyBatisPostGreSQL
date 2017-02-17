package com.iqmsoft.boot.mybatis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iqmsoft.boot.mybatis.model.entity.BookStore;
import com.iqmsoft.boot.mybatis.model.entity.BookStoreWithBooks;
import com.iqmsoft.boot.mybatis.repository.BookStoreRepository;
import com.iqmsoft.boot.mybatis.service.BookStoreService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreRepository bookStoreRepository;

    @Autowired
    public BookStoreServiceImpl(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    @Override
    public Optional<BookStore> getBookStoreById(Long id) {
        return Optional.ofNullable(bookStoreRepository.selectBookStoreById(id));
    }

    @Override
    public List<String> getAllBookStoreNames() {
        return bookStoreRepository
                .selectAllBookStores()
                .stream()
                .map(BookStore::getName)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookStoreWithBooks> getBookStoreWithBooksById(Long id) {
        return Optional.ofNullable(bookStoreRepository.selectBookStoreWithBooksById(id));
    }
}
