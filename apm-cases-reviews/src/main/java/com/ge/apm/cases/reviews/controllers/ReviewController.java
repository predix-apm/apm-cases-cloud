package com.ge.apm.cases.reviews.controllers;

import com.ge.apm.cases.reviews.domain.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
//public class ReviewController extends ResourceServerConfigurerAdapter {
public class ReviewController {
    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public Iterable<Review> reviews() {
        Review review = new Review();
        review.setId("100");
        review.setMlId("100");
        review.setRating(5);
        review.setReview("Excellent!, Mind-blowing!, Awesome!");
        review.setUserName("Joya");

        //return reviewRepository.findAll();
        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);

        review = new Review();
        review.setId("101");
        review.setMlId("101");
        review.setUserName("Monideepa");
        reviewList.add(review);

        review = new Review();
        review.setId("102");
        review.setMlId("102");
        review.setUserName("Leah");
        reviewList.add(review);

        review = new Review();
        review.setId("103");
        review.setMlId("103");
        review.setUserName("Tali");
        reviewList.add(review);

        review = new Review();
        review.setId("104");
        review.setMlId("104");
        review.setUserName("Padme");
        reviewList.add(review);
        return reviewList;

    }

    @RequestMapping(value = "/reviews/{mlId}", method = RequestMethod.GET)
    public Iterable<Review> reviews(@PathVariable String mlId) {
        Review review = new Review();
        switch (mlId) {
            case "100":
                review.setId("100");
                review.setMlId("100");
                review.setUserName("Joya");
                break;

            case "101":
                review.setId("101");
                review.setMlId("101");
                review.setUserName("Kalpana");
                break;

            case "102":
                review.setId("102");
                review.setMlId("102");
                review.setUserName("Latha");
                break;

            case "103":
                review.setId("103");
                review.setMlId("103");
                review.setUserName("Madhumitha");
                break;

            case "104":
                review.setId("104");
                review.setMlId("104");
                review.setUserName("Namitha");
                break;

            default:
                review.setId("999");
                review.setMlId("999");
                review.setUserName("Sandhya");
                break;
        }

        List<Review> reviewList = new ArrayList<>();
        reviewList.add(review);
        return reviewList;
    }

    @RequestMapping(value = "/reviews", method = RequestMethod.POST)
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        //reviewRepository.save(review);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }
}
