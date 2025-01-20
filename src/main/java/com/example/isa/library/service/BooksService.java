package com.example.isa.library.service;

import com.example.isa.library.dao.BooksDao;
import com.example.isa.library.dto.BookDto;
import com.example.isa.library.dto.CreateBookDto;
import com.example.isa.library.entity.Books;
import com.example.isa.library.mapper.CreateBookMapper;

import java.util.List;
import java.util.stream.Collectors;

public class BooksService {

    private static final BooksService INSTANCE = new BooksService();
    private final BooksDao booksDao = BooksDao.getInstance();
    CreateBookMapper createBookMapper = CreateBookMapper.getINSTANCE();

    public List<BookDto> findAll() {
        return booksDao.findAll().stream()
                .map(books -> BookDto.builder()
                        .title(books.getTitle())
                        .build())
                .collect(Collectors.toList());
    }

    public void create(CreateBookDto createBookDto) {
        Books books = createBookMapper.mapFrom(createBookDto);
        booksDao.save(books);
    }

    public static BooksService getInstance() {
        return INSTANCE;
    }
}
