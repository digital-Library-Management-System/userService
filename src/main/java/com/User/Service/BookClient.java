package com.User.Service;

import com.User.Service.dto.BookResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@FeignClient(name ="book-service", url = "http://localhost:8080", path = "/bookService")
public interface BookClient {

    @GetMapping("/all")
    List<BookResponseDto> getAll();
}
