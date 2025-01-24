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
                .downloadFb2(createBookDto.getDownloadFb2())
                .downloadEpub(createBookDto.getDownloadEpub())
                .downloadPdf(createBookDto.getDownloadPdf())
                .downloadDocx(createBookDto.getDownloadDocx())
                .downloadMobi(createBookDto.getDownloadMobi())
                .build();
    }
}
