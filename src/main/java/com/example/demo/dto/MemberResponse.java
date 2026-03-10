package com.example.demo.dto;

import java.time.LocalDateTime;

public record MemberResponse (
        Long id,
        String name,
        String email,
        LocalDateTime createdAt
) {
}
