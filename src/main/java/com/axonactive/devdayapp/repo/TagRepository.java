package com.axonactive.devdayapp.repo;

import com.axonactive.devdayapp.domain.Tag;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {}

