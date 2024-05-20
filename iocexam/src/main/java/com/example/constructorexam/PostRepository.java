package com.example.constructorexam;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PostRepository {
    private List<Post> posts = new ArrayList<>();

    public void save(Post post) {
        posts.add(post);
    }

    public Optional<Post> findById(Long id) {
        return posts.stream().filter(post -> post.getId().equals(id)).findFirst();
    }

    public List<Post> findAll() {
        return posts;
    }
}
