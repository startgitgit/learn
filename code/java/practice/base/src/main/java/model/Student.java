package model;

import lombok.Builder;

import lombok.ToString;

@Builder
@ToString
public class Student {
    private Integer no;
    private String name;
}
