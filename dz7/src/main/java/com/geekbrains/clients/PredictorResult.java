package com.geekbrains.clients;

import lombok.Data;

import java.util.List;

@Data
public class PredictorResult {

    private Boolean endOfWord;
    private Integer pos;
    private List<String> text;

}
