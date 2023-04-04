package com.luv2code.springbootlibrary.controller;

import com.luv2code.springbootlibrary.dao.BookRepository;
import com.luv2code.springbootlibrary.dao.ReviewRepository;
import com.luv2code.springbootlibrary.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping
    public String getTest(Pageable pageable) {
        Page<Review> reviews = reviewRepository.findByBookId(4L, pageable);
        System.out.println(reviews.getContent().get(0));
        return  "Hola";
    }
}
