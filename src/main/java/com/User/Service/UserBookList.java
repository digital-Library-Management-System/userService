package com.User.Service;

import com.User.Service.dto.BookResponseDto;
import com.User.Service.entities.User;
import org.mapstruct.Context;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBookList {

    @Autowired
    private BookClient bookClient;

    @Named("resolveBookListWithPageable")
    public List<BookResponseDto> resolve(User user, @Context Pageable pageable) {
        return bookClient.getAll(pageable);
    }
}
