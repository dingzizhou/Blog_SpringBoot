package com.example.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Condition {
    private Integer current;
    private String keywords;
    private Integer categoryId;
    private Integer tagId;
    private Integer isTop;
}
