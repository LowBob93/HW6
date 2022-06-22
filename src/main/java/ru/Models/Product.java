package ru.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private double cost;

    @OneToMany(mappedBy = "product")
    private List<Bucket> bucket;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<Bucket> getOrders() {
        return bucket;
    }

    public void setOrders(List<Bucket> bucket) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "Product ID = " + id +
                ", title='" + name + ' ' +
                ", cost=" + cost ;
    }
}