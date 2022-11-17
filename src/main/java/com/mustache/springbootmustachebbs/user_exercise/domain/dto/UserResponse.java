package com.mustache.springbootmustachebbs.user_exercise.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class UserResponse {
    private Long id;
    private String username;
    private String message;
}
