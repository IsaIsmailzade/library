package com.example.isa.library.mapper;

import com.example.isa.library.dto.CreateBookDto;
import com.example.isa.library.entity.Books;
import lombok.Getter;

public class CreateBookMapper implements Mapper<CreateBookDto, Books> {

    @Getter
    private static final CreateBookMapper INSTANCE = new CreateBookMapper();

    @Override
    public Books mapFrom(CreateBookDto createBookDto) {
        return Books.builder()
                .title(createBookDto.getTitle())
                .author(createBookDto.getAuthor())
                .description(createBookDto.getDescription())
                .build();
    }
}
