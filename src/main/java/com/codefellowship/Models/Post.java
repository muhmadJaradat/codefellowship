package com.codefellowship.Models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public long id;
    public String body;
    public Date postDate;

    @ManyToOne
    public ApplicationUser user;

    public Post() {}

    public Post(String body, Date postDate) {
        this.body = body;
        this.postDate = postDate;
    }

    public long getId() {
        return id;
    }
}
