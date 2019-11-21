package com.axonactive.devdayapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axonactive.devdayapp.domain.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	@Query(value = "SELECT r FROM Comment r WHERE r.parent.id = ?1")
	List<Comment> findChildComments(Long bookDetailId);

}

