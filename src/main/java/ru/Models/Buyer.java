package ru.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nickname")
    private String nickName;

    @OneToMany(mappedBy = "buyer")
    private List<Bucket> bucket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<Bucket> getBucket() {
        return bucket;
    }

    public void setOrders(List<Bucket> buckets) {
        this.bucket = bucket;
    }

    @Override
    public String toString() {
        return "Buyer - " +
                "id=" + id +
                ", NickName='" + nickName + "'}";
    }
}
