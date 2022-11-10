package com.mustache.springbootmustachebbs.domain.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class ReplyDto {

    private String writer;
    private String comment;
}
