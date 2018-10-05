package com.github.vrcca.springboottraining;

import com.github.vrcca.springboottraining.domain.BlogService;
import com.github.vrcca.springboottraining.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;

@EnableAutoConfiguration
@ComponentScan
public class App {

    public static void main(String[] args) {
        // registers and configures everything
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(App.class, args);

        // getBean BlogService
        final BlogService manuallyRetrievedBlogService = applicationContext.getBean(BlogService.class);

        // use it
        manuallyRetrievedBlogService.listAll().forEach(App::printPost);
    }

    @Autowired
    private BlogService fieldInjectedBlogService;

    @PostConstruct
    public void run() {
        // use it
        fieldInjectedBlogService.listAll().forEach(App::printPost);
    }

    private static void printPost(Post post) {
        System.out.println(post.getId() + " - " + post.getTitle());
        System.out.println(post.getBody());
        System.out.println();
    }
}
