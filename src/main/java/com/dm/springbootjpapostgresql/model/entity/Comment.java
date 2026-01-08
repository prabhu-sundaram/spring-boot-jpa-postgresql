package com.dm.springbootjpapostgresql.model.entity;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String email;
    private String body;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    // Getter and Setter methods for Post entity
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    // public String getPostTitle() { // Avoid accessing post directly
    //     if (post != null) {
    //         return post.getTitle();
    //     }
    //     return null;
    // }
        
}
