package com.geekbrains.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Category {
    private Integer id;
    private String title;
    private List<Product> products = new ArrayList<>();
}
