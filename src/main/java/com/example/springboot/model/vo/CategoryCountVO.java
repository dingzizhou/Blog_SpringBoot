package com.example.springboot.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCountVO {

    private Integer id;
    private String name;
    private Integer count;

}
