package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.TagRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultTagService implements TagService {
    private static final Logger log = LogManager.getLogger(DefaultTagService.class);
    
    @Autowired
    private TagRepository tagRepo;
}

