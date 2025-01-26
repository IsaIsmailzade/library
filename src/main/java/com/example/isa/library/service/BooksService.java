package com.example.isa.library.service;

import com.example.isa.library.dao.BooksDao;
import com.example.isa.library.dto.BookDto;
import com.example.isa.library.dto.CreateBookDto;
import com.example.isa.library.entity.Books;
import com.example.isa.library.exception.ValidationException;
import com.example.isa.library.mapper.CreateBookMapper;
import com.example.isa.library.validator.CreateBookValidator;
import com.example.isa.library.validator.DeleteBookValidator;
import com.example.isa.library.validator.ValidationResult;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class BooksService {

    private static final BooksService INSTANCE = new BooksService();
    private final BooksDao booksDao = BooksDao.getInstance();
    CreateBookMapper createBookMapper = CreateBookMapper.getINSTANCE();
    DeleteBookValidator deleteBookValidator = DeleteBookValidator.getINSTANCE();
    CreateBookValidator createBookValidator = CreateBookValidator.getINSTANCE();

    public List<BookDto> findAll() {
        return booksDao.findAll().stream()
                .map(books -> BookDto.builder()
                        .id(books.getId())
                        .title(books.getTitle())
                        .author(books.getAuthor())
                        .description(books.getDescription())
                        .downloadFb2(books.getDownloadFb2())
                        .downloadEpub(books.getDownloadEpub())
                        .downloadPdf(books.getDownloadPdf())
                        .downloadDocx(books.getDownloadDocx())
                        .downloadMobi(books.getDownloadMobi())
                        .read(books.getRead())
                        .build())
                .collect(Collectors.toList());
    }

    public Optional<Books> findById(Long id) {
        return booksDao.findById(id);
    }

    public void create(CreateBookDto createBookDto) {
        ValidationResult validationResult = createBookValidator.isValid(createBookDto);
        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
        }
        Books books = createBookMapper.mapFrom(createBookDto);
        booksDao.save(books);
    }

    public void delete(Long id) {
        ValidationResult validationResult = deleteBookValidator.isValid(id.toString());

        if (!validationResult.isValid()) {
            throw new ValidationException(validationResult.getErrors());
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
