package com.example.springboot.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagCountVO {

    private String name;
    private Integer id;
    private Integer count;

}
