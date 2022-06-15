package ru.geekbrains.db.model;

import ru.geekbrains.dto.Product;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    public Categories() {
    }
    public Categories(String title) {
        this.title = title;
    }
    public Categories(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    private Integer id;

    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}