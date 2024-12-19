package com.example.isa.library.service;

import com.example.isa.library.dao.BooksDao;
import com.example.isa.library.dto.BooksDto;

import java.util.List;
import java.util.stream.Collectors;

public class BooksService {

    private static final BooksService INSTANCE = new BooksService();
    private final BooksDao booksDao = BooksDao.getInstance();

    public List<BooksDto> findAll() {
        return booksDao.findAll().stream()
                .map(books -> BooksDto.builder()
                        .title(books.getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    public static BooksService getInstance() {
        return INSTANCE;
    }
}
