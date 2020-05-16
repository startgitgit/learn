package model;

import lombok.Builder;

import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Student {
    private Integer no;
    private String name;
}
