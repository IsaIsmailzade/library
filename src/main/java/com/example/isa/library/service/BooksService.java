package com.example.isa.library.service;

import com.example.isa.library.dao.BooksDao;
import com.example.isa.library.dto.BookDto;
import com.example.isa.library.dto.CreateBookDto;
import com.example.isa.library.entity.Books;
import com.example.isa.library.validator.Error;
import com.example.isa.library.exception.ValidationException;
import com.example.isa.library.mapper.CreateBookMapper;
import com.example.isa.library.validator.DeleteBookValidator;
import com.example.isa.library.validator.ValidationResult;

import java.util.List;
import java.util.stream.Collectors;


public class BooksService {

    private static final BooksService INSTANCE = new BooksService();
    private final BooksDao booksDao = BooksDao.getInstance();
    CreateBookMapper createBookMapper = CreateBookMapper.getINSTANCE();
    DeleteBookValidator deleteBookValidator = DeleteBookValidator.getINSTANCE();

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

    public void delete(Long id) {
        ValidationResult validationResult = deleteBookValidator.isValid(id.toString());

        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }

        if (booksDao.findById(id).isEmpty()) {
            throw new ValidationException(List.of(Error.of("bookId.notFound", "Book with the given ID was not found")));
        }

        boolean deleted = booksDao.delete(id);
        if (!deleted) {
            throw new RuntimeException("Failed to delete the book");
        }
    }

    public static BooksService getInstance() {
        return INSTANCE;
    }
}
