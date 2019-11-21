package com.axonactive.devdayapp.util;

import com.axonactive.devdayapp.domain.Tag;
import com.axonactive.devdayapp.dto.TagDto;

public class TagUtil {
	public static TagDto toTagDto(Tag tag) {
		if(null == tag) {
			return null;
		}else {
			TagDto dto = new TagDto();
			dto.setId(tag.getId());
			dto.setName(tag.getName());
			return dto;
		}
	}
}
