package com.github.vrcca.springboottraining.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogService {

    private final PostRepository repository;

    @Autowired // optional annotation, because there is only 1 constructor
    public BlogService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> listAll() {
        return repository.listAll();
    }
}
