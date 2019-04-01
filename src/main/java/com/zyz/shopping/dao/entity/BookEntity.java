package com.zyz.shopping.dao.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "t_book", schema = "duangduang", catalog = "")
public class BookEntity {
    private int id;
    private String title;
    private String name;
    private String desc;
    private String press;
    private int type;
    private BigDecimal price;
    private String img;
    private int remain;
    private String author;
    private BigDecimal fakePrice;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "press")
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    @Basic
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "remain")
    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "fake_price")
    public BigDecimal getFakePrice() {
        return fakePrice;
    }

    public void setFakePrice(BigDecimal fakePrice) {
        this.fakePrice = fakePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return id == that.id &&
                type == that.type &&
                remain == that.remain &&
                Objects.equals(title, that.title) &&
                Objects.equals(name, that.name) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(press, that.press) &&
                Objects.equals(price, that.price) &&
                Objects.equals(img, that.img) &&
                Objects.equals(author, that.author) &&
                Objects.equals(fakePrice, that.fakePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, name, desc, press, type, price, img, remain, author, fakePrice);
    }
}
