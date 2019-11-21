package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.dto.CommentDto;

public interface BookDetailService {

    boolean rateABook(Long userId, Long bookDetailId, Integer point);

    boolean unrateABook(Long userId, Long bookDetailId);

    CommentDto addComment(Long userId, Long bookDetailId, Long parentCommentId, String comment);

    CommentDto editComment(Long commentId, String comment);

    boolean removeComment(Long userId);
}