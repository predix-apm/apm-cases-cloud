package com.ge.apm.cases.catalog.repositories;

import com.ge.apm.cases.catalog.domain.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Long> {
    Genre findByMlId(String mlId);
}
