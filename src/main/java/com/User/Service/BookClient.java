package com.User.Service;

import com.User.Service.dto.BookResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name ="book-service", url = "http://localhost:8080", path = "/bookService")
public interface BookClient {

    @GetMapping
    ResponseEntity<Page<BookResponseDto>> getAllBooks(@RequestParam int page, @RequestParam int size);
}
