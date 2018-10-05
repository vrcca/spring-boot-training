package com.github.vrcca.springboottraining.application;

import com.github.vrcca.springboottraining.domain.Post;
import com.github.vrcca.springboottraining.domain.PostRepository;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.util.Arrays.asList;

@Component
public class InMemoryPostRepository implements PostRepository {

    @Override
    public List<Post> listAll() {
        return asList(
                new Post(1, "Hello World", "This is my first post!"),
                new Post(2, "Another one", "This is another post! huehue")
        );
    }
}
