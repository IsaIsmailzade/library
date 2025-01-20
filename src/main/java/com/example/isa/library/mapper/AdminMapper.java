package com.example.isa.library.mapper;

import com.example.isa.library.dto.AdminDto;
import com.example.isa.library.entity.Admins;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AdminMapper implements Mapper<Admins, AdminDto> {

    @Getter
    private static final AdminMapper INSTANCE = new AdminMapper();

    @Override
    public AdminDto mapFrom(Admins admins) {
        return AdminDto.builder()
                .email(admins.getEmail())
                .build();
    }
}
