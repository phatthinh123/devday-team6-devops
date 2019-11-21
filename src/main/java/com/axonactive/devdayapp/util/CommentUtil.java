package com.axonactive.devdayapp.util;

import com.axonactive.devdayapp.domain.Comment;
import com.axonactive.devdayapp.dto.CommentDto;
import com.axonactive.devdayapp.dto.UserDto;

public class CommentUtil {
	public static CommentDto toCommentDto(Comment comment) {
		if(null == comment) {
			return null;
		}else {
			CommentDto dto = new CommentDto();
			dto.setId(comment.getId());
			dto.setContent(comment.getContent());
			dto.setUser(UserDto.fromEntity(comment.getUser()));
			if(comment.getParent() != null)
			dto.setParentId(comment.getParent().getId());
			return dto;
		}
	}
}
