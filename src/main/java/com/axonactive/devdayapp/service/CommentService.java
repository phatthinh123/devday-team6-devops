package com.axonactive.devdayapp.service;

import java.util.List;

import com.axonactive.devdayapp.dto.CommentDto;

public interface CommentService {
	public List<CommentDto> getCommentByBookId(long bookId);
}

