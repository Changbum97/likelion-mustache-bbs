package com.mustache.springbootmustachebbs.user_exercise.domain.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public class UserAddRequest {
    private String username;
    private String password;
}
