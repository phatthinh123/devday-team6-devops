package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.RatingRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultRatingService implements RatingService {
    private static final Logger log = LogManager.getLogger(DefaultRatingService.class);
    @Autowired
    private RatingRepository ratingRepo;
}

