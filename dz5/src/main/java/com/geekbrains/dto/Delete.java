package com.geekbrains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@NoArgsConstructor
@AllArgsConstructor
public class Delete {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    //private Integer price;
}
