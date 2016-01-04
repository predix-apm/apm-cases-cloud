package com.ge.apm.cases.apigateway.domain;

import com.ge.apm.cases.apigateway.services.catalog.Genre;
import com.ge.apm.cases.apigateway.services.reviews.Review;

import java.util.List;

public class MovieDetails {
    private String       title;
    private String       mlId;
    private List<Review> reviews;
    private List<Genre>  genres;
    private Boolean      likes;
    private String caseTitle;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMlId() {
        return mlId;
    }

    public void setMlId(String mlId) {
        this.mlId = mlId;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public void setLikes(Boolean likes) {
        this.likes = likes;
    }

    public Boolean getLikes() {
        return likes;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getCaseTitle() {
        return caseTitle;
    }
}
