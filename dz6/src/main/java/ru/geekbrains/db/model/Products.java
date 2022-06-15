package ru.geekbrains.db.model;

public class Products {
    public Products(String title, Integer price, long category_id){
        this.title = title;
        this.price = price;
        this.category_id = category_id;
    }
    public Products(long id, String title, Integer price, long category_id){
        this.id = id;
        this.title = title;
        this.price = price;
        this.category_id = category_id;
    }

    private Long id;

    private String title;

    private Integer price;

    private Long category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }
}