package com.dm.springbootjpapostgresql.model;

import java.util.ArrayList;
//import java.util.HashSet;
import java.util.List;
//import java.util.List;
//import java.util.Set;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.dm.springbootjpapostgresql.dto.PostRecord;
import com.dm.springbootjpapostgresql.dto.CommentRecord;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "content", nullable = false)
	private String content;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;	

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPost(this); // Set the inverse attribute explicitly
    }	
    public void addComments(List<Comment> comments) {
		this.comments = comments;
		comments.forEach(comment -> comment.setPost(this));
    }	
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }	
    public void removeComments(List<Comment> comments) {
        this.comments = comments;
        comments.forEach(comment -> comment.setPost(null));
    }

    // Getter and Setter methods for Category entity
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }    
    
    public PostRecord toRecord() {
        return new PostRecord(
            id,
            title,
            description,
            content,
            comments.stream().map(comment ->
                new CommentRecord(
                    comment.getId(),
                    comment.getName(),
                    comment.getEmail(),
                    comment.getBody()
                )
            ).toList()
        );
    }    
}