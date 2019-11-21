package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Rating;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    
    @Query(value = "SELECT r FROM Rating r WHERE r.user.id = ?1 AND r.bookDetail.id = ?2")
    Rating findRatingByUserIdAndBookDetailId(Long userId, Long bookDetailId);
}

