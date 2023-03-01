package com.example.demo_product.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NamedQuery(name = "findAll", query = "SELECT p from Product AS p")
public class Product {
    @Id //annotation đánh dấu khoá chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)

    //annotation hỗ trợ chỉnh sửa thông tin field DB, thêm constrain (ràng buộc)
    @Size(min = 3,max = 10)
    private String name;
    private Double price;
    private String description;
    private String imgPath;
    @Transient
    private MultipartFile img;

    public Product() {
    }

    public Product(String name, Double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Product(String name, Double price, String description, String imgPath, MultipartFile img) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.imgPath = imgPath;
        this.img = img;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public MultipartFile getImg() {
        return img;
    }

    public void setImg(MultipartFile img) {
        this.img = img;
    }
}
