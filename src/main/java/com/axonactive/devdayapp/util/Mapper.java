package com.axonactive.devdayapp.util;

import org.modelmapper.ModelMapper;

public class Mapper {

    public static <T> T map(Object original, Class<T> targetType) {
        return MapperKeeper.mapper.map(original, targetType);
    }

    private static class MapperKeeper {
        private static ModelMapper mapper = new ModelMapper();
    }
}

