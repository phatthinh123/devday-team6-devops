package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.BookDetail;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface BookDetailRepository extends CrudRepository<BookDetail, Long> {}

