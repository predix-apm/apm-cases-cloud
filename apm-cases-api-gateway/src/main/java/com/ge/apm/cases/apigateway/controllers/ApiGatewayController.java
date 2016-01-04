package com.ge.apm.cases.apigateway.controllers;

import com.ge.apm.cases.apigateway.domain.MovieDetails;
import com.ge.apm.cases.apigateway.services.cases.CaseIntegrationService;
import com.ge.apm.cases.apigateway.services.catalog.CatalogIntegrationService;
import com.ge.apm.cases.apigateway.services.reviews.ReviewsIntegrationService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import rx.Observable;
import rx.Observer;

import java.security.Principal;

@RestController
public class ApiGatewayController {

    Log log = LogFactory.getLog(ApiGatewayController.class);

    @Autowired
    CatalogIntegrationService catalogIntegrationService;

    @Autowired
    ReviewsIntegrationService reviewsIntegrationService;

    @Autowired
    CaseIntegrationService caseIntegrationService;

    @RequestMapping("/movie/{mlId}")
    public DeferredResult<MovieDetails> movieDetails(@PathVariable String mlId) {

        log.debug(String.format("Loading anonymous movie details for mlId: %s", mlId));

        Observable<MovieDetails> movieDetails = anonymousMovieDetails(mlId);
        return toDeferredResult(movieDetails);
    }

    private Observable<MovieDetails> anonymousMovieDetails(String mlId) {
        return Observable.zip(
                catalogIntegrationService.getMovie(mlId),
                reviewsIntegrationService.reviewsFor(mlId),
                caseIntegrationService.getCase(mlId),
                (movie, reviews, aCase) -> {
                    MovieDetails movieDetails = new MovieDetails();
                    movieDetails.setMlId(movie.getMlId());
                    movieDetails.setTitle(movie.getTitle());
                    movieDetails.setReviews(reviews);
                    movieDetails.setGenres(movie.getGenres());
                    movieDetails.setCaseTitle(aCase.getTitle());
                    return movieDetails;
                }
        );
    }

    public DeferredResult<MovieDetails> toDeferredResult(Observable<MovieDetails> details) {
        DeferredResult<MovieDetails> result = new DeferredResult<>();
        details.subscribe(new Observer<MovieDetails>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onNext(MovieDetails movieDetails) {
                result.setResult(movieDetails);
            }
        });
        return result;
    }


}
