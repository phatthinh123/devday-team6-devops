package com.axonactive.devdayapp.util;

import com.axonactive.devdayapp.domain.Rating;
import com.axonactive.devdayapp.dto.RatingDto;
import com.axonactive.devdayapp.dto.UserDto;

public class RatingUtil {
public static RatingDto toRatingDto(Rating rating) {
	if(null == rating) {
		return null;
	}else {
		RatingDto dto = new RatingDto();
		dto.setId(rating.getId());
		dto.setValue(rating.getValue());
		UserDto userDto = new UserDto();
		userDto.setId(rating.getUser().getId());
		userDto.setEmail(rating.getUser().getEmail());
		userDto.setFullName(rating.getUser().getFullName());
		dto.setUser(userDto);
		return dto;
	}
}
}
