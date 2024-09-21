package com.example.product_service.mapper;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class StringToUUID {
    public static UUID toUUID(String input){
        return UUID.nameUUIDFromBytes(input.getBytes(StandardCharsets.UTF_8));
    }
}
