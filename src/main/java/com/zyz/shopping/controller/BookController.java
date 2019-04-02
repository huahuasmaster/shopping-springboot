package com.zyz.shopping.controller;

import com.zyz.shopping.dao.BookRepository;
import com.zyz.shopping.dao.entity.BookEntity;
import com.zyz.shopping.http.DuangDuangResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("duangduang/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public DuangDuangResponse<List> listAll() {
        return DuangDuangResponse.success(bookRepository.findAll());
    }

    @GetMapping("/{bookId}")
    public DuangDuangResponse<BookEntity> get(@PathVariable("bookId") Integer bookId) {
        return DuangDuangResponse.success(bookRepository.getOne(bookId));
    }
}
